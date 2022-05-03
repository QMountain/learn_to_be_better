package algorithm.leetcode.easy.f;

public class FinalPrices {

    public int[] finalPrices(int[] prices) {
        int length = prices.length;
        int[] arr = new int[length];
        arr[length-1] = prices[length-1];
        for (int i = 0; i < length - 1; i++) {
            boolean find = false;
            for (int j = i+1; j < length; j++) {
                if (prices[j] <= prices[i]) {
                    find = true;
                    arr[i] = prices[i] - prices[j];
                    break;
                }
            }
            if (!find) {
                arr[i] = prices[i];
            }
        }
        return arr;
    }

}
