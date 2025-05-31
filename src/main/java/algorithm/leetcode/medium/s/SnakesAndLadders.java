package algorithm.leetcode.medium.s;

import java.util.HashSet;
import java.util.Set;

public class SnakesAndLadders {

    /**
     * n == board.length == board[i].length
     * 2 <= n <= 20
     * board[i][j] 的值是 -1 或在范围 [1, n^2] 内
     * 编号为 1 和 n^2 的方格上没有蛇或梯子
     */
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[][] searched = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                searched[i][j] = -1;
            }
        }
        searched[n-1][0] = 1;
        int end = n * n;
        Set<Integer> set = new HashSet<>();
        set.add(1);
        int ans = 0;
        while (!set.isEmpty()) {
            ans++;
            Set<Integer> next = new HashSet<>();
            for (Integer x : set) {
                if (end - x <= 6) {
                    return ans;
                }
                Integer max = null;
                for (int i = 0; i < 6; i++) {
                    int[] rowColByNum = getRowColByNum(x + i, n);
                    int row = rowColByNum[0];
                    int col = rowColByNum[1];
                    if (board[row][col] != -1) {
                        int[] byNum = getRowColByNum(board[row][col] - 1, n);
                        if (searched[byNum[0]][byNum[1]] == -1 || ans < searched[byNum[0]][byNum[1]]) {
                            searched[byNum[0]][byNum[1]] = ans;
                            next.add(board[row][col]);
                        }
                        if (board[row][col] == end) {
                            return ans;
                        }
                    } else if (board[row][col] == -1) {
                        if (searched[row][col] == -1 || ans < searched[row][col]) {
                            searched[row][col] = ans;
                            max = i + 1;
                        }
                    }
                }
                if (max != null) {
                    next.add(x + max);
                }
            }
            set = next;
        }
        return -1;
    }

    private int[] getRowColByNum(int num, int n) {
        int row = n-1 - (num / n);
        boolean oddRow = (n-1) % 2 == row % 2;
        int col = oddRow ? num % n : (n - 1) - (num % n);
        return new int[]{row, col};
    }

    public static void main(String[] args) {
        SnakesAndLadders snakesAndLadders = new SnakesAndLadders();
        System.out.println(3 == snakesAndLadders.snakesAndLadders(
                new int[][]{
                        {-1,-1,-1,-1,48,5,-1},
                        {12,29,13,9,-1,2,32},
                        {-1,-1,21,7,-1,12,49},
                        {42,37,21,40,-1,22,12},
                        {42,-1,2,-1,-1,-1,6},
                        {39,-1,35,-1,-1,39,-1},
                        {-1,36,-1,-1,-1,-1,5}}));
        System.out.println(3 == snakesAndLadders.snakesAndLadders(
                new int[][]{
                        {-1,10,-1,15,-1},
                        {-1,-1,18,2,20},
                        {-1,-1,12,-1,-1},
                        {2,4,11,18,8},
                        {-1,-1,-1,-1,-1}}));
        System.out.println(-1 == snakesAndLadders.snakesAndLadders(
                new int[][]{
                        {1,1,-1},
                        {1,1,1},
                        {-1,1,1}}));
        System.out.println(1 == snakesAndLadders.snakesAndLadders(
                new int[][]{
                        {-1,-1,-1},
                        {-1,9,8},
                        {-1,8,9}}));
        System.out.println(4 == snakesAndLadders.snakesAndLadders(
                new int[][]{
                        {-1,-1,-1,-1,-1,-1},
                        {-1,-1,-1,-1,-1,-1},
                        {-1,-1,-1,-1,-1,-1},
                        {-1,35,-1,-1,13,-1},
                        {-1,-1,-1,-1,-1,-1},
                        {-1,15,-1,-1,-1,-1}}));
    }
}
