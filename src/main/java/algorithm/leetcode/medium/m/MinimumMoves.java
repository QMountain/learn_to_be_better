package algorithm.leetcode.medium.m;

public class MinimumMoves {

    public int minimumMoves(int[][] grid) {
        int ans = 0;
        for (int step = 1; step <= 4; step++) {
            boolean find = false;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (grid[i][j] == 0) {
                        find = true;
                        boolean done = false;
                        for (int l = 0; l < 3; l++) {
                            for (int m = 0; m < 3; m++) {
                                if (grid[l][m] > 1 &&
                                        Math.abs(i - l) + Math.abs(j - m) == step) {
                                    grid[i][j] = 1;
                                    grid[l][m]--;
                                    ans += step;
                                    done = true;
                                    break;
                                }
                            }
                            if (done) {
                                break;
                            }
                        }
                    }
                }
            }
            if (!find) {
                return ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MinimumMoves minimumMoves = new MinimumMoves();
        System.out.println(6 == minimumMoves.minimumMoves(
                new int[][]{{0,2,3},{2,0,1},{0,1,0}}));
        System.out.println(7 == minimumMoves.minimumMoves(
                new int[][]{{3,2,0},{0,1,0},{0,3,0}}));
    }
}
