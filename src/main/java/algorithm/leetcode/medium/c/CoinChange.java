package algorithm.leetcode.medium.c;

import java.util.Arrays;

public class CoinChange {

    public int coinChange2(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        return coinChange(coins,amount);
        //return coinChangeBySortedArrayFromIndex(coins,amount, coins.length-1,amount+1,0);
    }

    public int coinChangeBySortedArrayFromIndex(int[] coins, int amount,int index,int min,int path) {
        int coin = coins[index];
        if (amount % coin == 0) {
            return amount / coin;
        }
        if (index == 0) {
            return -1;
        }
        int bs = amount / coin;
        for (int i = bs; i >= 0; i--) {
            if (path+i >= min) {
                continue;
            }
            int change = coinChangeBySortedArrayFromIndex(coins, amount - (i * coin), index - 1,min,path+i);
            if (change != -1) {
                min = Math.min(i+change,min);
            }
        }
        if (min == amount+1) {
            return -1;
        }
        return min;
        /*int min = amount;
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
        return min == amount ? -1 : min;*/
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        if (amount < coins[0]) {
            return -1;
        }
        int length = coins.length;
        int cut = 0;
        for (int i = length-1; i >= 0; i--) {
            if (coins[i] > amount) {
                cut++;
            }
        }
        int[] arr = new int[length-cut];
        System.arraycopy(coins,0,arr,0,length-cut);
        coins = arr;
        int[] dp = new int[amount+1];
        for (int coin : coins) {
            dp[coin] = 1;
        }
        for (int i = coins[0]+1; i <= amount; i++) {
            if (dp[i] == 0) {
                int min = amount+1;
                for (int coin : coins) {
                    if (i-coin >= 0 && dp[i-coin] > 0) {
                        min = Math.min(min,dp[i-coin]);
                    }
                }
                if (min != amount+1) {
                    dp[i] = min+1;
                }
            }
        }
        return dp[amount] != 0 ? dp[amount] : -1;
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(coinChange.coinChange(new int[]{456,117,5,145}, 1459));
        System.out.println(coinChange.coinChange(new int[]{224,2,217,189,79,343,101}, 2938));


        System.out.println(coinChange.coinChange(new int[]{186, 419, 83, 408}, 6249));
        System.out.println(20 == coinChange.coinChange(new int[]{186, 419, 83, 408}, 6249));

    }
}
