package algorithm.leetcode.medium.b;

import java.util.Arrays;

public class BestCoordinate {

    public int[] bestCoordinate(int[][] towers, int radius) {
        int[] ans = new int[2];
        int max = 0;
        for (int i = 0; i <= 50; i++) {
            for (int j = 0; j <= 50; j++) {
                int strength = 0;
                for (int[] tower : towers) {
                    strength += cal(tower,radius,i,j);
                }
                if (strength > max) {
                    max = strength;
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        return ans;
    }

    public int cal(int[] tower, int radius, int x, int y) {
        int absX = Math.abs(tower[0] - x);
        int absY = Math.abs(tower[1] - y);
        double distance = Math.sqrt(absX*absX + (absY*absY));
        if (distance > radius) {
            return 0;
        }
        return (int)(tower[2] / (distance + 1));
    }

    public static void main(String[] args) {
        BestCoordinate bestCoordinate = new BestCoordinate();
        System.out.println(Arrays.toString(bestCoordinate.bestCoordinate(new int[][]{{1,2,13},{2,1,7},{0,1,9}}, 2)));
        System.out.println(Arrays.toString(bestCoordinate.bestCoordinate(new int[][]{{23,11,21}}, 9)));
        System.out.println(Arrays.toString(bestCoordinate.bestCoordinate(new int[][]{{1,2,5},{2,1,7},{3,1,9}}, 2)));
    }
}
