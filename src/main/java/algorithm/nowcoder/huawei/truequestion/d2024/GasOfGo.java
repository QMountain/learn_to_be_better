package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.Arrays;
import java.util.Scanner;

// 围棋的气
public class GasOfGo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] black = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] white = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 定义棋盘，没有棋子用0表示
        int[][] board = new int[19][19];

        for (int i = 0; i < black.length; i += 2) {
            int x = black[i];
            int y = black[i + 1];
            board[x][y] = 1; // 棋盘中黑棋用1表示
        }

        for (int i = 0; i < white.length; i += 2) {
            int x = white[i];
            int y = white[i + 1];
            board[x][y] = 2; // 棋盘中白棋用2表示
        }

        // 黑棋的气数
        int black_liberty_count = 0;
        // 白棋的气数
        int white_liberty_count = 0;

        // 上下左右四个方向的偏移量
        int[][] offsets = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                // 如果当前位置没有棋子，则可能是黑棋或白棋的气
                if (board[i][j] == 0) {
                    // 当前位置是否为黑棋的气
                    boolean isBlackLiberty = false;
                    // 当前位置是否白棋的气
                    boolean isWhiteLiberty = false;

                    // 若为黑棋或者白棋的气，则当前位置的上下左右的位置上必有黑棋或白棋
                    for (int[] offset : offsets) {
                        int newI = i + offset[0];
                        int newJ = j + offset[1];

                        // 若当前位置的上下左右的位置越界，则不考虑
                        if (newI < 0 || newI >= 19 || newJ < 0 || newJ >= 19) continue;

                        // 若当前位置的上下左右的位置存在黑棋，则当前位置为黑棋的气
                        isBlackLiberty = isBlackLiberty || (board[newI][newJ] == 1);
                        // 若当前位置的上下左右的位置存在白棋，则当前位置为白棋的气
                        isWhiteLiberty = isWhiteLiberty || (board[newI][newJ] == 2);
                    }

                    if (isBlackLiberty) black_liberty_count++;
                    if (isWhiteLiberty) white_liberty_count++;
                }
            }
        }

        System.out.println(black_liberty_count + " " + white_liberty_count);
    }
}
