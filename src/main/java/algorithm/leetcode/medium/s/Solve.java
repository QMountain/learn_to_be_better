package algorithm.leetcode.medium.s;

import java.util.HashSet;
import java.util.Set;

public class Solve {

    char[][] board;
    int m;
    int n;

    public void solve(char[][] board) {
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O') {
                    Set<String> set = new HashSet<>();
                    getConsecutivePoints(set, i, j);
                    boolean canChange = true;
                    for (String s : set) {
                        String[] split = s.split(",");
                        int x = Integer.parseInt(split[0]);
                        int y = Integer.parseInt(split[1]);
                        if (x == 0 || x == m-1 || y == 0 || y == n-1) {
                            canChange = false;
                            break;
                        }
                    }
                    if (canChange) {
                        for (String s1 : set) {
                            String[] split1 = s1.split(",");
                            int row = Integer.parseInt(split1[0]);
                            int col = Integer.parseInt(split1[1]);
                            board[row][col] = 'X';
                        }
                    }
                }
            }
        }

    }

    public void getConsecutivePoints(Set<String> set, int x, int y) {
        set.add(x+","+y);
        if (x > 0 && board[x-1][y] == 'O') {
            String point = (x-1)+","+y;
            if (!set.contains(point)) {
                getConsecutivePoints(set,x-1,y);
            }
        }
        if (x < m-1 && board[x+1][y] == 'O') {
            String point = (x+1)+","+y;
            if (!set.contains(point)) {
                getConsecutivePoints(set,x+1,y);
            }
        }
        if (y > 0 && board[x][y-1] == 'O') {
            String point = x +","+(y-1);
            if (!set.contains(point)) {
                getConsecutivePoints(set,x,y-1);
            }
        }
        if (y < n-1 && board[x][y+1] == 'O') {
            String point = x +","+(y+1);
            if (!set.contains(point)) {
                getConsecutivePoints(set,x,y+1);
            }
        }
    }

    public static void main(String[] args) {
        Solve solve = new Solve();
        solve.solve(new char[][]{
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'},
        });
    }
}
