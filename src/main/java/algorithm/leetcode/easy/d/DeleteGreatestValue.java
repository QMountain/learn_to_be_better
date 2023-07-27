package algorithm.leetcode.easy.d;

import java.util.Arrays;

public class DeleteGreatestValue {

    public int deleteGreatestValue(int[][] grid) {
        for (int[] ints : grid) {
            Arrays.sort(ints);
        }
        int cols = grid[0].length;
        int ans = 0;
        for (int i = 0; i < cols; i++) {
            int max = grid[0][i];
            for (int j = 1; j < grid.length; j++) {
                max = Math.max(max, grid[j][i]);
            }
            ans += max;
        }
        return ans;
    }

    public static void main(String[] args) {
        DeleteGreatestValue deleteGreatestValue = new DeleteGreatestValue();
        System.out.println(8 == deleteGreatestValue.deleteGreatestValue(
                new int[][]{{1,2,4},{3,3,1}}));
    }
}
