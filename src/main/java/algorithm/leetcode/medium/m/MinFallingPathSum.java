package algorithm.leetcode.medium.m;

public class MinFallingPathSum {

    // n == matrix.length == matrix[i].length
    // 1 <= n <= 100
    // -100 <= matrix[i][j] <= 100
    public int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 1) {
            int min = matrix[0][0];
            for (int i : matrix[0]) {
                min = Math.min(min, i);
            }
            return min;
        }
        int cols = matrix[0].length;
        int ans = Integer.MAX_VALUE;
        for (int i = rows-2; i >= 0; i--) {
            for (int j = 0; j < cols; j++) {
                int curr = matrix[i][j];
                int down = matrix[i+1][j];
                int min = curr + down;
                if (j > 0) {
                    min = Math.min(min, curr+matrix[i+1][j-1]);
                }
                if (j < cols-1) {
                    min = Math.min(min, curr+matrix[i+1][j+1]);
                }
                matrix[i][j] = min;
                if (i == 0) {
                    ans = Math.min(ans, min);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MinFallingPathSum minFallingPathSum = new MinFallingPathSum();
        System.out.println(-59 == minFallingPathSum.minFallingPathSum(new int[][]{{-19,57},{-40,-5}}));
        System.out.println(13 == minFallingPathSum.minFallingPathSum(new int[][]{{2,1,3},{6,5,4},{7,8,9}}));
    }
}
