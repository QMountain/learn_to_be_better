package algorithm.leetcode.medium.c;

import java.util.Stack;

public class CountIslands {

    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        long currIslandSum = 0;
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    currIslandSum += grid[i][j];
                    stack.push(new int[]{i, j});
                    grid[i][j] = -1;
                }
                while (!stack.empty()) {
                    int[] cur = stack.pop();
                    if (cur[0] > 0 && grid[cur[0] - 1][cur[1]] > 0) {
                        currIslandSum += grid[cur[0] - 1][cur[1]];
                        stack.push(new int[]{cur[0] - 1, cur[1]});
                        grid[cur[0] - 1][cur[1]] = -1;
                    }
                    if (cur[0] < m - 1 && grid[cur[0] + 1][cur[1]] > 0) {
                        currIslandSum += grid[cur[0] + 1][cur[1]];
                        stack.push(new int[]{cur[0] + 1, cur[1]});
                        grid[cur[0] + 1][cur[1]] = -1;
                    }
                    if (cur[1] > 0 && grid[cur[0]][cur[1] - 1] > 0) {
                        currIslandSum += grid[cur[0]][cur[1] - 1];
                        stack.push(new int[]{cur[0], cur[1] - 1});
                        grid[cur[0]][cur[1] - 1] = -1;
                    }
                    if (cur[1] < n - 1 && grid[cur[0]][cur[1] + 1] > 0) {
                        currIslandSum += grid[cur[0]][cur[1] + 1];
                        stack.push(new int[]{cur[0], cur[1] + 1});
                        grid[cur[0]][cur[1] + 1] = -1;
                    }
                }
                if (currIslandSum > 0 && currIslandSum % k == 0) {
                    ans++;
                }
                currIslandSum = 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        CountIslands countIslands = new CountIslands();
    }
}
