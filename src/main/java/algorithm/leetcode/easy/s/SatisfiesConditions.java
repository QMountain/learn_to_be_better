package algorithm.leetcode.easy.s;

public class SatisfiesConditions {

    public boolean satisfiesConditions(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 1; i < cols; i++) {
            if (grid[0][i-1] == grid[0][i]) {
                return false;
            }
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] != grid[i-1][j]) {
                    return false;
                }
            }
        }
        return true;
    }

}
