package algorithm.leetcode.medium.s;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class ShortestBridge {

    int[][] grid;
    int length;
    boolean[][] visited;
    Set<int[]> set1;

    public int shortestBridge2(int[][] grid) {
        this.grid = grid;
        this.length = grid.length;
        this.visited = new boolean[length][length];
        this.set1 = new HashSet<>();
        for (int i = 0; i < length; i++) {
            boolean findOne = false;
            for (int j = 0; j < length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(i,j);
                    findOne = true;
                    break;
                }
            }
            if (findOne) {
                break;
            }
        }
        Set<int[]> set2 = new HashSet<>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    if (checkBound(i,j)) {
                        set2.add(new int[]{i,j});
                    }
                }
            }
        }
        int min = length*2;
        for (int[] p1 : set1) {
            for (int[] p2 : set2) {
                int distance = Math.abs(p1[0] - p2[0])+Math.abs(p1[1] - p2[1]) - 1;
                min = Math.min(min,distance);
            }
        }
        return min;
    }

    public void dfs(int x, int y) {
        if (checkBound(x,y)) {
            set1.add(new int[]{x,y});
            visited[x][y] = true;
        }
        if (x > 0 && (grid[x-1][y] == 1 && !visited[x-1][y])) {
            dfs(x-1,y);
        }
        if (x < length-1 && (grid[x+1][y] == 1 && !visited[x+1][y])) {
            dfs(x+1,y);
        }
        if (y > 0 && (grid[x][y-1] == 1 && !visited[x][y-1])) {
            dfs(x,y-1);
        }
        if (y < length-1 && (grid[x][y + 1] == 1 && !visited[x][y + 1])) {
            dfs(x,y+1);
        }
    }

    public boolean checkBound(int i, int j) {
        if (grid[i][j] == 1 && !visited[i][j]) {
            if (i == 0 || grid[i-1][j] == 0 || !visited[i-1][j]) {
                return true;
            } else if (i == length-1 || grid[i+1][j] == 0 || !visited[i+1][j]) {
                return true;
            } else if (j == 0 || grid[i][j-1] == 0 || !visited[i][j-1]) {
                return true;
            } else return j == length - 1 || grid[i][j + 1] == 0 || !visited[i][j + 1];
        }
        return false;
    }

    // 题号 934 最短的桥 官解 虽然也是O(n2) 但是只遍历了一次
    // 思想是一层层扩大外圈，接触到其他的1即使链接上了第二个岛
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    Queue<int[]> queue = new ArrayDeque<int[]>();
                    dfs(i, j, grid, queue);
                    int step = 0;
                    while (!queue.isEmpty()) {
                        int sz = queue.size();
                        for (int k = 0; k < sz; k++) {
                            int[] cell = queue.poll();
                            int x = cell[0], y = cell[1];
                            for (int d = 0; d < 4; d++) {
                                int nx = x + dirs[d][0];
                                int ny = y + dirs[d][1];
                                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                                    if (grid[nx][ny] == 0) {
                                        queue.offer(new int[]{nx, ny});
                                        grid[nx][ny] = -1;
                                    } else if (grid[nx][ny] == 1) {
                                        return step;
                                    }
                                }
                            }
                        }
                        step++;
                    }
                }
            }
        }
        return 0;
    }

    public void dfs(int x, int y, int[][] grid, Queue<int[]> queue) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != 1) {
            return;
        }
        queue.offer(new int[]{x, y});
        grid[x][y] = -1;
        dfs(x - 1, y, grid, queue);
        dfs(x + 1, y, grid, queue);
        dfs(x, y - 1, grid, queue);
        dfs(x, y + 1, grid, queue);
    }

    public static void main(String[] args) {
        ShortestBridge shortestBridge = new ShortestBridge();
        System.out.println(4 == shortestBridge.shortestBridge(new int[][]{{0,0,0,1,1,0,0},{0,0,0,1,0,0,0},{0,0,0,1,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,1,0,0,0,0,0},{0,1,1,0,0,0,0}}));
        System.out.println(1 == shortestBridge.shortestBridge(new int[][]{{1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}}));
        System.out.println(2 == shortestBridge.shortestBridge(new int[][]{{0,1,0},{0,0,0},{0,0,1}}));
        System.out.println(1 == shortestBridge.shortestBridge(new int[][]{{0,1},{1,0}}));
    }
}
