package algorithm.leetcode.medium.h;

import java.util.LinkedList;
import java.util.Queue;

public class HasValidPath {

    /**
     * 1391. 检查网格中是否存在有效路径
     * 给你一个 m x n 的网格 grid。网格里的每个单元都代表一条街道。grid[i][j] 的街道可以是：
     * 1 表示连接左单元格和右单元格的街道。
     * 2 表示连接上单元格和下单元格的街道。
     * 3 表示连接左单元格和下单元格的街道。
     * 4 表示连接右单元格和下单元格的街道。
     * 5 表示连接左单元格和上单元格的街道。
     * 6 表示连接右单元格和上单元格的街道。
     */
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // 定义每种街道类型可以连接的方向
        // 对于每个街道类型，定义它可以连接的相邻单元格的方向
        // 方向: {行偏移, 列偏移}
        int[][][] directions = {
            {}, // 0不使用
            {{0, -1}, {0, 1}}, // 1: 左右
            {{-1, 0}, {1, 0}}, // 2: 上下
            {{0, -1}, {1, 0}}, // 3: 左下
            {{0, 1}, {1, 0}},  // 4: 右下
            {{0, -1}, {-1, 0}}, // 5: 左上
            {{0, 1}, {-1, 0}}   // 6: 右上
        };
        
        // 使用BFS搜索
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            
            // 如果到达右下角，返回true
            if (row == m - 1 && col == n - 1) {
                return true;
            }
            
            // 获取当前单元格的街道类型
            int streetType = grid[row][col];
            
            // 检查所有可能的移动方向
            for (int[] dir : directions[streetType]) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                
                // 检查新位置是否在网格内
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !visited[newRow][newCol]) {
                    // 获取新位置的街道类型
                    int newStreetType = grid[newRow][newCol];
                    
                    // 检查两个街道是否可以互相连接
                    boolean canConnect = false;
                    
                    // 检查新位置的街道是否有方向可以回到当前位置
                    for (int[] backDir : directions[newStreetType]) {
                        if (newRow + backDir[0] == row && newCol + backDir[1] == col) {
                            canConnect = true;
                            break;
                        }
                    }
                    
                    if (canConnect) {
                        visited[newRow][newCol] = true;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }
        
        return false;
    }
    
    // 测试方法
    public static void main(String[] args) {
        HasValidPath solution = new HasValidPath();
        
        // 测试用例 [[2,4,3],[6,5,2]]，预期为 true
        int[][] grid1 = {{2, 4, 3}, {6, 5, 2}};
        System.out.println("Test case 1: " + solution.hasValidPath(grid1)); // 应该输出 true
        
        // 添加更多测试用例
        int[][] grid2 = {{1, 1, 2}};
        System.out.println("Test case 2: " + solution.hasValidPath(grid2)); // 应该输出 false
        
        int[][] grid3 = {{1, 1, 1, 1, 1, 1, 3}};
        System.out.println("Test case 3: " + solution.hasValidPath(grid3)); // 应该输出 true
    }

}
