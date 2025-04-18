package algorithm.leetcode.medium.c;

import java.util.*;

public class CountBadPairs {

    /**
     * 给你一个下标从 0 开始的整数数组 nums 。
     * 如果 i < j 且 j - i != nums[j] - nums[i] ，那么我们称 (i, j) 是一个 坏数对 。
     * 请你返回 nums 中 坏数对 的总数目。
     * -------------------------------------------------
     * 1 <= nums.length <= 10^5
     * 1 <= nums[i] <= 10^9
     */
    public long countBadPairs(int[] nums) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 1);
        long ans = 0;
        for (int i = 1; i < length; i++) {
            Integer v = map.getOrDefault(nums[i]-i, 0);
            ans += i - v;
            map.put(nums[i]-i, v+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        CountBadPairs countBadPairs = new CountBadPairs();
        System.out.println(5 == countBadPairs.countBadPairs(new int[]{4,1,3,3}));
    }
}
