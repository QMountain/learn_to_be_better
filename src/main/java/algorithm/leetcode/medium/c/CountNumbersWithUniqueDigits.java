package algorithm.leetcode.medium.c;

public class CountNumbersWithUniqueDigits {

    public int countNumbersWithUniqueDigits(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = 9;
            int count = 9;
            for (int j = 1; j < i; j++) {
                dp[i] *= count;
                count--;
            }
            dp[i] += dp[i-1];
        }
        return dp[n];
    }

}
