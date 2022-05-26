package algorithm.leetcode.medium.f;

import java.util.*;

public class FindRightInterval {

    public int[] findRightInterval(int[][] intervals) {
        int length = intervals.length;
        int[] res = new int[length];
        if (length == 1) {
            res[0] = -1;
            return res;
        }
        Map<Integer,Integer> startIndexMap = new HashMap<>();
        // 1,start  2,end  3 both
        Map<Integer,Integer> map = new TreeMap<>();
        for (int i = 0; i < length; i++) {
            int[] interval = intervals[i];
            int start = interval[0];
            int end = interval[1];
            Integer sm = map.getOrDefault(start, 0);
            if (sm == 0) {
                map.put(start,1);
            } else if (sm == 2) {
                map.put(start,3);
            }
            Integer em = map.getOrDefault(end, 0);
            if (em == 0) {
                map.put(end,2);
            } else if (em == 1) {
                map.put(end,3);
            }

            startIndexMap.put(start,i);
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        int size = list.size();
        for (int i = 0; i < length; i++) {
            int[] interval = intervals[i];
            int end = interval[1];
            int index = list.indexOf(end);
            boolean find = false;
            while (index < size-1) {
                Integer nextValue = list.get(index++);
                Integer se = map.get(nextValue);
                if (se == 1 || se == 3) {
                    find = true;
                    res[i] = startIndexMap.get(nextValue);
                    break;
                }
            }
            if (!find) {
                res[i] = -1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        FindRightInterval findRightInterval = new FindRightInterval();
        System.out.println(Arrays.toString(findRightInterval.findRightInterval(new int[][]{{1,4},{2,3},{3,4}})));
        System.out.println(Arrays.toString(findRightInterval.findRightInterval(new int[][]{{3,4},{2,3},{1,2}})));
    }
}
