package algorithm.leetcode.medium.m;

public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    max = Math.max(max,1);
                    if (i == m-1 || j == n-1) {
                        continue;
                    }
                    if (i+max >= m || j+max >= n) {
                        continue;
                    }
                    boolean needTry = true;
                    for (int k = i; k < i+max; k++) {
                        for (int l = j; l < j + max; l++) {
                            if (matrix[k][l] == '0') {
                                needTry = false;
                                break;
                            }
                        }
                        if (!needTry) {
                            break;
                        }
                    }
                    if (!needTry) {
                        continue;
                    }
                    int tryLength = max+1;
                    while (true) {
                        boolean goNext = true;
                        int x = i+tryLength-1;
                        for (int k = j; k < j+tryLength && k < n; k++) {
                            if (matrix[x][k] == '0') {
                                goNext = false;
                                break;
                            }
                        }
                        if (!goNext) {
                            break;
                        }
                        int y = j+tryLength-1;
                        for (int k = i; k < i + tryLength && k < m; k++) {
                            if (matrix[k][y] == '0') {
                                goNext = false;
                                break;
                            }
                        }
                        if (goNext) {
                            max = Math.max(max,tryLength);
                            if (i+tryLength < m && j+tryLength < n) {
                                tryLength++;
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    max = Math.max(max,tryLength-1);
                }
            }
        }
        return max*max;
    }

    public static void main(String[] args) {
        MaximalSquare maximalSquare = new MaximalSquare();
        System.out.println(maximalSquare.maximalSquare(new char[][]{
                {'1','1','1','1','1'},
                {'1','1','1','1','1'},
                {'0','0','0','0','0'},
                {'1','1','1','1','1'},
                {'1','1','1','1','1'}}));
        System.out.println(maximalSquare.maximalSquare(new char[][]{{'1', '1'}, {'1', '1'}}));
        System.out.println(maximalSquare.maximalSquare(new char[][]{
                {'0','0','0'},
                {'0','0','0'},
                {'1','1','1'}}));
        System.out.println(maximalSquare.maximalSquare(new char[][]{{'0'}}));
        System.out.println(maximalSquare.maximalSquare(new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}}));
    }
}
