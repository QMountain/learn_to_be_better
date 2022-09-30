package algorithm.leetcode.medium.n;

public class NumMatrix {

    int[][] accumulate;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        this.accumulate = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                accumulate[i][j] += matrix[i][j];
                if (i > 0) {
                    accumulate[i][j] += accumulate[i-1][j];
                }
                if (j > 0) {
                    accumulate[i][j] += accumulate[i][j-1];
                }
                if (i > 0 && j > 0) {
                    accumulate[i][j] -= accumulate[i-1][j-1];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int total = accumulate[row2][col2];
        // minus left up
        if (row1 > 0 && col1 > 0) {
            total -= accumulate[row1-1][col1-1];
        }
        // minus up
        if (row1 > 0) {
            int upTotal = accumulate[row1-1][col2];
            if (col1 > 0) {
                upTotal -= accumulate[row1-1][col1-1];
            }
            total -= upTotal;
        }
        // minus left
        if (col1 > 0) {
            int leftTotal = accumulate[row2][col1-1];
            if (row1 > 0) {
                leftTotal -= accumulate[row1-1][col1-1];
            }
            total -= leftTotal;
        }
        return total;
    }

    public static void main(String[] args) {
        NumMatrix numMatrix = new NumMatrix(new int[][]{{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}});
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4));
    }
}
