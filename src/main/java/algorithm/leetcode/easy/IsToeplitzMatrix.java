package algorithm.leetcode.easy;

public class IsToeplitzMatrix {

    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = i+1, k = 1; j < m && k < n; j++,k++) {
                if (matrix[j][k] != matrix[i][0]) {
                   return false;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1, k = i+1; j < m && k < n; j++,k++) {
                if (matrix[j][k] != matrix[0][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsToeplitzMatrix isToeplitzMatrix = new IsToeplitzMatrix();
        System.out.println(isToeplitzMatrix.isToeplitzMatrix(new int[][]{{11,74,0,93},{40,11,74,7}}));
    }
}
