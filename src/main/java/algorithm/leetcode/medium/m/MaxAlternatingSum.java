package algorithm.leetcode.medium.m;

public class MaxAlternatingSum {

    // 优化后，空间复杂度从O(n) -> O(1)，近乎最优解
    public long maxAlternatingSum(int[] nums) {
        // 0 前边2N个数的max
        // 1 前边2N+1 个数的max
        int length = nums.length;
        long last2N = 0;
        long last2N1 = nums[0];
        for (int i = 1; i < length; i++) {
            long n2n = last2N1 - nums[i];
            long b2n = Math.max(n2n, last2N);
            long n2n1 = last2N + nums[i];
            long b2n1 = Math.max(n2n1, last2N1);
            last2N = b2n;
            last2N1 = b2n1;
        }
        return Math.max(last2N, last2N1);
    }

    // 1 <= nums.length <= 105
    // 1 <= nums[i] <= 105
    public long maxAlternatingSum2(int[] nums) {
        // 0 前边2N个数的max
        // 1 前边2N+1 个数的max
        int length = nums.length;
        long[][] dp = new long[length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < length; i++) {
            long n2n = dp[i - 1][1] - nums[i];
            long b2n = Math.max(n2n, dp[i-1][0]);
            dp[i][0] = b2n;
            long n2n1 = dp[i-1][0] + nums[i];
            long b2n1 = Math.max(n2n1, dp[i-1][1]);
            dp[i][1] = b2n1;
        }
        return Math.max(dp[length-1][0], dp[length-1][1]);
    }

    public static void main(String[] args) {
        MaxAlternatingSum maxAlternatingSum = new MaxAlternatingSum();
        System.out.println(10 == maxAlternatingSum.maxAlternatingSum(new int[]{6,2,1,2,4,5}));
        System.out.println(8 == maxAlternatingSum.maxAlternatingSum(new int[]{5,6,7,8}));
        System.out.println(7 == maxAlternatingSum.maxAlternatingSum(new int[]{4,2,5,3}));
    }
}
