package algorithm.leetcode.hard.m;

public class MaxProfit {

    // 总结:同时考虑多种状态，可一次单向dp完成
    // 1 <= prices.length <= 10^5
    public int maxProfit(int[] prices) {
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
        System.out.println(1 == maxProfit.maxProfit(new int[]{1, 2}));
        System.out.println(0 == maxProfit.maxProfit(new int[]{1}));
        System.out.println(0 == maxProfit.maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(4 == maxProfit.maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(6 == maxProfit.maxProfit(new int[]{3,3,5,0,0,3,1,4}));
    }
}
