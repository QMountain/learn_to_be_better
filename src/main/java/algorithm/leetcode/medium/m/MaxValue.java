package algorithm.leetcode.medium.m;

import java.util.Arrays;

public class MaxValue {

    public int maxValue(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] arr = new int[rows][cols];
        arr[rows-1][cols-1] = grid[rows-1][cols-1];
        for (int i = cols-2; i >= 0; i--) {
            arr[rows-1][i] = arr[rows-1][i+1] + grid[rows-1][i];
        }
        for (int i = rows-2; i >= 0; i--) {
            arr[i][cols-1] = arr[i+1][cols-1] + grid[i][cols-1];
        }
        for (int i = rows-2; i >= 0; i--) {
            for (int j = cols-2; j >= 0; j--) {
                arr[i][j] = Math.max(arr[i+1][j], arr[i][j+1]) + grid[i][j];
            }
        }
        return arr[0][0];
    }

    public static void main(String[] args) {
        MaxValue maxValue = new MaxValue();
        System.out.println(maxValue.maxValue(new int[][]{{1,3,1}, {1,5,1}, {4,2,1}}));
    }
}
