package algorithm.leetcode.medium.u;

public class UniquePathsWithObstacles {

    int[][] obstacleGrid;
    int m;
    int n;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        this.obstacleGrid = obstacleGrid;
        this.m = obstacleGrid.length;
        this.n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) {
            return 0;
        }
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] != 1) {
                dp[0][i] = dp[0][i-1];
            }
        }
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] != 1) {
                dp[i][0] = dp[i-1][0];
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] != 1) {
                    int count = 0;
                    if (obstacleGrid[i - 1][j] == 0) {
                        count += dp[i-1][j];
                    }
                    if (obstacleGrid[i][j - 1] == 0) {
                        count += dp[i][j-1];
                    }
                    dp[i][j] = count;
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        UniquePathsWithObstacles uniquePathsWithObstacles = new UniquePathsWithObstacles();
        System.out.println(1 == uniquePathsWithObstacles.uniquePathsWithObstacles(new int[][]{{0},{0}}));
        System.out.println(1 == uniquePathsWithObstacles.uniquePathsWithObstacles(new int[][]{{0,0}}));
        System.out.println(1 == uniquePathsWithObstacles.uniquePathsWithObstacles(new int[][]{{0}}));
        System.out.println(2 == uniquePathsWithObstacles.uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
    }
}
