package algorithm.leetcode.medium.n;

public class NumIslands {

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] searched = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && searched[i][j] == 0) {
                    search(grid,i,j,searched);
                    res += 1;
                }
            }
        }
        return res;
    }

    public void search(char[][] grid, int i, int j, int[][] searched) {
        searched[i][j] = 1;
        if (i > 0 && grid[i-1][j] == '1' && searched[i-1][j] == 0) {
            search(grid,i-1,j,searched);
        }
        if (i < grid.length-1 && grid[i+1][j] == '1' && searched[i+1][j] == 0) {
            search(grid,i+1,j,searched);
        }
        if (j > 0 && grid[i][j-1] == '1' && searched[i][j-1] == 0) {
            search(grid,i,j-1,searched);
        }
        if (j < grid[0].length-1 && grid[i][j+1] == '1' && searched[i][j+1] == 0) {
            search(grid,i,j+1,searched);
        }
    }

    public static void main(String[] args) {
        NumIslands numIslands = new NumIslands();
        System.out.println(numIslands.numIslands(new char[][]{
                {'1','1','1'},
                {'0','1','0'},
                {'0','1','0'}
        }));
        System.out.println(3 == numIslands.numIslands(new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'},
        }));
        System.out.println(1 == numIslands.numIslands(new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'},
        }));
    }
}
