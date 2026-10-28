package algorithm.leetcode.medium.m;

import java.util.Arrays;

public class MinCost {

    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 上一行每个格子，1-1024的可能取值
        boolean[][] dp = new boolean[n][1024];
        dp[0][grid[0][0]] = true;
        boolean[] next = new boolean[1024];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                Arrays.fill(next, false);
                for (int k = 0; k < 1024; k++) {
                    if (dp[j][k]) {
                        next[k ^ grid[i][j]] = true;
                    }
                    if (j > 0) {
                        if (dp[j-1][k]) {
                            next[k ^ grid[i][j]] = true;
                        }
                    }
                }
                System.arraycopy(next, 0, dp[j], 0, 1024);
            }
        }
        for (int i = 0; i < 1024; i++) {
            if (dp[n-1][i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MinCost mc = new MinCost();
    }
}
