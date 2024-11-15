package algorithm.leetcode.medium.m;

public class MinFlips {

    public int minFlips(int[][] grid) {
        int totalRows = grid.length;
        int totalCols = grid[0].length;
        int rowAns = 0;
        int colAns = 0;
        int maxRow = totalRows >> 1;
        int maxCol = totalCols >> 1;
        // 想让所有的列回文，需要遍历一半的行，与所有的列
        for (int col = 0; col < totalCols; col++) {
            for (int row = 0; row < maxRow; row++) {
                if (grid[row][col] != grid[totalRows-1-row][col]) {
                    colAns++;
                }
            }
        }
        for (int row = 0; row < totalRows; row++) {
            for (int col = 0; col < maxCol; col++) {
                if (grid[row][col] != grid[row][totalCols-1-col]) {
                    rowAns++;
                }
            }
        }
        return Math.min(rowAns, colAns);
    }

    public static void main(String[] args) {
        MinFlips minFlips = new MinFlips();
        System.out.println(2 == minFlips.minFlips(new int[][]{{1,0,0},{0,0,0},{0,0,1}}));
    }
}
