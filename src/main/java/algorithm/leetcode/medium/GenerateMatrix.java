package algorithm.leetcode.medium;

import java.util.Arrays;

public class GenerateMatrix {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        matrix[0][0] = 1;
        setMatrix(matrix,n,0,0,0,2);
        return matrix;
    }

    public void setMatrix(int[][] matrix, int n, int x, int y, int towards,int value) {
        boolean canUp = x > 0 && matrix[x-1][y] == 0;
        boolean canRight = y < n-1 && matrix[x][y+1] == 0;
        boolean canDown = x < n-1 && matrix[x+1][y] == 0;
        boolean canLeft = y > 0 && matrix[x][y-1] == 0;

        if (!canUp && !canRight && !canDown && !canLeft) {
            return;
        }

        // first up
        if (towards == 0) {
            if (x == 0) {
                // towards right
                setMatrix(matrix,n,x,y,1,value);
            } else {
                if (matrix[x-1][y] != 0) {
                    // towards right
                    setMatrix(matrix,n,x,y,1,value);
                } else {
                    matrix[x-1][y] = value;
                    setMatrix(matrix,n,x-1,y,0,value+1);
                }
            }
        }
        if (towards == 1) {
            if (y == n-1) {
                // turn to down
                setMatrix(matrix,n,x,y,2,value);
            } else {
                if (matrix[x][y+1] != 0) {
                    // turn to down
                    setMatrix(matrix,n,x,y,2,value);
                } else {
                    matrix[x][y+1] = value;
                    setMatrix(matrix,n,x,y+1,1,value+1);
                }
            }
        }
        if (towards == 2) {
            if (x == n-1) {
                // turn to left
                setMatrix(matrix,n,x,y,3,value);
            } else {
                if (matrix[x+1][y] != 0) {
                    // turn to left
                    setMatrix(matrix,n,x,y,3,value);
                } else {
                    matrix[x+1][y] = value;
                    setMatrix(matrix,n,x+1,y,2,value+1);
                }
            }
        }
        if (towards == 3) {
            if (y == 0) {
                // turn to up
                setMatrix(matrix,n,x,y,0,value);
            } else {
                if (matrix[x][y-1] != 0) {
                    // turn to up
                    setMatrix(matrix,n,x,y,0,value);
                } else {
                    matrix[x][y-1] = value;
                    setMatrix(matrix,n,x,y-1,3,value+1);
                }
            }
        }
    }

    public static void main(String[] args) {
        GenerateMatrix generateMatrix = new GenerateMatrix();
        System.out.println(Arrays.deepToString(generateMatrix.generateMatrix(3)));
        System.out.println(Arrays.deepToString(generateMatrix.generateMatrix(1)));
    }
}
