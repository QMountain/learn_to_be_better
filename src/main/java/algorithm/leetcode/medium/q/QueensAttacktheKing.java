package algorithm.leetcode.medium.q;

import java.util.ArrayList;
import java.util.List;

public class QueensAttacktheKing {

    // 1 <= queens.length <= 63
    // queens[i].length == 2
    // 0 <= queens[i][j] < 8
    // king.length == 2
    // 0 <= king[0], king[1] < 8
    // 一个棋盘格上最多只能放置一枚棋子
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        // 0 左下 3 正上 5 右下 6 正右 7 右上
        Integer[] arr = new Integer[8];
        int[][] canAttack = new int[8][2];
        for (int[] queen : queens) {
            if (queen[0] == king[0]) {
                // 正上
                if (queen[1] > king[1]) {
                    if (arr[3] == null || queen[1] < arr[3]) {
                        arr[3] = queen[1];
                        canAttack[3] = queen;
                    }
                }
                // 正下
                else {
                    if (arr[1] == null || queen[1] > arr[1]) {
                        arr[1] = queen[1];
                        canAttack[1] = queen;
                    }
                }
            } else if (queen[1] == king[1]) {
                // 正左
                if (queen[0] < king[0]) {
                    if (arr[2] == null || queen[0] > arr[2]) {
                        arr[2] = queen[0];
                        canAttack[2] = queen;
                    }
                }
                // 正右
                else {
                    if (arr[6] == null || queen[0] < arr[6]) {
                        arr[6] = queen[0];
                        canAttack[6] = queen;
                    }
                }
            }
            // 左上
            else if (king[0] > queen[0] && king[0] - queen[0] == queen[1] - king[1]) {
                if (arr[4] == null || queen[0] > arr[4]) {
                    arr[4] = queen[0];
                    canAttack[4] = queen;
                }
            }
            // 左下
            else if (king[0] > queen[0] && king[0] - queen[0] == king[1] - queen[1]) {
                if (arr[0] == null || queen[0] > arr[0]) {
                    arr[0] = queen[0];
                    canAttack[0] = queen;
                }
            }
            // 右上
            else if (queen[0] > king[0] && queen[0] - king[0] == queen[1] - king[1]) {
                if (arr[7] == null || queen[0] < arr[7]) {
                    arr[7] = queen[0];
                    canAttack[7] = queen;
                }
            }
            // 右下
            else if (queen[0] > king[0] && queen[0] - king[0] == king[1] - queen[1]) {
                if (arr[5] == null || queen[0] < arr[5]) {
                    arr[5] = queen[0];
                    canAttack[5] = queen;
                }
            }
        }
        List<List<Integer>> ansList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            if (arr[i] != null) {
                ArrayList<Integer> list = new ArrayList<>(2);
                list.add(canAttack[i][0]);
                list.add(canAttack[i][1]);
                ansList.add(list);
            }
        }
        return ansList;
    }

    public static void main(String[] args) {
        QueensAttacktheKing queensAttacktheKing = new QueensAttacktheKing();
        System.out.println(queensAttacktheKing.queensAttacktheKing(
                new int[][]{{5,6},{7,7},{2,1},{0,7},{1,6},{5,1},{3,7},{0,3},{4,0},{1,2},{6,3},{5,0},{0,4},{2,2},{1,1},{6,4},{5,4},{0,0},{2,6},{4,5},{5,2},{1,4},{7,5},{2,3},{0,5},{4,2},{1,0},{2,7},{0,1},{4,6},{6,1},{0,6},{4,3},{1,7}},
                new int[]{3, 4}));
        System.out.println(queensAttacktheKing.queensAttacktheKing(
                new int[][]{{0, 0}, {1, 1}, {2, 2}, {3, 4}, {3, 5}, {4, 4}, {4, 5}},
                new int[]{3, 3}));
    }
}
