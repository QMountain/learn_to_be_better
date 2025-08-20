package algorithm.leetcode.medium.c;

public class CountSquares {

    /**
     * 1 <= arr.length <= 300
     * 1 <= arr[0].length <= 300
     * 0 <= arr[i][j] <= 1
     */
    public int countSquares(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] countUp = new int[rows][cols];
        int[][] countLeft = new int[rows][cols];
        int[][] countPre = new int[rows][cols];
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    int cp = i > 0 && j > 0 ? countPre[i-1][j-1] : 0;
                    int c = Math.min(i > 0 ? countUp[i-1][j] : 0, j > 0 ? countLeft[i][j-1] : 0);
                    int min = Math.min(cp, c);
                    ans += min + 1;

                    if (i > 0) {
                        countUp[i][j] = countUp[i-1][j] + 1;
                    } else {
                        countUp[i][j] = 1;
                    }

                    if (j > 0) {
                        countLeft[i][j] = countLeft[i][j-1] + 1;
                    } else {
                        countLeft[i][j] = 1;
                    }

                    countPre[i][j] = min + 1;

                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        CountSquares countSquares = new CountSquares();
        System.out.println(15 == countSquares.countSquares(
                new int[][]{
                        {0,1,1,1},
                        {1,1,1,1},
                        {0,1,1,1}
                }));
    }
}
