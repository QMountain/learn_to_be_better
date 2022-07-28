package algorithm.leetcode.easy.c;

public class CountGoodRectangles {

    public int countGoodRectangles(int[][] rectangles) {
        int maxLen = 0;
        int count = 0;
        for (int[] rectangle : rectangles) {
            int max = Math.min(rectangle[0], rectangle[1]);
            if (max > maxLen) {
                maxLen = max;
                count = 1;
            } else if (max == maxLen) {
                count++;
            }
        }
        return count;
    }

}
