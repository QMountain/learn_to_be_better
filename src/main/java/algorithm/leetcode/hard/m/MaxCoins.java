package algorithm.leetcode.hard.m;

public class MaxCoins {

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] rec = new int[n + 2][n + 2];
        int[] val = new int[n + 2];
        val[0] = val[n + 1] = 1;
        System.arraycopy(nums, 0, val, 1, n);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j <= n + 1; j++) {
                for (int k = i + 1; k < j; k++) {
                    int sum = val[i] * val[k] * val[j];
                    sum += rec[i][k] + rec[k][j];
                    rec[i][j] = Math.max(rec[i][j], sum);
                }
            }
        }
        return rec[0][n + 1];
    }

    public static void main(String[] args) {
        MaxCoins maxCoins = new MaxCoins();
        System.out.println(maxCoins.maxCoins(new int[]{35,16,83,87,84,59,48,41,20,54}));
        System.out.println(maxCoins.maxCoins(new int[]{7,9,8,0,7,1,3,5}));
        System.out.println(maxCoins.maxCoins(new int[]{9,76,64}));
        System.out.println(maxCoins.maxCoins(new int[]{3, 1, 5}));
        System.out.println(maxCoins.maxCoins(new int[]{2,3,7,9,1,8,2}));
        System.out.println(maxCoins.maxCoins(new int[]{2,3,7,9,1}));
        System.out.println(maxCoins.maxCoins(new int[]{35,16,83,87,84,59,48,41}));
        System.out.println(maxCoins.maxCoins(new int[]{9, 76, 64, 21}));
        System.out.println(maxCoins.maxCoins(new int[]{9, 76, 64, 21,97,60,5}));
        System.out.println(maxCoins.maxCoins(new int[]{3, 1, 5, 8}));

        System.out.println(maxCoins.maxCoins(new int[]{9, 76, 64, 21,97}));


    }
}
