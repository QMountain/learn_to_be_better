package algorithm.leetcode.medium.n;

public class NumberOfSubmatrices {

    /**
     * 3212. 统计 X 和 Y 频数相等的子矩阵数量
     * 给你一个二维字符矩阵 grid，其中 grid[i][j] 可能是 'X'、'Y' 或 '.'，返回满足以下条件的子矩阵数量：
     * 包含 grid[0][0]
     * 'X' 和 'Y' 的频数相等。
     * 至少包含一个 'X'。
     * 1 <= grid.length, grid[i].length <= 1000
     * grid[i][j] 可能是 'X'、'Y' 或 '.'.
     */
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // 计算前缀和数组
        // prefixX[i][j] 表示从(0,0)到(i-1,j-1)矩形区域内X的数量
        // prefixY[i][j] 表示从(0,0)到(i-1,j-1)矩形区域内Y的数量
        int[][] prefixX = new int[m + 1][n + 1];
        int[][] prefixY = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefixX[i][j] = prefixX[i-1][j] + prefixX[i][j-1] - prefixX[i-1][j-1];
                prefixY[i][j] = prefixY[i-1][j] + prefixY[i][j-1] - prefixY[i-1][j-1];

                if (grid[i-1][j-1] == 'X') {
                    prefixX[i][j]++;
                } else if (grid[i-1][j-1] == 'Y') {
                    prefixY[i][j]++;
                }
            }
        }

        int count = 0;

        // 枚举所有可能的右下角(i,j)
        // 由于子矩阵必须包含(0,0)，所以左上角只能是(0,0)
        // 我们只需要枚举右下角位置
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 计算从(0,0)到(i-1,j-1)的子矩阵中X和Y的数量
                int countX = prefixX[i][j];
                int countY = prefixY[i][j];

                // 检查条件：X和Y的频数相等，且至少包含一个X
                if (countX == countY && countX > 0) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        NumberOfSubmatrices numberOfSubmatrices = new NumberOfSubmatrices();

        // 测试用例1
        System.out.println("测试1: " + numberOfSubmatrices.numberOfSubmatrices(
                new char[][]{{'X','Y','.'},{'Y','.','.'}}));

        // 测试用例2
        char[][] grid2 = {
            {'X', 'X'},
            {'Y', 'Y'}
        };
        System.out.println("测试2: " + numberOfSubmatrices.numberOfSubmatrices(grid2));

        // 测试用例3
        char[][] grid3 = {
            {'.', 'X'},
            {'Y', '.'}
        };
        System.out.println("测试3: " + numberOfSubmatrices.numberOfSubmatrices(grid3));

        // 测试用例4：边界情况
        char[][] grid4 = {
            {'X'}
        };
        System.out.println("测试4: " + numberOfSubmatrices.numberOfSubmatrices(grid4));

        // 测试用例5：没有X的情况
        char[][] grid5 = {
            {'.', 'Y'},
            {'Y', '.'}
        };
        System.out.println("测试5: " + numberOfSubmatrices.numberOfSubmatrices(grid5));
    }
}
