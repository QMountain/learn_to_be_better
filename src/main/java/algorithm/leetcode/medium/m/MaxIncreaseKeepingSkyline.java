package algorithm.leetcode.medium.m;

import java.util.HashMap;
import java.util.Map;

public class MaxIncreaseKeepingSkyline {

    // 保持城市天际线
    // n == grid.length
    // n == grid[r].length
    // 2 <= n <= 50
    // 0 <= grid[r][c] <= 100
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int length = grid.length;
        int[][] highestArr = new int[length][2];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                highestArr[i][0] = Math.max(highestArr[i][0], grid[i][j]);
                highestArr[j][1] = Math.max(highestArr[j][1], grid[i][j]);
            }
        }
        int ans = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int min = Math.min(highestArr[i][0], highestArr[j][1]);
                ans += min - grid[i][j];
            }
        }
        return ans;
    }

    public int maxIncreaseKeepingSkyline2(int[][] grid) {
        Map<String,Integer> maxMap = new HashMap<>(grid.length*2);
        for (int i = 0; i < grid.length; i++) {
            int rowMax = grid[i][0];
            int colMax = grid[0][i];
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > rowMax) {
                    rowMax = grid[i][j];
                }
                if (grid[j][i] > colMax) {
                    colMax = grid[j][i];
                }
            }
            maxMap.put("row"+i,rowMax);
            maxMap.put("col"+i,colMax);
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                Integer maxRow = maxMap.get("row" + i);
                Integer maxCol = maxMap.get("col" + j);
                res += Math.min(maxRow,maxCol) - grid[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaxIncreaseKeepingSkyline maxIncreaseKeepingSkyline = new MaxIncreaseKeepingSkyline();
        int i = maxIncreaseKeepingSkyline.maxIncreaseKeepingSkyline(
                new int[][]{{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}});
        System.out.println(i);

        int i1 = maxIncreaseKeepingSkyline.maxIncreaseKeepingSkyline(
                new int[][]{{59,88,44}, {3,18,38}, {21,26,51}});
        System.out.println(i1);
    }
}
