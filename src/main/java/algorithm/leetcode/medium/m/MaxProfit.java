package algorithm.leetcode.medium.m;

public class MaxProfit {

    // 题号：309 买卖股票的最佳时机含冷冻期
    // 1 <= prices.length <= 5000
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int buy = -prices[0];
        int sell = 0;
        int freezing = 0;
        for (int i = 1; i < length; i++) {
            buy = Math.max(buy, -prices[i]);
            buy = Math.max(freezing-prices[i], buy);
            freezing = sell;
            sell = Math.max(sell, prices[i] + buy);
        }
        return Math.max(sell, freezing);
    }


    // 题号：122 买卖股票的最佳时机II
    public int maxProfit2(int[] prices) {
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
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        // f[i][0]: 手上持有股票的最大收益
        // f[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益
        // f[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益
        int[][] f = new int[n][3];
        f[0][0] = -prices[0];
        for (int i = 1; i < n; ++i) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][2] - prices[i]);
            f[i][1] = f[i - 1][0] + prices[i];
            f[i][2] = Math.max(f[i - 1][1], f[i - 1][2]);
        }
        return Math.max(f[n - 1][1], f[n - 1][2]);
    }

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        // ********** 题号：309 买卖股票的最佳时机含冷冻期。case start *********
        System.out.println(maxProfit.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(0 == maxProfit.maxProfit(new int[]{1}));
        System.out.println(3 == maxProfit.maxProfit(new int[]{1,2,3,0,2}));
        // ********** 题号：309 买卖股票的最佳时机含冷冻期。case end *********

        System.out.println(maxProfit.maxProfitWithFreezing(new int[]{70, 4, 83, 56, 94, 72, 78, 43}));
        System.out.println(10 == maxProfit.maxProfitWithFreezing(new int[]{1, 2, 7, 4, 11}));
        System.out.println(10 == maxProfit.maxProfitWithFreezing(new int[]{8,6,4,3,3,2,3,5,8,3,8,2,6}));
        System.out.println(10 == maxProfit.maxProfitWithFreezing(new int[]{5, 2, 3, 0, 3, 5, 6, 8, 1, 5}));

        System.out.println(6 == maxProfit.maxProfitWithFreezing(new int[]{1, 4, 2, 7}));
        System.out.println(6 == maxProfit.maxProfitWithFreezing(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
        System.out.println(6 == maxProfit.maxProfitWithFreezing(new int[]{6, 1, 3, 2, 4, 7}));
        System.out.println(10 == maxProfit.maxProfitWithFreezing(new int[]{2, 4, 1, 7, 11}));
        System.out.println(3 == maxProfit.maxProfitWithFreezing(new int[]{4, 7, 1, 2}));
        System.out.println(0 == maxProfit.maxProfitWithFreezing(new int[]{4, 2, 1}));
        System.out.println(6 == maxProfit.maxProfitWithFreezing(new int[]{2, 1, 4, 7}));
        System.out.println(6 == maxProfit.maxProfitWithFreezing(new int[]{1, 7, 2, 4}));
        System.out.println(3 == maxProfit.maxProfitWithFreezing(new int[]{2, 1, 2,1,0,1,2}));

        System.out.println(3 == maxProfit.maxProfitWithFreezing(new int[]{2, 1, 4}));
        System.out.println(3 == maxProfit.maxProfitWithFreezing(new int[]{1, 2, 3, 0, 2}));


        System.out.println(7 == maxProfit.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(4 == maxProfit.maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(0 == maxProfit.maxProfit(new int[]{7,6,4,3,1}));
    }

}
