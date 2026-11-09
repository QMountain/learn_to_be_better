package algorithm.leetcode.medium.u;

import java.util.Arrays;

public class UpdateBoard {

    /**
     * 529. 扫雷游戏
     * 让我们一起来玩扫雷游戏！
     * 给你一个大小为 m x n 二维字符矩阵 board ，表示扫雷游戏的盘面，其中：
     * 'M' 代表一个 未挖出的 地雷，
     * 'E' 代表一个 未挖出的 空方块，
     * 'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的 已挖出的 空白方块，
     * 数字（'1' 到 '8'）表示有多少地雷与这块 已挖出的 方块相邻，
     * 'X' 则表示一个 已挖出的 地雷。
     * 给你一个整数数组 click ，
     * 其中 click = [clickr, clickc] 表示在所有 未挖出的 方块（'M' 或者 'E'）
     * 中的下一个点击位置（clickr 是行下标，clickc 是列下标）。
     * 根据以下规则，返回相应位置被点击后对应的盘面：
     * 1. 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X' 。
     * 2. 如果一个 没有相邻地雷 的空方块（'E'）被挖出，修改它为（'B'），
     * 并且所有和其相邻的 未挖出 方块都应该被递归地揭露。
     * 3. 如果一个 至少与一个地雷相邻 的空方块（'E'）被挖出，修改它为数字（'1' 到 '8' ），表示相邻地雷的数量。
     * 4. 如果在此次点击中，若无更多方块可被揭露，则返回盘面。
     * click.length == 2
     */
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        // count M
        int count = 0;
        if (click[0] > 0 && click[1] > 0) {
            if (board[click[0]-1][click[1]-1] == 'M' || board[click[0]-1][click[1]-1] == 'X') {
                count++;
            }
        }
        if (click[0] > 0) {
            if (board[click[0]-1][click[1]] == 'M' || board[click[0]-1][click[1]] == 'X') {
                count++;
            }
        }
        if (click[0] > 0 && click[1] < board[0].length - 1) {
            if (board[click[0]-1][click[1]+1] == 'M' || board[click[0]-1][click[1]+1] == 'X') {
                count++;
            }
        }
        if (click[1] > 0) {
            if (board[click[0]][click[1]-1] == 'M' || board[click[0]][click[1]-1] == 'X') {
                count++;
            }
        }
        if (click[1] < board[0].length - 1) {
            if (board[click[0]][click[1]+1] == 'M' || board[click[0]][click[1]+1] == 'X') {
                count++;
            }
        }
        if (click[0] < board.length - 1 && click[1] > 0) {
            if (board[click[0]+1][click[1]-1] == 'M' || board[click[0]+1][click[1]-1] == 'X') {
                count++;
            }
        }
        if (click[0] < board.length - 1) {
            if (board[click[0]+1][click[1]] == 'M' || board[click[0]+1][click[1]] == 'X') {
                count++;
            }
        }
        if (click[0] < board.length - 1 && click[1] < board[0].length - 1) {
            if (board[click[0]+1][click[1]+1] == 'M' || board[click[0]+1][click[1]+1] == 'X') {
                count++;
            }
        }
        if (count == 0) {
            board[click[0]][click[1]] = 'B';
            if (click[0] > 0 && click[1] > 0 && board[click[0]-1][click[1]-1] == 'E') {
                updateBoard(board, new int[]{click[0]-1, click[1]-1});
            }
            if (click[0] > 0 && board[click[0]-1][click[1]] == 'E') {
                updateBoard(board, new int[]{click[0]-1, click[1]});
            }
            if (click[0] > 0 && click[1] < board[0].length - 1 && board[click[0]-1][click[1]+1] == 'E') {
                updateBoard(board, new int[]{click[0]-1, click[1]+1});
            }
            if (click[1] > 0 && board[click[0]][click[1]-1] == 'E') {
                updateBoard(board, new int[]{click[0], click[1]-1});
            }
            if (click[1] < board[0].length - 1 && board[click[0]][click[1]+1] == 'E') {
                updateBoard(board, new int[]{click[0], click[1]+1});
            }
            if (click[0] < board.length - 1 && click[1] > 0 && board[click[0]+1][click[1]-1] == 'E') {
                updateBoard(board, new int[]{click[0]+1, click[1]-1});
            }
            if (click[0] < board.length - 1 && board[click[0]+1][click[1]] == 'E') {
                updateBoard(board, new int[]{click[0]+1, click[1]});
            }
            if (click[0] < board.length - 1 && click[1] < board[0].length - 1 && board[click[0]+1][click[1]+1] == 'E') {
                updateBoard(board, new int[]{click[0]+1, click[1]+1});
            }
            return board;
        }
        board[click[0]][click[1]] = (char) ('0' + count);
        return board;
    }

    public static void main(String[] args) {
        UpdateBoard updateBoard = new UpdateBoard();
        System.out.println(Arrays.deepToString(updateBoard.updateBoard(
                new char[][]{{'E', 'E', 'E', 'E', 'E'},
                        {'E', 'E', 'M', 'E', 'E'},
                        {'E', 'E', 'E', 'E', 'E'},
                        {'E', 'E', 'E', 'E', 'E'}}, new int[]{3, 0})));
    }
}
