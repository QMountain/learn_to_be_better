package algorithm.leetcode.hard.m;

public class MaxProfit {

    // 题号：188 买卖股票的最佳时机IV
    public int maxProfit(int k, int[] prices) {
        int length = prices.length;
        int[] dp = new int[k*2];
        for (int i = 0; i < k*2; i+=2) {
            dp[i] = -prices[0];
        }
        for (int i = 1; i < length; i++) {
            dp[0] = Math.max(dp[0], -prices[i]);
            dp[1] = Math.max(dp[1], dp[0] + prices[i]);
            for (int j = 2; j < k * 2; j+=2) {
                dp[j] = Math.max(dp[j], dp[j-1] - prices[i]);
                dp[j+1] = Math.max(dp[j+1], dp[j] + prices[i]);
            }
        }

        return dp[k*2-1];
    }

    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }

    // 总结:同时考虑多种状态，可一次单向dp完成
    // 1 <= prices.length <= 10^5
    public int maxProfit3(int[] prices) {
        int length = prices.length;
        int[] dp1 = new int[length];
        int min = prices[0];
        for (int i = 1; i < length; i++) {
            if (prices[i] > min) {
                dp1[i] = prices[i] - min;
            } else if (prices[i] < min) {
                min = prices[i];
            }
            dp1[i] = Math.max(dp1[i-1], dp1[i]);
        }

        int[] dp2 = new int[length];
        int max = prices[length-1];
        for (int i = length-2; i >= 0; i--) {
            if (prices[i] < max) {
                dp2[i] = max - prices[i];
            } else if (prices[i] > max) {
                max = prices[i];
            }
            dp2[i] = Math.max(dp2[i], dp2[i+1]);
        }
        int ans = 0;
        for (int i = 0; i < length; i++) {
            int curr = dp1[i] + dp2[i];
            ans = Math.max(ans, curr);
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        System.out.println(maxProfit.maxProfit(2, new int[]{3,2,6,5,0,3}));
        System.out.println(2 == maxProfit.maxProfit(2, new int[]{2,4,1}));

        System.out.println(1 == maxProfit.maxProfit2(new int[]{1, 2}));
        System.out.println(0 == maxProfit.maxProfit2(new int[]{1}));
        System.out.println(0 == maxProfit.maxProfit2(new int[]{7,6,4,3,1}));
        System.out.println(4 == maxProfit.maxProfit2(new int[]{1,2,3,4,5}));
        System.out.println(6 == maxProfit.maxProfit2(new int[]{3,3,5,0,0,3,1,4}));
    }
}
