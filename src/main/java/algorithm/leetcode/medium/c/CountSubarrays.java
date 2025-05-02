package algorithm.leetcode.medium.c;

import java.util.*;

public class CountSubarrays {

    /**
     * 给你一个整数数组 nums 和一个 正整数 k 。
     * 请你统计有多少满足 「 nums 中的 最大 元素」至少出现 k 次的子数组，并返回满足这一条件的子数组的数目。
     * 子数组是数组中的一个连续元素序列。
     * 1 <= nums.length <= 10^5
     * 1 <= nums[i] <= 10^6
     * 1 <= k <= 10^5
     */
    public long countSubarrays(int[] nums, int k) {
        int length = nums.length;
        long ans = 0;
        int max = Arrays.stream(nums).max().getAsInt();
        LinkedList<Integer> list = new LinkedList<>();
        list.add(-1);
        for (int i = 0; i < length; i++) {
            if (nums[i] == max) {
                list.add(i);
                if (list.size() - 1 == k) {
                    Integer polled = list.pollFirst();
                    int left = list.peekFirst() - polled;
                    int right = length - i;
                    ans += (long) left * right;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        CountSubarrays countSubarrays = new CountSubarrays();
        System.out.println(187 == countSubarrays.countSubarrays(
                new int[]{28,5,58,91,24,91,53,9,48,85,16,70,91,91,47,91,61,4,54,61,49}, 1));
        System.out.println(6 == countSubarrays.countSubarrays(new int[]{1,3,2,3,3}, 2));
        System.out.println(0 == countSubarrays.countSubarrays(new int[]{1,4,2,1}, 3));
    }
}
