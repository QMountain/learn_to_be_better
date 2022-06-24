package algorithm.leetcode.medium.i;

import java.util.HashSet;
import java.util.Set;

public class IsValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rowSetArr = new Set[9];
        Set<Character>[] colSetArr = new Set[9];
        Set<Character>[][] nineSetArr = new Set[3][3];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (rowSetArr[i] == null) {
                        rowSetArr[i] = new HashSet<>(9);
                    }
                    if (!rowSetArr[i].add(c)) {
                        return false;
                    }
                    if (colSetArr[j] == null) {
                        colSetArr[j] = new HashSet<>(9);
                    }
                    if (!colSetArr[j].add(c)) {
                        return false;
                    }
                    int x = i / 3;
                    int y = j / 3;
                    if (nineSetArr[x][y] == null) {
                        nineSetArr[x][y] = new HashSet<>(9);
                    }
                    if (!nineSetArr[x][y].add(c)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsValidSudoku isValidSudoku = new IsValidSudoku();
        System.out.println(isValidSudoku.isValidSudoku(new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}}));
    }
}
