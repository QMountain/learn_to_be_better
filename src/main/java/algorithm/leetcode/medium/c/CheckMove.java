package algorithm.leetcode.medium.c;

public class CheckMove {

    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        // up
        int countDiff = 0;
        boolean findSame = false;
        for (int i = rMove - 1; i >= 0; i--) {
            if (board[i][cMove] == '.') {
                break;
            }
            if (board[i][cMove] != color) {
                countDiff++;
            } else {
                findSame = true;
                break;
            }
        }
        if (countDiff > 0 && findSame) {
            return true;
        }
        // down
        countDiff = 0;
        findSame = false;
        for (int i = rMove + 1; i < board.length; i++) {
            if (board[i][cMove] == '.') {
                break;
            }
            if (board[i][cMove] != color) {
                countDiff++;
            } else {
                findSame = true;
                break;
            }
        }
        if (countDiff > 0 && findSame) {
            return true;
        }
        // left
        countDiff = 0;
        findSame = false;
        for (int i = cMove - 1; i >= 0; i--) {
            if (board[rMove][i] == '.') {
                break;
            }
            if (board[rMove][i] != color) {
                countDiff++;
            } else {
                findSame = true;
                break;
            }
        }
        if (countDiff > 0 && findSame) {
            return true;
        }
        // right
        countDiff = 0;
        findSame = false;
        for (int i = cMove + 1; i < 8; i++) {
            if (board[rMove][i] == '.') {
                break;
            }
            if (board[rMove][i] != color) {
                countDiff++;
            } else {
                findSame = true;
                break;
            }
        }
        if (countDiff > 0 && findSame) {
            return true;
        }
        // left up
        countDiff = 0;
        findSame = false;
        int min = Math.min(rMove, cMove);
        for (int i = 1; i <= min; i++) {
            if (board[rMove-i][cMove-i] == '.') {
                break;
            }
            if (board[rMove-i][cMove-i] != color) {
                countDiff++;
            } else {
                findSame = true;
                break;
            }
        }
        if (countDiff > 0 && findSame) {
            return true;
        }
        // right down
        countDiff = 0;
        findSame = false;
        min = Math.min(7 - rMove, 7 - cMove);
        for (int i = 1; i <= min; i++) {
            if (board[rMove+i][cMove+i] == '.') {
                break;
            }
            if (board[rMove+i][cMove+i] != color) {
                countDiff++;
            } else {
                findSame = true;
                break;
            }
        }
        if (countDiff > 0 && findSame) {
            return true;
        }
        // right up
        countDiff = 0;
        findSame = false;
        min = Math.min(rMove, 7 - cMove);
        for (int i = 1; i <= min; i++) {
            if (board[rMove-i][cMove+i] == '.') {
                break;
            }
            if (board[rMove-i][cMove+i] != color) {
                countDiff++;
            } else {
                findSame = true;
                break;
            }
        }
        if (countDiff > 0 && findSame) {
            return true;
        }
        // left down
        countDiff = 0;
        findSame = false;
        min = Math.min(7 - rMove, cMove);
        for (int i = 1; i <= min; i++) {
            if (board[rMove+i][cMove-i] == '.') {
                break;
            }
            if (board[rMove+i][cMove-i] != color) {
                countDiff++;
            } else {
                findSame = true;
                break;
            }
        }
        return countDiff > 0 && findSame;
    }

    public static void main(String[] args) {
        CheckMove checkMove = new CheckMove();
        System.out.println(!checkMove.checkMove(new char[][]{{'.','.','.','.','.','.','.','.'},{'.','B','.','.','W','.','.','.'},{'.','.','W','.','.','.','.','.'},{'.','.','.','W','B','.','.','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','.','B','W','.','.'},{'.','.','.','.','.','.','W','.'},{'.','.','.','.','.','.','.','B'}},
                4, 4, 'W'));
        System.out.println(checkMove.checkMove(new char[][]{{'.','.','.','B','.','.','.','.'},{'.','.','.','W','.','.','.','.'},{'.','.','.','W','.','.','.','.'},{'.','.','.','W','.','.','.','.'},{'W','B','B','.','W','W','W','B'},{'.','.','.','B','.','.','.','.'},{'.','.','.','B','.','.','.','.'},{'.','.','.','W','.','.','.','.'}},
                4, 3, 'B'));
    }
}
