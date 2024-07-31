package algorithm.leetcode.medium.m;

import java.util.TreeSet;

public class MinRectanglesToCoverPoints {

    // 1 <= points.length <= 10^5
    // points[i].length == 2
    // 0 <= xi == points[i][0] <= 10^9
    // 0 <= yi == points[i][1] <= 10^9
    // 0 <= w <= 10^9
    // 所有点坐标 (xi, yi) 互不相同
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int[] point : points) {
            set.add(point[0]);
        }
        int ans = 1;
        int start = set.pollFirst();
        while (!set.isEmpty()) {
            Integer polled = set.pollFirst();
            if (polled - start > w) {
                ans++;
                start = polled;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MinRectanglesToCoverPoints minRectanglesToCoverPoints = new MinRectanglesToCoverPoints();
        System.out.println(2 == minRectanglesToCoverPoints.minRectanglesToCoverPoints(
                new int[][]{{2,3},{1,2}}, 0));
        System.out.println(3 == minRectanglesToCoverPoints.minRectanglesToCoverPoints(
                new int[][]{{0,0},{1,1},{2,2},{3,3},{4,4},{5,5},{6,6}}, 2));
        System.out.println(2 == minRectanglesToCoverPoints.minRectanglesToCoverPoints(
                new int[][]{{2,1},{1,0},{1,4},{1,8},{3,5},{4,6}}, 1));
    }
}
