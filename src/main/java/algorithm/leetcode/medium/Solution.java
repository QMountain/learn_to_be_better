package algorithm.leetcode.medium;

import java.util.*;

public class Solution {

    private final Map<Integer, List<Integer>> map;

    public Solution(int[] nums) {
        map = new HashMap<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            ArrayList<Integer> list = new ArrayList<>(map.getOrDefault(num, new ArrayList<>()));
            list.add(i);
            map.put(num,list);
        }
    }

    public int pick(int target) {
        List<Integer> list = map.get(target);
        int size = list.size();
        int i = new Random().nextInt(size);
        return list.get(i);
    }

}
