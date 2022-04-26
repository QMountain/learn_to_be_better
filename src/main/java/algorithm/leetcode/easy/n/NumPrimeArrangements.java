package algorithm.leetcode.easy.n;

public class NumPrimeArrangements {

    public int numPrimeArrangements(int n) {
        // 统计 1-n 有多少个质数
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i-1] + (isPrime(i+1) ? 1 : 0);
        }
        int primeCount = dp[n-1];
        int notPrimeCount = n-primeCount;
        // 质数的排列 + 非质数的排列
        int mod = 1000_000_007;
        long count1 = 1;
        for (int i = 2; i <= primeCount; i++) {
            count1 *= i;
            if (count1 >= mod) {
                count1 = count1 % mod;
            }
        }
        long count2 = 1;
        for (int i = 2; i <= notPrimeCount; i++) {
            count2 *= i;
            if (count2 >= mod) {
                count2 = count2 % mod;
            }
        }
        return (int)(count1*count2%mod);
    }

    public boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NumPrimeArrangements numPrimeArrangements = new NumPrimeArrangements();
        System.out.println(numPrimeArrangements.numPrimeArrangements(100));
        System.out.println(numPrimeArrangements.numPrimeArrangements(5));
    }
}
