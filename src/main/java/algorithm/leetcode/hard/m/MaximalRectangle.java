package algorithm.leetcode.hard.m;

public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] count = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            if (matrix[i][cols-1] == '0') {
                count[i][cols-1] = 0;
            } else {
                count[i][cols-1] = 1;
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = cols-2; j >= 0; j--) {
                if (matrix[i][j] == '0') {
                    count[i][j] = 0;
                } else {
                    if (matrix[i][j+1] == '0') {
                        count[i][j] = 1;
                    } else {
                        count[i][j] = count[i][j+1]+1;
                    }
                }
            }
        }
        int[][] countToDown = new int[rows][cols];
        for (int i = 0; i < cols; i++) {
            if (matrix[rows-1][i] == '0') {
                countToDown[rows-1][i] = 0;
            } else {
                countToDown[rows-1][i] = 1;
            }
        }
        for (int i = 0; i < cols; i++) {
            for (int j = rows-2; j >= 0; j--) {
                if (matrix[j][i] == '0') {
                    countToDown[j][i] = 0;
                } else {
                    if (matrix[j+1][i] == '0') {
                        countToDown[j][i] = 1;
                    } else {
                        countToDown[j][i] = countToDown[j+1][i]+1;
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int maxArea = countToDown[i][j];
                int width = countToDown[i][j];
                int length = count[i][j];
                for (int k = j+1; k < j+length; k++) {
                    width = Math.min(countToDown[i][k],width);
                    maxArea = Math.max(maxArea,(k-j+1)*width);
                }
                ans = Math.max(ans,maxArea);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximalRectangle maximalRectangle = new MaximalRectangle();
        System.out.println(maximalRectangle.maximalRectangle(new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        }));
    }
}
