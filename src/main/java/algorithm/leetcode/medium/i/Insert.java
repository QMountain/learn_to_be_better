package algorithm.leetcode.medium.i;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Insert {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            int[][] ans = new int[1][2];
            ans[0] = newInterval;
            return ans;
        }
        int[] interval1 = intervals[0];
        if (newInterval[0] < interval1[0]) {
            if (newInterval[1] < interval1[0]) {
                int length = intervals.length;
                int[][] ans = new int[length+1][2];
                ans[0] = newInterval;
                System.arraycopy(intervals, 0, ans, 1, length);
                return ans;
            }
            interval1[0] = newInterval[0];
            return insert(intervals, new int[]{interval1[0], newInterval[1]});
        }
        int leftIndex = binarySearch(intervals, newInterval[0]);
        int rightIndex = binarySearch(intervals, newInterval[1]);
        // 新区间与 索引为 leftIndex 的老区间 连上了
        boolean connectWithLeft = intervals[leftIndex][1] >= newInterval[0] && newInterval[0] >= intervals[leftIndex][0];
        boolean connectWithRight = intervals[rightIndex][1] >= newInterval[1];
        if (connectWithLeft) {
            int nl = leftIndex + 1 + (intervals.length - 1 - rightIndex);
            int[][] ans = new int[nl][2];
            System.arraycopy(intervals, 0, ans, 0, leftIndex);
            ans[leftIndex] = new int[]{intervals[leftIndex][0], Math.max(intervals[rightIndex][1], newInterval[1])};
            System.arraycopy(intervals, rightIndex+1, ans, leftIndex+1, (intervals.length - 1 - rightIndex));
            return ans;
        } else if (connectWithRight) {
            int nl = (leftIndex + 1) + 1 + (intervals.length - 1 - rightIndex);
            int[][] ans = new int[nl][2];
            System.arraycopy(intervals, 0, ans, 0, leftIndex+1);
            ans[leftIndex+1] = new int[]{newInterval[0], intervals[rightIndex][1]};
            System.arraycopy(intervals, rightIndex+1, ans, leftIndex+2, (intervals.length - 1 - rightIndex));
            return ans;
        } else {
            int nl = (leftIndex + 1) + 1 + (intervals.length - 1 - rightIndex);
            int[][] ans = new int[nl][2];
            System.arraycopy(intervals, 0, ans, 0, leftIndex+1);
            ans[leftIndex+1] = new int[]{newInterval[0], newInterval[1]};
            System.arraycopy(intervals, rightIndex+1, ans, leftIndex+2, (intervals.length - 1 - rightIndex));
            return ans;
        }
    }

    // 如果在某个区间内，返回那个区间的索引
    // 如果不在任何区间内，返回比目标小的最大索引
    public int binarySearch(int[][] intervals, int target) {
        int left = 0;
        int right = intervals.length-1;
        while (left < right) {
            int mid = (left + right) / 2;
            int[] interval = intervals[mid];
            if (interval[0] > target) {
                right = mid;
            } else if (interval[1] < target) {
                if (left == mid) {
                    break;
                }
                left = mid;
            } else {
                return mid;
            }
        }
        if (intervals[right][0] <= target) {
            return right;
        }
        return left;
    }

    public int[][] insert3(int[][] intervals, int[] newInterval) {
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
        System.out.println(Arrays.deepToString(insert.insert(new int[][]{{1,4},{10,12},{13,14},
                        {16,16},{19,20},{21,24},{33,33},{36,39},{44,46},{48,50}},
                new int[]{5, 13})));
        System.out.println(Arrays.deepToString(insert.insert(new int[][]{{1, 5}, {6, 8}},
                new int[]{5, 6})));
        System.out.println(Arrays.deepToString(insert.insert(new int[][]{{3,5},{12,15}},
                new int[]{6,6})).equals("[[3, 5], [6, 6], [12, 15]]"));
        System.out.println(Arrays.deepToString(insert.insert(new int[][]{{1,5}},
                new int[]{0,5})).equals("[[0, 5]]"));
        System.out.println(Arrays.deepToString(insert.insert(new int[][]{{1,5}},
                new int[]{1,7})).equals("[[1, 7]]"));
        System.out.println(Arrays.deepToString(insert.insert(new int[][]{{1,5}},
                new int[]{2,7})).equals("[[1, 7]]"));
        System.out.println(Arrays.deepToString(insert.insert(new int[][]{{1,5}},
                new int[]{2,3})).equals("[[1, 5]]"));
        System.out.println(Arrays.deepToString(insert.insert(new int[][]{},
                new int[]{5,7})).equals("[[5, 7]]"));
        System.out.println(Arrays.deepToString(insert.insert(new int[][]{{1,2},{3,5},
                {6,7},{8,10},{12,16}},
                new int[]{4,8})).equals("[[1, 2], [3, 10], [12, 16]]"));
        System.out.println(Arrays.deepToString(insert.insert(new int[][]{{1,3},{6,9}},
                new int[]{2,5})).equals("[[1, 5], [6, 9]]"));
    }
}
