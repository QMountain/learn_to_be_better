package algorithm.leetcode.medium.m;

import java.util.Arrays;

public class MatrixSum {

    public int matrixSum(int[][] nums) {
        for (int[] num : nums) {
            Arrays.sort(num);
        }
        int sum = 0;
        int length = nums[0].length;
        int rows = nums.length;
        for (int i = length-1; i >= 0; i--) {
            int max = nums[0][i];
            for (int j = 1; j < rows; j++) {
                max = Math.max(max, nums[j][i]);
            }
            sum += max;
        }
        return sum;
    }

}
