package algorithm.leetcode.medium.r;

import java.util.Arrays;

public class RestoreMatrix {

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int rows = rowSum.length;
        int cols = colSum.length;
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int min = Math.min(rowSum[i], colSum[j]);
                matrix[i][j] = min;
                rowSum[i] -= min;
                colSum[j] -= min;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        RestoreMatrix restoreMatrix = new RestoreMatrix();
        System.out.println(Arrays.deepToString(restoreMatrix.restoreMatrix(
                new int[]{0}, new int[]{0})));
        System.out.println(Arrays.deepToString(restoreMatrix.restoreMatrix(
                new int[]{1,0}, new int[]{1})));
        System.out.println(Arrays.deepToString(restoreMatrix.restoreMatrix(
                new int[]{14,9}, new int[]{6,9,8})));
        System.out.println(Arrays.deepToString(restoreMatrix.restoreMatrix(
                new int[]{5,7,10}, new int[]{8,6,8})));
        System.out.println(Arrays.deepToString(restoreMatrix.restoreMatrix(new int[]{3, 8}, new int[]{4, 7})));
    }
}
