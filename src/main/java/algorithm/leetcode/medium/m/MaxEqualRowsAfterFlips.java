package algorithm.leetcode.medium.m;

public class MaxEqualRowsAfterFlips {

    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int min = n;
        int minZero = n;
        for (int[] ints : matrix) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (ints[j] == 1) {
                    count++;
                }
            }
            min = Math.min(min, count);
            minZero = Math.min(minZero, n - count);
        }
        return Math.max(minZero, min);
    }

    int[][] matrix;

    // 时间 6.25%
    public int maxEqualRowsAfterFlips2(int[][] matrix) {
        this.matrix = matrix;
        int m = matrix.length;
        int ans = 1;
        // 假设使得第i行都相等
        for (int i = 0; i < m; i++) {
            // 假设使得第i行都是0
            int m1 = maxFromRow(i, 0);
            // 假设使得第i行都是1
            int m2 = maxFromRow(i, 1);
            ans = Math.max(ans, Math.max(m1, m2) + 1);
        }
        return ans;
    }

    public int maxFromRow(int row, int target) {
        int[] targetRow = matrix[row];
        int res = 0;
        for (int i = row + 1; i < matrix.length; i++) {
            int sum = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                if (targetRow[j] == target) {
                    sum += matrix[i][j];
                } else {
                    if (matrix[i][j] == 0) {
                        sum++;
                    }
                }
            }
            if (sum == 0 || sum == matrix[0].length) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaxEqualRowsAfterFlips maxEqualRowsAfterFlips = new MaxEqualRowsAfterFlips();
        System.out.println(2 == maxEqualRowsAfterFlips.maxEqualRowsAfterFlips(
                new int[][]{{1,0,0,0,1,1,1,0,1,1,1},{1,0,0,0,1,0,0,0,1,0,0},{1,0,0,0,1,1,1,0,1,1,1},{1,0,0,0,1,0,0,0,1,0,0},{1,1,1,0,1,1,1,0,1,1,1}}
        ));
        System.out.println(2 == maxEqualRowsAfterFlips.maxEqualRowsAfterFlips(
                new int[][]{{0,0,0},{0,0,1},{1,1,0}}));
        System.out.println(2 == maxEqualRowsAfterFlips.maxEqualRowsAfterFlips(
                new int[][]{{0,1},{1,0}}));
        System.out.println(1 == maxEqualRowsAfterFlips.maxEqualRowsAfterFlips(
                new int[][]{{0,1},{1,1}}));
    }
}
