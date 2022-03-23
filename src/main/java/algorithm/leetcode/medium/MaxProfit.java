package algorithm.leetcode.medium;

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

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        System.out.println(7 == maxProfit.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(4 == maxProfit.maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(0 == maxProfit.maxProfit(new int[]{7,6,4,3,1}));
    }

}
