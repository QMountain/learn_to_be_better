package algorithm.leetcode.easy.m;

public class MaxProfit {

    // 1 <= prices.length <= 10^5
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length == 1) {
            return 0;
        }
        int maxProfit = 0;
        int min = prices[0];
        for (int i = 1; i < length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return maxProfit;
    }

    public int maxProfit2(int[] prices) {
        int maxProfit = 0;
        int length = prices.length;
        if (length < 2) {
            return 0;
        }
        int min;
        int max;
        if (prices[0] >= prices[1]) {
            min = prices[1];
            max = prices[1];
        } else {
            min = prices[0];
            max = prices[1];
            maxProfit = prices[1] - prices[0];
        }
        for (int i = 2; i < length; i++) {
            if (prices[i] < min) {
                min = prices[i];
                max = prices[i];
            } else if (prices[i] > max) {
                max = prices[i];
                maxProfit = Math.max(maxProfit,max-min);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        /*System.out.println(5 == maxProfit.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(0 == maxProfit.maxProfit(new int[]{7,6,4,3,1}));*/
        System.out.println(2 == maxProfit.maxProfit(new int[]{2,1,2,1,0,1,2}));
    }
}
