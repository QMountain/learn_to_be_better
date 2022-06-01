package algorithm.leetcode.medium.n;

import java.util.Arrays;

public class NumSquares {

    public int numSquares(int n) {
        int pow = (int)Math.sqrt(n);
        if (n == pow*pow) {
            return 1;
        }
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        int min = n;
        for (int i = 1; i <= pow; i++) {
            int ns = numSquares(n - i * i, dp);
            min = Math.min(min,ns);
        }
        return min+1;
    }

    public int numSquares(int n, int[] dp) {
        int pow = (int)Math.sqrt(n);
        if (n == pow*pow) {
            return 1;
        }
        if (dp[n-1] != -1) {
            return dp[n-1];
        }
        int min = n;
        for (int i = 1; i <= pow; i++) {
            int ns;
            if (dp[n-i*i-1] != -1) {
                ns = dp[n-i*i-1];
            } else {
                ns = numSquares(n - i * i, dp);
            }
            min = Math.min(min,ns);
        }
        dp[n-1] = min+1;
        return min+1;
    }

    public static void main(String[] args) {
        NumSquares numSquares = new NumSquares();
        System.out.println(numSquares.numSquares(13));
        System.out.println(numSquares.numSquares(12));
    }
}
