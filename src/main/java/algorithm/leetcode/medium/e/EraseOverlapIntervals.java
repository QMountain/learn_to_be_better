package algorithm.leetcode.medium.e;

import java.util.Arrays;
import java.util.Comparator;

public class EraseOverlapIntervals {

    // 1 <= intervals.length <= 10的5次方
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int length = intervals.length;
        int ans = 0;
        int leftIndex = 0;
        int rightIndex= 1;
        while (rightIndex < length) {
            int[] left = intervals[leftIndex];
            int[] right = intervals[rightIndex];
            if (left[0] == right[0]) {
                ans++;
                if (left[1] > right[1]) {
                    leftIndex = rightIndex;
                }
            } else {
                // left[0] < right[0]
                if (right[0] < left[1]) {
                    ans++;
                    if (left[1] >= right[1]) {
                        leftIndex = rightIndex;
                    }
                } else {
                    leftIndex = rightIndex;
                }
            }
            rightIndex++;
        }
        return ans;
    }

    public static void main(String[] args) {
        EraseOverlapIntervals eraseOverlapIntervals = new EraseOverlapIntervals();
        System.out.println(0 == eraseOverlapIntervals.eraseOverlapIntervals(new int[][]{ {1,2}, {2,3} }));
        System.out.println(2 == eraseOverlapIntervals.eraseOverlapIntervals(new int[][]{ {1,2}, {1,2}, {1,2} }));
        System.out.println(1 == eraseOverlapIntervals.eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{1,3}}));
    }
}
