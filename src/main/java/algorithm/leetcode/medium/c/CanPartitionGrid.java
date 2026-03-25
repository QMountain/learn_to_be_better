package algorithm.leetcode.medium.c;

public class CanPartitionGrid {

    /**
     * 3546. 等和矩阵分割 I
     * 给你一个由正整数组成的 m x n 矩阵 grid。
     * 你的任务是判断是否可以通过 一条水平或一条垂直分割线 将矩阵分割成两部分，使得：
     * 分割后形成的每个部分都是 非空 的。
     * 两个部分中所有元素的和 相等 。
     * 如果存在这样的分割，返回 true；否则，返回 false。
     * 输入： grid = [[1,4],[2,3]]
     * 输出： true
     * 输入： grid = [[1,3],[2,4]]
     * 输出： false
     */
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // 使用前缀和数组，prefixSum[i][j]表示从(0,0)到(i-1,j-1)的矩形区域和
        long[][] prefixSum = new long[m + 1][n + 1];

        // 构建前缀和数组
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefixSum[i][j] = prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1] + grid[i-1][j-1];
            }
        }

        // 使用前缀和计算总和
        long totalSum = prefixSum[m][n];

        // 如果总和是奇数，无法平分
        if (totalSum % 2 != 0) {
            return false;
        }

        long target = totalSum / 2;

        // 检查水平分割线
        for (int i = 1; i < m; i++) {
            // 使用前缀和计算上半部分的和
            long upperSum = prefixSum[i][n];
            if (upperSum == target) {
                return true;
            }
        }

        // 检查垂直分割线
        for (int j = 1; j < n; j++) {
            // 使用前缀和计算左半部分的和
            long leftSum = prefixSum[m][j];
            if (leftSum == target) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        CanPartitionGrid solution = new CanPartitionGrid();

        // 测试用例1
        int[][] grid1 = {{1, 4}, {2, 3}};
        System.out.println("测试用例1: " + solution.canPartitionGrid(grid1)); // 应该输出 true

        // 测试用例2
        int[][] grid2 = {{1, 3}, {2, 4}};
        System.out.println("测试用例2: " + solution.canPartitionGrid(grid2)); // 应该输出 false
    }
}