package algorithm.leetcode.easy.n;

public class NumRookCaptures {

    public int numRookCaptures(char[][] board) {
        int res = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    // up
                    for (int k = i-1; k >= 0; k--) {
                        if (board[k][j] == 'B') {
                            break;
                        }
                        if (board[k][j] == 'p') {
                            res++;
                            break;
                        }
                    }
                    // down
                    for (int k = i+1; k < 8; k++) {
                        if (board[k][j] == 'B') {
                            break;
                        }
                        if (board[k][j] == 'p') {
                            res++;
                            break;
                        }
                    }
                    // left
                    for (int k = j-1; k >= 0; k--) {
                        if (board[i][k] == 'B') {
                            break;
                        }
                        if (board[i][k] == 'p') {
                            res++;
                            break;
                        }
                    }
                    // right
                    for (int k = j+1; k < 8; k++) {
                        if (board[i][k] == 'B') {
                            break;
                        }
                        if (board[i][k] == 'p') {
                            res++;
                            break;
                        }
                    }
                }
            }
        }
        return res;
    }

}
