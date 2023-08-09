package algorithm.leetcode.medium.m;

public class MaxAbsoluteSum {

    public int maxAbsoluteSum(int[] nums) {
        int length = nums.length;
        // 0 不挨着当前元素max
        // 1 挨着，正最大
        // 2 挨着，负最大
        int[][] dp = new int[length][3];
        dp[0][0] = Math.abs(nums[0]);
        dp[0][1] = Math.max(nums[0], 0);
        dp[0][2] = Math.min(nums[0], 0);
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], -dp[i-1][2]));
            if (nums[i] > 0) {
                dp[i][1] = Math.max(dp[i-1][1] + nums[i], nums[i]);
                dp[i][2] = dp[i-1][2] + nums[i];
            } else if (nums[i] < 0) {
                dp[i][1] = dp[i-1][1] + nums[i];
                dp[i][2] = Math.min(dp[i-1][2] + nums[i], nums[i]);
            } else {
                dp[i][1] = dp[i-1][1] + nums[i];
                dp[i][2] = dp[i-1][2] + nums[i];
            }
        }
        return Math.max(dp[length-1][0], Math.max(dp[length-1][1], -dp[length-1][2]));
    }

    public static void main(String[] args) {
        MaxAbsoluteSum maxAbsoluteSum = new MaxAbsoluteSum();
        System.out.println(5 == maxAbsoluteSum.maxAbsoluteSum(new int[]{1,-3,2,3,-4}));
        System.out.println(27 == maxAbsoluteSum.maxAbsoluteSum(new int[]{-3,-5,-3,-2,-6,3,10,-10,-8,-3,0,10,3,-5,8,7,-9,-9,5,-8}));
        System.out.println(8 == maxAbsoluteSum.maxAbsoluteSum(new int[]{2,-5,1,-4,3,-2}));

    }
}
