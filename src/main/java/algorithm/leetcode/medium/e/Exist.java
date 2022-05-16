package algorithm.leetcode.medium.e;

import java.util.HashSet;
import java.util.Set;

public class Exist {

    public boolean exist2(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int length = word.length();
        int wordIndex = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(wordIndex)) {
                    if (wordIndex == length-1) {
                        return true;
                    }
                    Set<String> set = new HashSet<>(length);
                    set.add(i+","+j);
                    boolean dfs = dfs(board, m,n,word, length, i, j, wordIndex + 1, set);
                    if (dfs) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int m, int n, String word, int length, int i, int j, int wordIndex, Set<String> set) {
        if (i > 0) {
            String s = (i - 1) + "," + j;
            if (!set.contains(s) && board[i-1][j] == word.charAt(wordIndex)) {
                if (wordIndex == length-1) {
                    return true;
                }

                set.add(s);
                boolean dfs = dfs(board, m,n,word, length, i - 1, j, wordIndex + 1, set);
                if (dfs) {
                    return true;
                }
                set.remove(s);
            }
        }
        if (i < m-1) {
            String s = (i + 1) + "," + j;
            if (!set.contains(s) && board[i+1][j] == word.charAt(wordIndex)) {
                if (wordIndex == length-1) {
                    return true;
                }

                set.add(s);
                boolean dfs = dfs(board, m,n,word, length, i + 1, j, wordIndex + 1, set);
                if (dfs) {
                    return true;
                }
                set.remove(s);
            }
        }
        if (j > 0) {
            String s = i + "," + (j-1);
            if (!set.contains(s) && board[i][j-1] == word.charAt(wordIndex)) {
                if (wordIndex == length-1) {
                    return true;
                }
                set.add(s);
                boolean dfs = dfs(board, m,n,word, length, i, j-1, wordIndex + 1, set);
                if (dfs) {
                    return true;
                }
                set.remove(s);
            }
        }
        if (j < n-1) {
            String s = i + "," + (j+1);
            if (!set.contains(s) && board[i][j+1] == word.charAt(wordIndex)) {
                if (wordIndex == length-1) {
                    return true;
                }

                set.add(s);
                boolean dfs = dfs(board,m,n, word, length, i, j+1, wordIndex + 1, set);
                if (dfs) {
                    return true;
                }
                set.remove(s);
            }
        }
        return false;
    }

    // 官方题解
    public boolean exist(char[][] board, String word) {
        int h = board.length, w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                boolean flag = check(board, visited, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int k) {
        if (board[i][j] != s.charAt(k)) {
            return false;
        } else if (k == s.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for (int[] dir : directions) {
            int newi = i + dir[0], newj = j + dir[1];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                if (!visited[newi][newj]) {
                    boolean flag = check(board, visited, newi, newj, s, k + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return result;
    }


    public static void main(String[] args) {
        Exist exist = new Exist();
        System.out.println(exist.exist(new char[][]{{'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}}, "ABCCED"));
    }
}
