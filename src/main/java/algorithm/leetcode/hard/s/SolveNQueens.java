package algorithm.leetcode.hard.s;

import java.util.*;

public class SolveNQueens {

    /**
     * 解决N皇后问题，返回所有可能的解。
     * @param n 棋盘的大小，1 <= n <= 9。
     * @return 所有可能的解，每个解都是一个字符串列表，表示每一行的皇后位置。
     */
    // 1 <= n <= 9
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        if (n == 1) {
            List<String> list = new ArrayList<>();
            list.add("Q");
            ans.add(list);
            return ans;
        }
        char[][] grid = new char[n][n];
        for (char[] chars : grid) {
            Arrays.fill(chars, '.');
        }
        grid[0][0] = 'Q';
        int lastQRow = 0;
        Stack<Integer> colIndexStack = new Stack<>();
        colIndexStack.push(0);
        int from = -1;
        while (true) {
            // 本次尝试给第 lastRow + 1 行设置一个 Q
            if (setNextRow(n, grid, lastQRow + 1, from+1, colIndexStack)) {
                if (lastQRow + 1 == n-1) {
                    List<String> str = new ArrayList<>();
                    for (char[] chars : grid) {
                        str.add(new String(chars));
                    }
                    ans.add(str);
                    Integer pop = colIndexStack.pop();
                    grid[lastQRow+1][pop] = '.';
                    from = pop;
                } else {
                    lastQRow++;
                    from = -1;
                }
            } else {
                if (lastQRow == 0 && colIndexStack.peek() == n-1) {
                    break;
                }
                while (colIndexStack.peek() == n-1) {
                    Integer pop = colIndexStack.pop();
                    grid[lastQRow][pop] = '.';
                    lastQRow--;
                }
                int pop = colIndexStack.pop();
                grid[lastQRow][pop] = '.';
                if (lastQRow == 0) {
                    if (pop == n-1) {
                        break;
                    }
                    grid[lastQRow][pop+1] = 'Q';
                    colIndexStack.push(pop+1);
                    from = -1;
                } else {
                    lastQRow--;
                    from = pop;
                }
            }
        }
        return ans;
    }

    public boolean setNextRow(int n, char[][] grid, int row, int from, Stack<Integer> colIndexStack) {
        for (int i = from; i < n; i++) {
            boolean canSetAtICol = true;
            // 不能有同列的
            for (int j = 0; j < row; j++) {
                if (grid[j][i] == 'Q') {
                    canSetAtICol = false;
                    break;
                }
            }
            // 第 i 列，之前的行已经存在了，放在这列不行
            if (!canSetAtICol) {
                continue;
            }
            // 左上
            for (int r = row-1, c = i-1; r >= 0 && c >= 0 ; r--, c--) {
                if (grid[r][c] == 'Q') {
                    canSetAtICol = false;
                    break;
                }
            }
            if (!canSetAtICol) {
                continue;
            }
            // 右上
            for (int r = row-1, c = i+1; r >= 0 && c < n ; r--, c++) {
                if (grid[r][c] == 'Q') {
                    canSetAtICol = false;
                    break;
                }
            }
            if (canSetAtICol) {
                grid[row][i] = 'Q';
                colIndexStack.push(i);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SolveNQueens solveNQueens = new SolveNQueens();
        System.out.println(solveNQueens.solveNQueens(4));
        System.out.println(solveNQueens.solveNQueens(3));
        System.out.println(solveNQueens.solveNQueens(2));
        System.out.println(solveNQueens.solveNQueens(1));
    }
}
