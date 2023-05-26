package algorithm.leetcode.medium.s;

import java.util.ArrayList;
import java.util.List;

public class ShortestPathBinaryMatrix {

    // n == grid.length
    // n == grid[i].length
    // 1 <= n <= 100
    // grid[i][j] 为 0 或 1

    int length;
    int[][] grid;
    int[][] searched;

    public int shortestPathBinaryMatrix(int[][] grid) {
        this.length = grid.length;
        this.grid= grid;
        this.searched = new int[length][length];
        if (grid[0][0] == 1) {
            return -1;
        }
        if (length == 1) {
            return 1;
        }
        searched[0][0] = 1;
        searched[length-1][length-1] = -1;
        List<int[]> points = new ArrayList<>();
        points.add(new int[]{0,0});
        while (!points.isEmpty()) {
            points = go(points);
        }
        return searched[length-1][length-1];
    }

    public List<int[]> go(List<int[]> points) {
        List<int[]> next = new ArrayList<>();
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            if (x > 0) {
                if (y > 0 && grid[x-1][y-1] == 0) {
                    int old = searched[x - 1][y - 1];
                    if (old <= 0 || old > searched[x][y]+1) {
                        searched[x-1][y-1] = searched[x][y]+1;
                        next.add(new int[]{x-1,y-1});
                    }
                }
                if (grid[x-1][y] == 0) {
                    int old = searched[x - 1][y];
                    if (old <= 0 || old > searched[x][y]+1) {
                        searched[x-1][y] = searched[x][y]+1;
                        next.add(new int[]{x-1,y});
                    }
                }
                if (y < length-1 && grid[x-1][y+1] == 0) {
                    int old = searched[x - 1][y+1];
                    if (old <= 0 || old > searched[x][y]+1) {
                        searched[x-1][y+1] = searched[x][y]+1;
                        next.add(new int[]{x-1,y+1});
                    }
                }
            }
            if (y > 0 && grid[x][y-1] == 0) {
                int old = searched[x][y - 1];
                if (old <= 0 || old > searched[x][y]+1) {
                    searched[x][y-1] = searched[x][y]+1;
                    next.add(new int[]{x,y-1});
                }
            }
            if (y < length-1 && grid[x][y+1] == 0) {
                int old = searched[x][y+1];
                if (old <= 0 || old > searched[x][y]+1) {
                    searched[x][y+1] = searched[x][y]+1;
                    next.add(new int[]{x,y+1});
                }
            }
            if (x < length-1) {
                if (y > 0 && grid[x+1][y-1] == 0) {
                    int old = searched[x + 1][y - 1];
                    if (old <= 0 || old > searched[x][y]+1) {
                        searched[x+1][y-1] = searched[x][y]+1;
                        next.add(new int[]{x+1,y-1});
                    }
                }
                if (grid[x+1][y] == 0) {
                    int old = searched[x+1][y];
                    if (old <= 0 || old > searched[x][y]+1) {
                        searched[x+1][y] = searched[x][y]+1;
                        next.add(new int[]{x+1,y});
                    }
                }
                if (y < length-1 && grid[x+1][y+1] == 0) {
                    int old = searched[x+1][y+1];
                    if (old <= 0 || old > searched[x][y]+1) {
                        searched[x+1][y+1] = searched[x][y]+1;
                        next.add(new int[]{x+1,y+1});
                    }
                }
            }
        }
        return next;
    }

    public static void main(String[] args) {
        ShortestPathBinaryMatrix shortestPathBinaryMatrix = new ShortestPathBinaryMatrix();
        System.out.println(-1 == shortestPathBinaryMatrix.shortestPathBinaryMatrix(
                new int[][]{{1,0,0},{1,1,0},{1,1,0}}));
        System.out.println(4 == shortestPathBinaryMatrix.shortestPathBinaryMatrix(
                new int[][]{{0,0,0},{1,1,0},{1,1,0}}));
        System.out.println(2 == shortestPathBinaryMatrix.shortestPathBinaryMatrix(
                new int[][]{{0,1},{1,0}}));
    }
}
