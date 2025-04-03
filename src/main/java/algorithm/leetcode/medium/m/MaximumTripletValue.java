package algorithm.leetcode.medium.m;

/**
 * 给你一个下标从 0 开始的整数数组 nums 。
 * 请你从所有满足 i < j < k 的下标三元组 (i, j, k) 中，
 * 找出并返回下标三元组的最大值。如果所有满足条件的三元组的值都是负数，则返回 0 。
 * 下标三元组 (i, j, k) 的值等于 (nums[i] - nums[j]) * nums[k] 。
 */
public class MaximumTripletValue {

    public long maximumTripletValue(int[] nums) {
        long ans = 0;
        long iMax = 0;
        long diffMax = 0;
        for (int num : nums) {
            ans = Math.max(ans, diffMax * num);
            diffMax = Math.max(diffMax, iMax - num);
            iMax = Math.max(iMax, num);
        }
        return ans;
    }

}
