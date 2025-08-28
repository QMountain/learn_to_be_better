package algorithm.leetcode.medium.s;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortMatrix {

    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        int[][] ans = new int[n][n];
        for (int i = 0; i < n; i++) {
            // 起点 grid[i][0]
            List<Integer> list = new ArrayList<>();
            for (int row = i, col = 0; row < n && col < n; row++, col++) {
                list.add(grid[row][col]);
            }
            Collections.sort(list);
            int index = list.size()-1;
            for (int row = i, col = 0; row < n && col < n; row++, col++) {
                ans[row][col] = list.get(index--);
            }
        }
        for (int i = 1; i < n; i++) {
            // 起点 grid[0][i]
            List<Integer> list = new ArrayList<>();
            for (int row = 0, col = i; row < n && col < n; row++, col++) {
                list.add(grid[row][col]);
            }
            Collections.sort(list);
            int index = 0;
            for (int row = 0, col = i; row < n && col < n; row++, col++) {
                ans[row][col] = list.get(index++);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SortMatrix sortMatrix = new SortMatrix();
        System.out.println(Arrays.deepToString(sortMatrix.sortMatrix(new int[][]{{1,7,3},{9,8,2},{4,5,6}})));
    }
}
