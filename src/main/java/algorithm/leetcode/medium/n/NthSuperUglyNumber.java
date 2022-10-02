package algorithm.leetcode.medium.n;

import java.util.Arrays;

public class NthSuperUglyNumber {

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        int length = primes.length;
        int[] pArr = new int[length];
        Arrays.fill(pArr,1);
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < length; j++) {
                if (dp[pArr[j]] <= Integer.MAX_VALUE/primes[j]) {
                    min = Math.min(dp[pArr[j]] * primes[j],min);
                }
            }
            dp[i] = min;
            for (int j = 0; j < length; j++) {
                if (min == dp[pArr[j]] * primes[j]) {
                    pArr[j]++;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        NthSuperUglyNumber nthSuperUglyNumber = new NthSuperUglyNumber();
        System.out.println(nthSuperUglyNumber.nthSuperUglyNumber(12, new int[]{2,7,13,19}));
    }
}
