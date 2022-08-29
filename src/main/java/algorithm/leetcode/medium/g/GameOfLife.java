package algorithm.leetcode.medium.g;

public class GameOfLife {

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        // 死细胞复活 0 -> 2;
        // 活细胞死亡 1 -> -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int countAlive = 0;
                if (i > 0 && j > 0 && (board[i-1][j-1] == 1 || board[i-1][j-1] == -1)) {
                    countAlive++;
                }
                if (i > 0 && (board[i-1][j] == 1 || board[i-1][j] == -1)) {
                    countAlive++;
                }
                if (i > 0 && j < n-1 && (board[i-1][j+1] == 1 || board[i-1][j+1] == -1)) {
                    countAlive++;
                }
                if (j > 0 && (board[i][j-1] == 1 || board[i][j-1] == -1)) {
                    countAlive++;
                }
                if (j < n-1 && (board[i][j+1] == 1 || board[i][j+1] == -1)) {
                    countAlive++;
                }
                if (i < m-1 && j > 0 && (board[i+1][j-1] == 1 || board[i+1][j-1] == -1)) {
                    countAlive++;
                }
                if (i < m-1 && (board[i+1][j] == 1 || board[i+1][j] == -1)) {
                    countAlive++;
                }
                if (i < m-1 && j < n-1 && (board[i+1][j+1] == 1 || board[i+1][j+1] == -1)) {
                    countAlive++;
                }
                if (board[i][j] == 0 && countAlive == 3) {
                    board[i][j] = 2;
                } else if (board[i][j] == 1){
                    if (countAlive < 2 || countAlive > 3) {
                        board[i][j] = -1;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                } else if (board[i][j] == -1) {
                    board[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        GameOfLife gameOfLife = new GameOfLife();
        gameOfLife.gameOfLife(new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}});
    }
}
