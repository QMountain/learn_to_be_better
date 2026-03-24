package algorithm.leetcode.medium.c;

public class ConstructProductMatrix {

    /**
     * 2906. 构造乘积矩阵
     * 给你一个下标从 0 开始、大小为 n * m 的二维整数矩阵 grid ，
     * 定义一个下标从 0 开始、大小为 n * m 的的二维矩阵 p。
     * 如果满足以下条件，则称 p 为 grid 的 乘积矩阵 ：
     * 对于每个元素 p[i][j] ，它的值等于除了 grid[i][j] 外所有元素的乘积。乘积对 12345 取余数。
     * 返回 grid 的乘积矩阵。
     * 输入：grid = [[1,2],[3,4]]
     * 输出：[[24,12],[8,6]]
     * 输入：grid = [[12345],[2],[1]]
     * 输出：[[2],[0],[0]]
     */
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] result = new int[n][m];

        // 使用前缀乘积和后缀乘积的方法
        // 将二维数组展平为一维数组进行处理
        int[] flatGrid = new int[n * m];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                flatGrid[index++] = grid[i][j];
            }
        }

        // 计算前缀乘积
        long[] prefix = new long[n * m];
        prefix[0] = flatGrid[0] % 12345;
        for (int i = 1; i < n * m; i++) {
            prefix[i] = (prefix[i-1] * flatGrid[i]) % 12345;
        }

        // 计算后缀乘积
        long[] suffix = new long[n * m];
        suffix[n * m - 1] = flatGrid[n * m - 1] % 12345;
        for (int i = n * m - 2; i >= 0; i--) {
            suffix[i] = (suffix[i+1] * flatGrid[i]) % 12345;
        }

        // 计算结果
        for (int i = 0; i < n * m; i++) {
            long product = 1;
            if (i > 0) {
                product = (product * prefix[i-1]) % 12345;
            }
            if (i < n * m - 1) {
                product = (product * suffix[i+1]) % 12345;
            }

            // 将结果放回二维数组
            int row = i / m;
            int col = i % m;
            result[row][col] = (int)product;
        }

        return result;
    }

}
