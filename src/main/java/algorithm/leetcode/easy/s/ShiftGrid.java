package algorithm.leetcode.easy.s;

import java.util.ArrayList;
import java.util.List;

public class ShiftGrid {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int x = (i+ ((j + k) / col)) % row ;
                int y = (j + k) % col;
                arr[x][y] = grid[i][j];
            }
        }
        List<List<Integer>> list = new ArrayList<>(row);
        for (int[] ints : arr) {
            List<Integer> rowList = new ArrayList<>(col);
            for (int anInt : ints) {
                rowList.add(anInt);
            }
            list.add(rowList);
        }
        return list;
    }

    public static void main(String[] args) {
        ShiftGrid shiftGrid = new ShiftGrid();
        System.out.println(shiftGrid.shiftGrid(new int[][]{{1,2,3},{4,5,6},{7,8,9}}, 1));
    }
}
