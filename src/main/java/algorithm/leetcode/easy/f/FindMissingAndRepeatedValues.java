package algorithm.leetcode.easy.f;

import java.util.Arrays;

public class FindMissingAndRepeatedValues {

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] ans = new int[2];
        int length = grid.length;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int num = grid[i][j];
                int row = (num - 1) / length;
                int col = (num % length + length - 1) % length;
                if (row == i && col == j) {
                    sum += num;
                    continue;
                }
                if (ans[0] != 0) {
                    sum += num;
                    continue;
                }
                if (grid[row][col] == num) {
                    ans[0] = num;
                } else {
                    int tmp = grid[i][j];
                    grid[i][j] = grid[row][col];
                    grid[row][col] = tmp;
                    j--;
                }
            }
        }
        int count = length * length;
        ans[1] = (1 + count) * count / 2 - sum;
        return ans;
    }

    public static void main(String[] args) {
        FindMissingAndRepeatedValues findMissingAndRepeatedValues = new FindMissingAndRepeatedValues();
        System.out.println(Arrays.toString(findMissingAndRepeatedValues
                .findMissingAndRepeatedValues(new int[][]{{1,45,47,26,41,34,29,36},{28,24,50,57,39,37,46,21},{30,44,25,7,59,14,55,11},{52,48,22,2,23,18,40,12},{38,62,13,16,20,60,53,42},{27,15,64,17,32,33,19,9},{58,4,35,49,30,3,61,63},{5,43,8,54,31,10,56,6}}
                )));
        System.out.println(Arrays.toString(findMissingAndRepeatedValues
                .findMissingAndRepeatedValues(new int[][]{{1,3},{2,2}})));
    }
}
