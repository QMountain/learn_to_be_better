package algorithm.leetcode.hard.c;

import java.util.*;

public class CountSmaller {

    public List<Integer> countSmaller(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int length = nums.length;
        map.put(nums[length-1],1);
        List<Integer> list = new ArrayList<>(length);
        list.add(0);
        for (int i = length-2; i >= 0; i--) {
            int count = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getKey() < nums[i]) {
                    count += entry.getValue();
                } else {
                    break;
                }
            }
            list.add(0,count);
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        return list;
    }

    public static void main(String[] args) {
        CountSmaller countSmaller = new CountSmaller();
        System.out.println(countSmaller.countSmaller(new int[]{1,9,7,8,5}));
        System.out.println(countSmaller.countSmaller(new int[]{2,0,1}));
        System.out.println(countSmaller.countSmaller(new int[]{-1,-1}));
        System.out.println(countSmaller.countSmaller(new int[]{-1}));
        System.out.println(countSmaller.countSmaller(new int[]{5,2,6,1}));
    }
}
