package algorithm.leetcode.hard.c;

import java.util.HashSet;
import java.util.Set;

public class CanMouseWin {

    public boolean canMouseWin(String[] grid, int catJump, int mouseJump) {
        int mouseJumpTimes = 1;
        Set<String> confirmWinner = new HashSet<>();
        while (mouseJumpTimes < 1000) {

            mouseJumpTimes++;
        }
        return false;
    }

    public boolean canMouseWin2(String[] grid, int catJump, int mouseJump) {
        int rows = grid.length;
        int cols = grid[0].length();
        int catRow = 0;
        int catCol = 0;
        int mouseRow = 0;
        int mouseCol = 0;
        int foodRow = 0;
        int foodCol = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char c = grid[i].charAt(j);
                if (c == 'C') {
                    catRow = i;
                    catCol = j;
                } else if (c == 'M') {
                    mouseRow = i;
                    mouseCol = j;
                } else if (c == 'F') {
                    foodRow = i;
                    foodCol = j;
                }
            }
        }
        // check mouse one step to food
        if (canOneStepToFood(grid,mouseRow,mouseCol,mouseJump,foodRow,foodCol)) {
            return true;
        }
        // check cat one step to food
        if (canOneStepToFood(grid,catRow,catCol,catJump,foodRow,foodCol)) {
            return false;
        }
        for (int i = mouseRow-1; i >= mouseRow-mouseJump && i >= 0; i--) {
            if (i != catRow || mouseCol != catCol) {
                if (grid[i].charAt(mouseCol) == '#') {
                    break;
                }
                if (i == catRow && Math.abs(catCol-mouseCol) <= catJump) {
                    continue;
                }
                if (mouseCol == catCol && Math.abs(catRow-i) <= catJump) {
                    continue;
                }
                // now mouse at grid(i,mouseCol)
                for (int j = catRow-1; j >= catRow-catJump && j >= 0; j--) {
                    if (grid[j].charAt(catCol) == '#') {
                        break;
                    }

                }
            }
        }
        char[][] board = new char[rows][cols];

        // cat i j mouse i j canMouseWin 1
        int[][] dp = new int[rows*cols*rows*cols][5];

        return false;
    }

    public boolean canOneStepToFood(String[] grid, int row, int col, int jump, int foodRow, int foodCol) {
        if (row == foodRow && Math.abs(col-foodCol) <= jump) {
            String s = grid[row];
            int start;
            int end;
            if (col > foodCol) {
                start = foodCol;
                end = col;
            } else {
                start = col;
                end = foodCol;
            }
            boolean canJump = true;
            for (int i = start+1; i < end; i++) {
                if (s.charAt(i) == '#') {
                    canJump = false;
                    break;
                }
            }
            if (canJump) {
                return true;
            }
        }
        if (col == foodCol && Math.abs(row-foodRow) <= jump) {
            int start;
            int end;
            if (row > foodRow) {
                start = foodRow;
                end = row;
            } else {
                start = row;
                end = foodRow;
            }
            boolean canJump = true;
            for (int i = start+1; i < end; i++) {
                if (grid[i].charAt(col) == '#') {
                    canJump = false;
                    break;
                }
            }
            return canJump;
        }
        return false;
    }
}
