package algorithm.leetcode.medium.c;

import java.util.Arrays;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        return coinChangeBySortedArrayFromIndex(coins,amount, coins.length-1);
    }

    public int coinChangeBySortedArrayFromIndex(int[] coins, int amount,int index) {
        int min = amount;
        for (int i = index; i >= 0; i--) {
            int coin = coins[i];
            if (coin <= amount) {
                int left = amount % coin;
                if (left == 0) {
                    min = Math.min(amount/coin,min);
                }
                int bs = amount/coin;
                for (int j = 0; j < bs; j++) {
                    if (left+j*coin > coins[0] && i > 0) {
                        int change = coinChangeBySortedArrayFromIndex(coins, left+j*coin,i-1);
                        if (change != -1) {
                            min = Math.min(min,bs-i + change);
                        }
                    }

                }
            }
        }
        return min == amount ? -1 : min;
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        System.out.println(20 == coinChange.coinChange(new int[]{186, 419, 83, 408}, 6249));
        System.out.println(coinChange.coinChange(new int[]{1, 2, 5}, 11));
    }
}
