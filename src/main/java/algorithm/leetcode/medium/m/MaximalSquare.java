package algorithm.leetcode.medium.m;

import java.util.Arrays;

public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] rowCount = new int[m];
        int[] colCount = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }
        Arrays.sort(rowCount);
        Arrays.sort(colCount);
        int maxRc = rowCount[m-1];
        if (maxRc == 0) {
            return 0;
        }
        for (int i = m-1; i > 0; i--) {
            int rc = rowCount[i];
            if (rc <= m && rc >= 1) {
               if (rowCount[m-rc] >= rc) {
                   maxRc = rc;
                   break;
               }
            }
        }
        int maxCc = colCount[n-1];
        if (maxCc == 0) {
            return 0;
        }
        for (int i = n-1; i > 0; i--) {
            int cc = colCount[i];
            if (cc <= n && cc >= 1) {
                if (colCount[n-cc] >= cc) {
                    maxCc = cc;
                    break;
                }
            }
        }
        int max = Math.min(maxRc,maxCc);
        while (max > 0) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (m-i >= max && n-j >= max) {
                        boolean can = true;
                        for (int k = i; k < i + max; k++) {
                            for (int l = j; l < j + max; l++) {
                                if (matrix[k][l] == '0') {
                                    can = false;
                                    break;
                                }
                            }
                            if (!can) {
                                break;
                            }
                        }
                        if (can) {
                            return max*max;
                        }
                    }
                }
            }
            max--;
        }
        return 0;
    }

    public static void main(String[] args) {
        MaximalSquare maximalSquare = new MaximalSquare();
        System.out.println(maximalSquare.maximalSquare(new char[][]{
                {'0','0','0'},
                {'0','0','0'},
                {'1','1','1'}}));
        System.out.println(maximalSquare.maximalSquare(new char[][]{{'0'}}));
        System.out.println(maximalSquare.maximalSquare(new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}}));
    }
}
