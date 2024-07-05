package algorithm.leetcode.easy.m;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModifiedMatrix {

    public int[][] modifiedMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        List<Integer> list = new ArrayList<>();
        int[][] answer = new int[rows][cols];
        for (int i = 0; i < cols; i++) {
            int max = matrix[0][i];
            list.clear();
            if (max == -1) {
                list.add(0);
            } else {
                answer[0][i] = max;
            }
            for (int j = 1; j < rows; j++) {
                if (matrix[j][i] == -1) {
                    list.add(j);
                } else {
                    answer[j][i] = matrix[j][i];
                    max = Math.max(max, matrix[j][i]);
                }
            }
            for (Integer index : list) {
                answer[index][i] = max;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        ModifiedMatrix modifiedMatrix = new ModifiedMatrix();
        System.out.println(Arrays.deepToString(modifiedMatrix.modifiedMatrix(
                new int[][]{{1,2,-1},{4,-1,6},{7,8,9}})));
    }
}
