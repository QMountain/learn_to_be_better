package algorithm.leetcode.medium.s;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        int length = nums.length;
        List<List<Integer>> resList = new ArrayList<>(length*length);
        int max = 1;
        for (int i = 0; i < length; i++) {
            max *= 2;
        }
        for (int i = 0; i < max; i++) {
            String string = Integer.toBinaryString(i);
            int strLen = string.length();
            List<Integer> list = new ArrayList<>(strLen);
            int minus = 0;
            while (minus < strLen) {
                char c = string.charAt(strLen-1 - minus);
                if (c == '1') {
                    list.add(nums[length-1-minus]);
                }
                minus++;
            }
            resList.add(list);
        }
        return resList;
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        System.out.println(subsets.subsets(new int[]{1,2,3}));
    }
}
