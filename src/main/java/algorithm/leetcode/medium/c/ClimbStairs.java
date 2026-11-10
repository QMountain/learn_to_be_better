package algorithm.leetcode.medium.c;

public class ClimbStairs {

    /**
     * 3693. 爬楼梯 II
     * 1 <= n == costs.length <= 105
     * 1 <= costs[i] <= 104
     */
    public int climbStairs(int n, int[] costs) {
        int dp1 = costs[0] + 1;
        if (n == 1) {
            return dp1;
        }
        int m1 = costs[0] + 1 + costs[1] + 1;
        int m2 = costs[1] + 4;
        int dp2 = Math.min(m1, m2);
        if (n == 2) {
            return dp2;
        }
        int t1 = costs[2] + 9;
        int t2 = dp2 + costs[2] + 1;
        int t3 = dp1 + costs[2] + 4;
        int dp3 = Math.min(Math.min(t1, t2), t3);
        if (n == 3) {
            return dp3;
        }
        int[] dp = new int[n];
        dp[0] = dp1;
        dp[1] = dp2;
        dp[2] = dp3;
        for (int i = 3; i < n; i++) {
            int dpi1 = dp[i - 3] + 9;
            int dpi2 = dp[i - 2] + 4;
            int dpi3 = dp[i - 1] + 1;
            dp[i] = Math.min(dpi1, Math.min(dpi2, dpi3)) + costs[i];
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        System.out.println(climbStairs.climbStairs(4, new int[]{1, 2, 3, 4}));
    }
}
