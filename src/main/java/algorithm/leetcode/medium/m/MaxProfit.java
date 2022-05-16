package algorithm.leetcode.medium.m;

import java.util.Arrays;

public class MaxProfit {

    public int maxProfit(int[] prices) {
        int length = prices.length;
        int maxProfit = 0;
        for (int i = 0; i < length-1; i++) {
            if (prices[i+1] > prices[i]) {
                maxProfit += prices[i+1] - prices[i];
            }
        }
        return maxProfit;
    }

    // 有冷冻期的
    public int maxProfitWithFreezing(int[] prices) {
        int length = prices.length;
        int[] lastSoldIndex = new int[length];
        Arrays.fill(lastSoldIndex,-4);
        int[] dp = new int[length];
        for (int i = 1; i < length; i++) {
            if (prices[i] > prices[i-1]) {
                if (lastSoldIndex[i-1] == i-1 || lastSoldIndex[i-1] < i-3) {
                    lastSoldIndex[i] = i;
                    dp[i] = dp[i-1] + (prices[i]-prices[i-1]);
                } else {
                    int m1 = dp[lastSoldIndex[i-1]];
                    int m2 = dp[i-3] + (prices[i]-prices[i-1]);
                    if (m1 >= m2) {
                        dp[i] = m1;
                        lastSoldIndex[i] = lastSoldIndex[i-1];
                    } else {
                        dp[i] = m2;
                        lastSoldIndex[i] = i;
                    }
                }

            } else {
                dp[i] = dp[i-1];
                lastSoldIndex[i] = lastSoldIndex[i-1];
            }
        }
        return dp[length-1];
    }

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        System.out.println(maxProfit.maxProfitWithFreezing(new int[]{6, 1, 3,2,4,7}));
        System.out.println(maxProfit.maxProfitWithFreezing(new int[]{2, 1, 4}));
        System.out.println(maxProfit.maxProfitWithFreezing(new int[]{1, 2, 3, 0, 2}));
        System.out.println(7 == maxProfit.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(4 == maxProfit.maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(0 == maxProfit.maxProfit(new int[]{7,6,4,3,1}));
    }

}
