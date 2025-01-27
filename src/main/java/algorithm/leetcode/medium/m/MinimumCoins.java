package algorithm.leetcode.medium.m;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;

public class MinimumCoins {

    // 1 <= prices.length <= 1000
    // 1 <= prices[i] <= 10^5
    public int minimumCoins(int[] prices) {
        int length = prices.length;
        if (length < 3) {
            return prices[0];
        }
        // 最多能拿到i，所需要的最少钱
        int[] arr = new int[length+1];
        Arrays.fill(arr, -1);
        arr[1] = prices[0];
        arr[2] = prices[0];
        for (int i = 2; i <= length; i++) {
            // 拿i位置的水果
            // 方式一：最多拿到i-1位置的水果的钱 + price[i]
            //int m1 = arr[i-1] + prices[i];
            // 方式二：

            // 买 i 位置的水果，可以更新 [i+1, i+i]
            int cost = arr[i-1] + prices[i-1];
            for (int j = i; j <= Math.min(i << 1, length); j++) {
                if (arr[j] == -1) {
                    arr[j] = cost;
                } else {
                    arr[j] = Math.min(arr[j], cost);
                }
            }
        }
        return arr[length];
    }

    public static void main(String[] args) {
        MinimumCoins minimumCoins = new MinimumCoins();
        System.out.println(63 == minimumCoins.minimumCoins(new int[]{14,37,37,38,24,15,12}));
        System.out.println(47 == minimumCoins.minimumCoins(new int[]{27,17,29,45,3,39,42,265}));
        System.out.println(39 == minimumCoins.minimumCoins(new int[]{26,18,6,12,49,7,45,45}));
        System.out.println(2 == minimumCoins.minimumCoins(new int[]{1,10,1,1}));
        System.out.println(4 == minimumCoins.minimumCoins(new int[]{3,1,2}));
    }
}
