package algorithm.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindRelativeRanks {

    public String[] findRelativeRanks(int[] score) {
        int length = score.length;
        int[] arr = new int[length];
        System.arraycopy(score,0,arr,0,length);
        Arrays.sort(arr);
        Map<Integer,String> map = new HashMap<>();
        map.put(arr[length-1],"Gold Medal");
        if (length > 1) {
            map.put(arr[length-2],"Silver Medal");
        }
        if (length > 2) {
            map.put(arr[length-3],"Bronze Medal");
        }
        for (int i = length-4; i >= 0; i--) {
            map.put(arr[i],(length-i)+"");
        }
        String[] strings = new String[length];
        for (int i = 0; i < length; i++) {
            strings[i] = map.get(score[i]);
        }
        return strings;
    }

    public static void main(String[] args) {
        FindRelativeRanks findRelativeRanks = new FindRelativeRanks();
        System.out.println(Arrays.toString(findRelativeRanks.findRelativeRanks(new int[]{5,4,3,2,1})));
    }
}
