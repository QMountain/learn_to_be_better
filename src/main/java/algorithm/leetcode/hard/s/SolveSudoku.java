package algorithm.leetcode.hard.s;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SolveSudoku {

    public void solveSudoku(char[][] board) {
        Set<Character>[] rowSetArr = new Set[9];
        Set<Character>[] colSetArr = new Set[9];
        for (int i = 0; i < 9; i++) {
            rowSetArr[i] = new HashSet<>();
            colSetArr[i] = new HashSet<>();
        }
        Set<Character>[][] nineSetArr = new Set[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                nineSetArr[i][j] = new HashSet<>();
            }
        }
        int unsolved = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    rowSetArr[i].add(c);
                    colSetArr[j].add(c);
                    int nineX = i / 3;
                    int nineY = j / 3;
                    nineSetArr[nineX][nineY].add(c);
                } else {
                    unsolved++;
                }
            }
        }
        while (unsolved > 0) {
            boolean goNext = false;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    char c = board[i][j];
                    if (c == '.') {
                        Set<Character> checkSet = new HashSet<>(9);
                        checkSet.addAll(rowSetArr[i]);
                        checkSet.addAll(colSetArr[j]);
                        int nineX = i / 3;
                        int nineY = j / 3;
                        checkSet.addAll(nineSetArr[nineX][nineY]);
                        if (checkSet.size() == 8) {
                            goNext = true;
                            unsolved--;
                            for (char k = '1'; k <= '9'; k++) {
                                if (!checkSet.contains(k)) {
                                    board[i][j] = k;
                                    rowSetArr[i].add(k);
                                    colSetArr[j].add(k);
                                    nineSetArr[nineX][nineY].add(k);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            if (!goNext) {
                break;
            }
        }
        if (unsolved > 0) {
            goNext(board,rowSetArr,colSetArr,nineSetArr);
        }
    }

    public boolean goNext(char[][] board, Set<Character>[] rowSetArr,
                          Set<Character>[] colSetArr, Set<Character>[][] nineSetArr) {
        int changeX = -1;
        int changeY = -1;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    changeX = i;
                    changeY = j;
                    break;
                }
            }
        }
        if (changeX == -1) {
            return true;
        }
        Set<Character> checkSet = new HashSet<>(9);
        checkSet.addAll(rowSetArr[changeX]);
        checkSet.addAll(colSetArr[changeY]);
        int nineX = changeX / 3;
        int nineY = changeY / 3;
        checkSet.addAll(nineSetArr[nineX][nineY]);
        if (checkSet.size() == 9) {
            return false;
        }
        for (char k = '1'; k <= '9'; k++) {
            if (!checkSet.contains(k)) {
                board[changeX][changeY] = k;
                rowSetArr[changeX].add(k);
                colSetArr[changeY].add(k);
                nineSetArr[nineX][nineY].add(k);
                boolean b = goNext(board, rowSetArr, colSetArr, nineSetArr);
                if (!b) {
                    board[changeX][changeY] = '.';
                    rowSetArr[changeX].remove(k);
                    colSetArr[changeY].remove(k);
                    nineSetArr[nineX][nineY].remove(k);
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public void solveSudoku2(char[][] board) {
        Set<Integer>[][] setBoard = new Set[9][9];
        int unsolved = goConfirmed(board,setBoard);
        if (unsolved > 0) {
            trySolve(board,setBoard);
        }
    }

    public int goConfirmed(char[][] board, Set<Integer>[][] setBoard) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            set.add(i+1);
        }
        int unsolved = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    setBoard[i][j] = new HashSet<>(set);
                    unsolved++;
                }
            }
        }
        while (unsolved > 0) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.') {
                        int num = Integer.parseInt(board[i][j] + "");
                        for (int k = 0; k < 9; k++) {
                            Set<Integer> colSet = setBoard[i][k];
                            if (colSet != null && colSet.size() > 0) {
                                colSet.remove(num);
                            }
                            Set<Integer> rowSet = setBoard[k][j];
                            if (rowSet != null && rowSet.size() > 0) {
                                rowSet.remove(num);
                            }
                        }
                        int nineRowIndex = i / 3;
                        int nineColIndex = j / 3;
                        for (int k = nineRowIndex*3; k < nineRowIndex*3+3; k++) {
                            for (int l = nineColIndex*3; l < nineColIndex*3+3; l++) {
                                Set<Integer> nineSet = setBoard[k][l];
                                if (nineSet != null && nineSet.size() > 0) {
                                    nineSet.remove(num);
                                }
                            }
                        }
                    }
                }
            }
            boolean cut = false;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == '.') {
                        Set<Integer> currentSet = setBoard[i][j];
                        if (currentSet != null && currentSet.size() == 1) {
                            Integer k = new ArrayList<>(currentSet).get(0);
                            board[i][j] = (k+"").charAt(0);
                            unsolved--;
                            cut = true;
                        }
                    }
                }
            }
            boolean secondCut = false;
            if (!cut) {
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        Set<Integer> possible = setBoard[i][j];
                        if (possible != null && possible.size() > 1) {
                            int nineRowIndex = i / 3;
                            int nineColIndex = j / 3;
                            for (Integer p : possible) {
                                boolean unique = true;
                                for (int k = nineRowIndex*3; k < nineRowIndex*3+3; k++) {
                                    boolean goNext = true;
                                    for (int l = nineColIndex*3; l < nineColIndex*3+3; l++) {
                                        if (k == i && l == j) {
                                            continue;
                                        }
                                        Set<Integer> nineSet = setBoard[k][l];
                                        if (nineSet != null && nineSet.contains(p)) {
                                            unique = false;
                                            goNext = false;
                                            break;
                                        }
                                    }
                                    if (!goNext) {
                                        break;
                                    }
                                }
                                if (unique) {
                                    board[i][j] = (p+"").charAt(0);
                                    unsolved--;
                                    secondCut = true;
                                }
                            }
                        }
                    }
                }
            }
            if (!secondCut) {
                break;
            }
        }
        if (unsolved > 0) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == '.') {
                        Set<Integer> possibleSet = setBoard[i][j];
                        for (Integer p : possibleSet) {
                            board[i][j] = (p+"").charAt(0);
                            if (trySolve(board,setBoard)) {
                                break;
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }

    public boolean trySolve(char[][] board,Set<Integer>[][] setBoard) {
        Set<Integer>[][] setBoardCopy = new Set[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {

                }
                if (board[i][j] != '.') {
                    int num = Integer.parseInt(board[i][j] + "");
                    for (int k = 0; k < 9; k++) {
                        Set<Integer> colSet = setBoard[i][k];
                        if (colSet != null && colSet.size() > 0) {
                            colSet.remove(num);
                        }
                        Set<Integer> rowSet = setBoard[k][j];
                        if (rowSet != null && rowSet.size() > 0) {
                            rowSet.remove(num);
                        }
                    }
                    int nineRowIndex = i / 3;
                    int nineColIndex = j / 3;
                    for (int k = nineRowIndex*3; k < nineRowIndex*3+3; k++) {
                        for (int l = nineColIndex*3; l < nineColIndex*3+3; l++) {
                            Set<Integer> nineSet = setBoard[k][l];
                            if (nineSet != null && nineSet.size() > 0) {
                                nineSet.remove(num);
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SolveSudoku solveSudoku = new SolveSudoku();
        char[][] chars = {{'.','.','9','7','4','8','.','.','.'},{'7','.','.','.','.','.','.','.','.'},{'.','2','.','1','.','9','.','.','.'},{'.','.','7','.','.','.','2','4','.'},{'.','6','4','.','1','.','5','9','.'},{'.','9','8','.','.','.','3','.','.'},{'.','.','.','8','.','3','.','2','.'},{'.','.','.','.','.','.','.','.','6'},{'.','.','.','2','7','5','9','.','.'}};
        solveSudoku.solveSudoku(chars);
        System.out.println(Arrays.deepToString(chars));
    }
}
