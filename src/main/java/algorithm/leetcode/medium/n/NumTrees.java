package algorithm.leetcode.medium.n;

public class NumTrees {

    public int numTrees(int n) {
        if (n <= 2) {
            return n;
        }
        int res = numTrees(n-1)*2;
        for (int i = 2; i < n; i++) {
            res += numTrees(i-1)*numTrees(n-i);
        }
        return res;
    }

    public int numTrees2(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            int res = dp[i-1] * 2;
            for (int j = 2; j <= i; j++) {
                res += dp[j-2] * dp[i-j];
            }
            dp[i] = res;
        }
        return dp[n-1];
    }

}
