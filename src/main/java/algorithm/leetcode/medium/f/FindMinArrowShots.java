package algorithm.leetcode.medium.f;

import java.util.*;

public class FindMinArrowShots {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int ans = 1;
        int length = points.length;
        int lastStart = points[0][0];
        int lastEnd = points[0][1];
        for (int i = 1; i < length; i++) {
            int[] point = points[i];
            int start = point[0];
            int end = point[1];
            if (start > lastEnd) {
                ans++;
                lastStart = start;
                lastEnd = end;
            } else if (end <= lastEnd) {
                lastStart = start;
                lastEnd = end;
            } else {
                lastStart = start;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindMinArrowShots findMinArrowShots = new FindMinArrowShots();
        System.out.println(2 == findMinArrowShots.findMinArrowShots(new int[][]{{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}}));
        System.out.println(2 == findMinArrowShots.findMinArrowShots(new int[][]{{1,2},{2,3},{3,4},{4,5}}));
        System.out.println(4 == findMinArrowShots.findMinArrowShots(new int[][]{{1,2},{3,4},{5,6},{7,8}}));
        System.out.println(2 == findMinArrowShots.findMinArrowShots(new int[][]{{10,16},{2,8},{1,6},{7,12}}));
    }
}
