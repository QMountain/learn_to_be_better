package algorithm.leetcode.medium.c;

public class CheckValidGrid {

    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) {
            return false;
        }
        int n = grid.length;
        int steps = n*n - 1;
        int[][] positionArr = new int[n*n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int step = grid[i][j];
                positionArr[step] = new int[]{i, j};
            }
        }
        for (int i = 0; i < steps; i++) {
            int[] currP = positionArr[i];
            int[] nextP = positionArr[i + 1];
            int diffX = Math.abs(currP[0] - nextP[0]);
            int diffY = Math.abs(currP[1] - nextP[1]);
            if (diffX == 1 && diffY == 2) {
                continue;
            }
            if (diffX == 2 && diffY == 1) {
                continue;
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        CheckValidGrid checkValidGrid = new CheckValidGrid();
        System.out.println(!checkValidGrid.checkValidGrid(new int[][]{{24,11,22,17,4},{21,16,5,12,9},{6,23,10,3,18},{15,20,1,8,13},{0,7,14,19,2}}));
        System.out.println(!checkValidGrid.checkValidGrid(new int[][]{{0,3,6},{5,8,1},{2,7,4}}));
        System.out.println(checkValidGrid.checkValidGrid(new int[][]{{0,11,16,5,20},{17,4,19,10,15},{12,1,8,21,6},{3,18,23,14,9},{24,13,2,7,22}}));
    }
}
