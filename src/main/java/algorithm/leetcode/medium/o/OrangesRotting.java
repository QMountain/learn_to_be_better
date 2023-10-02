package algorithm.leetcode.medium.o;

import java.util.HashSet;

public class OrangesRotting {

    public int orangesRotting(int[][] grid) {
        int countGood = 0;
        HashSet<int[]> badSet = new HashSet<>();
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    badSet.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    countGood++;
                }
            }
        }
        int minutes = 0;
        while (!badSet.isEmpty()) {
            HashSet<int[]> changeBadSet = new HashSet<>();
            for (int[] badOrange : badSet) {
                int x = badOrange[0];
                int y = badOrange[1];
                // up
                if (x > 0 && grid[x -1][y] == 1) {
                    grid[x-1][y] = 2;
                    changeBadSet.add(new int[]{x-1, y});
                    countGood--;
                }
                // down
                if (x < rows-1 && grid[x+1][y] == 1) {
                    grid[x+1][y] = 2;
                    changeBadSet.add(new int[]{x+1, y});
                    countGood--;
                }
                // left
                if (y > 0 && grid[x][y-1] == 1) {
                    grid[x][y-1] = 2;
                    changeBadSet.add(new int[]{x, y-1});
                    countGood--;
                }
                // right
                if (y < cols-1 && grid[x][y+1] == 1) {
                    grid[x][y+1] = 2;
                    changeBadSet.add(new int[]{x, y+1});
                    countGood--;
                }
            }
            if (changeBadSet.isEmpty()) {
                break;
            }
            minutes++;
            badSet = changeBadSet;
        }
        if (countGood > 0) {
            return -1;
        }
        return minutes;
    }

    public static void main(String[] args) {
        OrangesRotting orangesRotting = new OrangesRotting();
        System.out.println(orangesRotting.orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}}));
    }
}
