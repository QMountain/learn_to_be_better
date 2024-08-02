package algorithm.leetcode.medium.n;

public class NumberOfRightTriangles {

    // 1 <= grid.length <= 1000
    // 1 <= grid[i].length <= 1000
    // 0 <= grid[i][j] <= 1
    public long numberOfRightTriangles(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        long[] countRow = new long[rows];
        long[] countCol = new long[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    countRow[i]++;
                    countCol[j]++;
                }
            }
        }
        long ans = 0L;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    ans += (countRow[i] - 1) * (countCol[j] - 1);
                }
            }
        }
        return ans;
    }

}
