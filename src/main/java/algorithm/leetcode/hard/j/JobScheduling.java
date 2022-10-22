package algorithm.leetcode.hard.j;

import java.util.*;

public class JobScheduling {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        TreeMap<Integer, List<Integer>> endMap = new TreeMap<>();
        int length = startTime.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            set.add(startTime[i]);
            set.add(endTime[i]);
            int end = endTime[i];
            List<Integer> nl;
            List<Integer> ol = endMap.get(end);
            if (ol != null) {
                nl = new LinkedList<>(ol);
            } else {
                nl = new LinkedList<>();
            }
            nl.add(i);
            endMap.put(end,nl);
        }
        ArrayList<Integer> timeList = new ArrayList<>(set);
        Collections.sort(timeList);
        int size = timeList.size();
        Map<Integer,Integer> timeIndexMap = new HashMap<>(size);
        for (int i = 0; i < size; i++) {
            timeIndexMap.put(timeList.get(i),i);
        }
        int[] dp = new int[size];
        for (int i = 1; i < size; i++) {
            Integer time = timeList.get(i);
            List<Integer> indexList = endMap.get(time);
            if (indexList == null || indexList.isEmpty()) {
                dp[i] = dp[i-1];
                continue;
            }
            for (Integer index : indexList) {
                int start = startTime[index];
                Integer timeIndex = timeIndexMap.get(start);
                dp[i] = Math.max(dp[i],dp[timeIndex] + profit[index]);
            }
            dp[i] = Math.max(dp[i-1],dp[i]);
        }
        return dp[size-1];
    }

    public static void main(String[] args) {
        JobScheduling jobScheduling = new JobScheduling();
        System.out.println(6 == jobScheduling.jobScheduling(new int[]{1, 1, 1}, new int[]{2, 3, 4}, new int[]{5,6,4}));
        System.out.println(150 == jobScheduling.jobScheduling(new int[]{1, 2, 3, 4,6}, new int[]{3, 5, 10, 6, 9}, new int[]{20, 20, 100, 70,60}));
        System.out.println(120 == jobScheduling.jobScheduling(new int[]{1, 2, 3, 3}, new int[]{3, 4, 5, 6}, new int[]{50, 10, 40, 70}));
    }
}
