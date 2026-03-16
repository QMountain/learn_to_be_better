package algorithm.leetcode.medium.g;

import java.util.*;

public class GetBiggestThree {

    /**
     * 1878. 矩阵中最大的三个菱形和
     * 给你一个 m x n 的整数矩阵 grid 。
     * 菱形和 指的是 grid 中一个正菱形 边界 上的元素之和。
     * 本题中的菱形必须为正方形旋转45度，且四个角都在一个格子当中。
     * 下图是四个可行的菱形，每个菱形和应该包含的格子都用了相应颜色标注在图中。
     * 注意，菱形可以是一个面积为 0 的区域，如上图中右下角的紫色菱形所示。
     * 请你按照 降序 返回 grid 中三个最大的 互不相同的菱形和 。如果不同的和少于三个，则将它们全部返回。
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 100
     * 1 <= grid[i][j] <= 10^5
     */
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // 使用TreeSet来存储所有不同的菱形和，自动排序和去重
        TreeSet<Integer> sums = new TreeSet<>(Collections.reverseOrder());
        
        // 遍历所有可能的中心点和半径
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 半径为0的菱形（单个点）
                sums.add(grid[i][j]);
                
                // 尝试更大的半径
                for (int r = 1; ; r++) {
                    // 检查是否可以形成半径为r的菱形
                    if (i - r < 0 || i + r >= m || j - r < 0 || j + r >= n) {
                        break;
                    }
                    
                    // 计算半径为r的菱形的边界和
                    int sum = calculateRhombusSum(grid, i, j, r);
                    sums.add(sum);
                }
            }
        }
        
        // 提取前三个最大的和
        int[] result = new int[Math.min(3, sums.size())];
        int index = 0;
        for (int sum : sums) {
            if (index >= 3) break;
            result[index++] = sum;
        }
        
        return result;
    }
    
    /**
     * 计算以(i,j)为中心，半径为r的菱形的边界元素和
     */
    private int calculateRhombusSum(int[][] grid, int centerX, int centerY, int radius) {
        if (radius == 0) {
            return grid[centerX][centerY];
        }
        
        int sum = 0;
        
        // 菱形的四个顶点
        int topX = centerX - radius;
        int topY = centerY;
        int rightX = centerX;
        int rightY = centerY + radius;
        int bottomX = centerX + radius;
        int bottomY = centerY;
        int leftX = centerX;
        int leftY = centerY - radius;
        
        // 遍历菱形的边界
        // 上边界：从左上到右上
        for (int i = topX, j = topY; i <= rightX && j <= rightY; i++, j++) {
            sum += grid[i][j];
        }
        
        // 右边界：从右上到右下（不包括右上顶点）
        for (int i = rightX + 1, j = rightY - 1; i < bottomX && j > bottomY; i++, j--) {
            sum += grid[i][j];
        }
        
        // 下边界：从右下到左下（不包括右下顶点）
        for (int i = bottomX, j = bottomY; i >= leftX && j >= leftY; i--, j--) {
            sum += grid[i][j];
        }
        
        // 左边界：从左下到左上（不包括左下顶点）
        for (int i = leftX - 1, j = leftY + 1; i > topX && j < topY; i--, j++) {
            sum += grid[i][j];
        }
        
        return sum;
    }
}
