package algorithm.leetcode.easy.m;

import java.util.HashMap;
import java.util.TreeSet;

public class MaxWidthOfVerticalArea {

    // n == points.length
    // 2 <= n <= 10^5
    // points[i].length == 2
    // 0 <= xi, yi <= 10^9
    public int maxWidthOfVerticalArea(int[][] points) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int[] point : points) {
            set.add(point[0]);
        }
        if (set.size() == 1) {
            return 0;
        }
        int max = -set.pollFirst() + set.first();
        int last = set.first();
        while (!set.isEmpty()) {
            Integer poll = set.pollFirst();
            max = Math.max(max, poll - last);
            last = poll;
        }
        return max;
    }

}
