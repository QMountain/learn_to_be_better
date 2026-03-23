package algorithm.leetcode.medium.m;

public class MaxProductPath {

    /**
     * 1594. 矩阵的最大非负积
     * 给你一个大小为 m x n 的矩阵 grid 。
     * 最初，你位于左上角 (0, 0) ，每一步，你可以在矩阵中 向右 或 向下 移动。
     * 在从左上角 (0, 0) 开始到右下角 (m - 1, n - 1) 结束的所有路径中，
     * 找出具有 最大非负积 的路径。路径的积是沿路径访问的单元格中所有整数的乘积。
     * 返回 最大非负积 对 10^9 + 7 取余 的结果。如果最大积为 负数 ，则返回 -1 。
     * 注意，取余是在得到最大积之后执行的。
     * 输入：grid = [[-1,-2,-3],[-2,-3,-3],[-3,-3,-2]]
     * 输出：-1
     * 输入：grid = [[1,-2,1],[1,-2,1],[3,-4,1]]
     * 输出：8
     * 输入：grid = [[1,3],[0,-4]]
     * 输出：0
     */
    public int maxProductPath(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        int m = grid.length;
        int n = grid[0].length;
        long MOD = 1000000007;

        // 使用long防止溢出
        long[][] maxProd = new long[m][n];
        long[][] minProd = new long[m][n];

        // 初始化起点
        maxProd[0][0] = grid[0][0];
        minProd[0][0] = grid[0][0];

        // 初始化第一行
        for (int j = 1; j < n; j++) {
            maxProd[0][j] = maxProd[0][j-1] * grid[0][j];
            minProd[0][j] = minProd[0][j-1] * grid[0][j];
        }

        // 初始化第一列
        for (int i = 1; i < m; i++) {
            maxProd[i][0] = maxProd[i-1][0] * grid[i][0];
            minProd[i][0] = minProd[i-1][0] * grid[i][0];
        }

        // 填充剩余部分
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                long current = grid[i][j];
                long fromTopMax = maxProd[i-1][j] * current;
                long fromTopMin = minProd[i-1][j] * current;
                long fromLeftMax = maxProd[i][j-1] * current;
                long fromLeftMin = minProd[i][j-1] * current;

                // 计算当前位置的最大和最小乘积
                maxProd[i][j] = Math.max(Math.max(fromTopMax, fromTopMin), Math.max(fromLeftMax, fromLeftMin));
                minProd[i][j] = Math.min(Math.min(fromTopMax, fromTopMin), Math.min(fromLeftMax, fromLeftMin));
            }
        }

        // 检查最终结果
        long result = maxProd[m-1][n-1];
        if (result < 0) {
            return -1;
        }

        return (int)(result % MOD);
    }

    public static void main(String[] args) {
        MaxProductPath solution = new MaxProductPath();

        // 测试用例1
        int[][] grid1 = {{-1,-2,-3},{-2,-3,-3},{-3,-3,-2}};
        System.out.println("测试用例1结果: " + solution.maxProductPath(grid1)); // 预期输出: -1

        // 测试用例2
        int[][] grid2 = {{1,-2,1},{1,-2,1},{3,-4,1}};
        System.out.println("测试用例2结果: " + solution.maxProductPath(grid2)); // 预期输出: 8

        // 测试用例3
        int[][] grid3 = {{1,3},{0,-4}};
        System.out.println("测试用例3结果: " + solution.maxProductPath(grid3)); // 预期输出: 0
    }
}