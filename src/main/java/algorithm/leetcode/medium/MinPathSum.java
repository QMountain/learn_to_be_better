package algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class MinPathSum {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        List<String> path = new ArrayList<>();
        int min = 0;
        for (int i = 0; i < n; i++) {
            min += grid[0][i];
            path.add(0+","+i);
            for (int j = 1; j < m; j++) {
                min += grid[j][n-1];
                path.add(j+","+(n-1));
            }
        }
        if (m == 1 || n == 1) {
            return grid[m-1][n-1];
        }
        return 0;
    }

}
