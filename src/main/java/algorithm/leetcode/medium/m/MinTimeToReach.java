package algorithm.leetcode.medium.m;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinTimeToReach {

    /**
     *
     * 2 <= n == moveTime.length <= 50
     * 2 <= m == moveTime[i].length <= 50
     * 0 <= moveTime[i][j] <= 10^9
     */
    public int minTimeToReach(int[][] moveTime) {
        int rows = moveTime.length;
        int cols = moveTime[0].length;
        int[][] searched = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(searched[i], -1);
        }
        searched[0][0] = 0;

        Set<Integer> set = new HashSet<>();
        set.add(0);
        while (!set.isEmpty()) {
            Set<Integer> next = new HashSet<>();
            for (Integer i : set) {
                int row = i / 100;
                int col = i % 100;
                // up
                if (row > 0) {
                    int max = Math.max(searched[row][col], moveTime[row - 1][col]);
                    if (searched[row-1][col] == -1
                            || max + 1 < searched[row-1][col]) {
                        searched[row-1][col] = max + 1;
                        next.add((row-1) * 100 + col);
                    }
                }
                // down
                if (row < rows - 1) {
                    int max = Math.max(searched[row][col], moveTime[row + 1][col]);
                    if (searched[row+1][col] == -1 || max + 1 < searched[row+1][col]) {
                        searched[row+1][col] = max + 1;
                        next.add((row+1) * 100 + col);
                    }
                }
                // left
                if (col > 0) {
                    int max = Math.max(searched[row][col], moveTime[row][col - 1]);
                    if (searched[row][col-1] == -1
                            || max + 1 < searched[row][col-1]) {
                        searched[row][col-1] = max + 1;
                        next.add(row * 100 + col - 1);
                    }
                }
                // right
                if (col < cols - 1) {
                    int max = Math.max(searched[row][col], moveTime[row][col + 1]);
                    if (searched[row][col+1] == -1
                            || max + 1 < searched[row][col+1]) {
                        searched[row][col+1] = max + 1;
                        next.add(row * 100 + col + 1);
                    }
                }
            }
            set = next;
        }
        return searched[rows-1][cols-1];
    }

    public static void main(String[] args) {
        MinTimeToReach minTimeToReach = new MinTimeToReach();
        System.out.println(3 == minTimeToReach.minTimeToReach(new int[][]{{0,1},{1,2}}));
        System.out.println(3 == minTimeToReach.minTimeToReach(new int[][]{{0,0,0},{0,0,0}}));
        System.out.println(6 == minTimeToReach.minTimeToReach(new int[][]{{0,4},{4,4}}));
    }
}
