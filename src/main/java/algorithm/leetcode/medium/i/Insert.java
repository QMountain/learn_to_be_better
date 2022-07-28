package algorithm.leetcode.medium.i;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Insert {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        List<int[]> ansList = new ArrayList<int[]>();
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                // 在插入区间的右侧且无交集
                if (!placed) {
                    ansList.add(new int[]{left, right});
                    placed = true;
                }
                ansList.add(interval);
            } else if (interval[1] < left) {
                // 在插入区间的左侧且无交集
                ansList.add(interval);
            } else {
                // 与插入区间有交集，计算它们的并集
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!placed) {
            ansList.add(new int[]{left, right});
        }
        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); ++i) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }

    public int[][] insert2(int[][] intervals, int[] newInterval) {
        int length = intervals.length;
        if (length == 0) {
            int[][] ans = new int[length+1][2];
            ans[0] = newInterval;
            return ans;
        }

        for (int[] interval : intervals) {
            int left = interval[0];
            int right = interval[1];
            int nl = newInterval[0];
            int nr = newInterval[1];
            if (left <= nl && nr <= right) {
                return intervals;
            }
            if (right > nl && right < nr && left <= nl) {
                newInterval[0] = right;
                continue;
            }
            if (nl < left && right < nr) {
                int[] arr = new int[2];
                arr[0] = nl;
                arr[1] = left;
                intervals = insertWithoutTouch(intervals,arr);
                int[] arr2 = new int[2];
                arr2[0] = right;
                arr2[1] = nr;
                return insert(intervals,arr2);
            }
            if (nl < left && left < nr) {
                newInterval[1] = left;
                return insert(intervals,newInterval);
            }
        }
        return insertWithoutTouch(intervals,newInterval);
    }

    public int[][] insertWithoutTouch(int[][] intervals, int[] newInterval) {
        int length = intervals.length;
        int min = intervals[0][0];
        if (newInterval[1] < min) {
            int[][] ans = new int[length+1][2];
            ans[0] = newInterval;
            System.arraycopy(intervals,0,ans,1,length);
            return ans;
        }
        if (newInterval[1] == min) {
            intervals[0][0] = newInterval[0];
            return intervals;
        }
        int max = intervals[length-1][1];
        if (max < newInterval[0]) {
            int[][] ans = new int[length+1][2];
            System.arraycopy(intervals,0,ans,0,length);
            ans[length] = newInterval;
            return ans;
        }
        if (max == newInterval[0]) {
            intervals[length-1][1] = newInterval[1];
            return intervals;
        }
        for (int i = 0; i < length - 1; i++) {
            if (intervals[i][1] < newInterval[0] && newInterval[1] < intervals[i+1][0]) {
                int[][] ans = new int[length+1][2];
                System.arraycopy(intervals,0,ans,0,i+1);
                ans[i+1] = newInterval;
                System.arraycopy(intervals,i+1,ans,i+2,length-i-1);
                return ans;
            }
            if (intervals[i][1] < newInterval[0] && newInterval[1] == intervals[i+1][0]) {
                intervals[i+1][0] = newInterval[0];
                return intervals;
            }
            if (intervals[i][1] == newInterval[0] && newInterval[1] < intervals[i+1][0]) {
                intervals[i][1] = newInterval[1];
                return intervals;
            }
            if (intervals[i][1] == newInterval[0] && newInterval[1] == intervals[i+1][0]) {
                int[][] ans = new int[length-1][2];
                System.arraycopy(intervals,0,ans,0,i);
                newInterval[0] = intervals[i][0];
                newInterval[1] = intervals[i+1][1];
                ans[i] = newInterval;
                System.arraycopy(intervals,i+2,ans,i+1,length-i-2);
                return ans;
            }
        }

        return intervals;
    }

    public static void main(String[] args) {
        Insert insert = new Insert();
        System.out.println(Arrays.deepToString(insert.insert(new int[][]{{3,5},{12,15}}, new int[]{6,6})));
        System.out.println(Arrays.deepToString(insert.insert(new int[][]{{1,5}}, new int[]{0,5})));
        System.out.println(Arrays.deepToString(insert.insert(new int[][]{{1,5}}, new int[]{1,7})));
        System.out.println(Arrays.deepToString(insert.insert(new int[][]{{1,5}}, new int[]{2,7})));
        System.out.println(Arrays.deepToString(insert.insert(new int[][]{{1,5}}, new int[]{2,3})));
        System.out.println(Arrays.deepToString(insert.insert(new int[][]{}, new int[]{5,7})));
        System.out.println(Arrays.deepToString(insert.insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4,8})));
        System.out.println(Arrays.deepToString(insert.insert(new int[][]{{1,3},{6,9}}, new int[]{2,5})));
    }
}
