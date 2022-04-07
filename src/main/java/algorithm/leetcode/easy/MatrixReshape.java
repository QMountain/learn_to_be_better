package algorithm.leetcode.easy;

public class MatrixReshape {

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (m*n != r*c) {
            return mat;
        }
        int[][] arr = new int[r][c];
        int x = 0;
        int y = 0;
        for (int[] ints : mat) {
            for (int j = 0; j < n; j++) {
                arr[x][y] = ints[j];
                if (y != c - 1) {
                    y++;
                } else {
                    x++;
                    y = 0;
                }
            }
        }
        return arr;
    }

}
