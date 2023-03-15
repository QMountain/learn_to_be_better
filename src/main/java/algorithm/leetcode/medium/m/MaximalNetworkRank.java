package algorithm.leetcode.medium.m;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public class MaximalNetworkRank {

    public int maximalNetworkRank(int n, int[][] roads) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int[] road : roads) {
            HashSet<Integer> set = map.get(road[0]);
            if (set == null) {
                set = new HashSet<>();
            }
            set.add(road[1]);
            map.put(road[0],set);
            HashSet<Integer> set1 = map.get(road[1]);
            if (set1 == null) {
                set1 = new HashSet<>();
            }
            set1.add(road[0]);
            map.put(road[1],set1);
        }
        int[][] sort = new int[n][2];
        for (int i = 0; i < n; i++) {
            sort[i][0] = i;
            sort[i][1] = map.getOrDefault(i,new HashSet<>()).size();
        }
        Arrays.sort(sort, Comparator.comparingInt(a -> a[1]));
        int lastCount1 = sort[n - 1][1];
        int lastCount2 = sort[n - 2][1];
        HashSet<Integer> lastSet1 = map.getOrDefault(sort[n - 1][0],new HashSet<>());
        if (!lastSet1.contains(sort[n-2][0])) {
            return lastCount1 + lastCount2;
        }
        int max = lastCount1 + lastCount2 - 1;
        int firstIndex = n-1;
        for (int i = n-3; i >= 0; i--) {
            if (sort[i][1] < lastCount2) {
                firstIndex = i+1;
                break;
            }
        }
        for (int i = firstIndex; i < n-2; i++) {
            if (!lastSet1.contains(sort[i][0])) {
                return lastCount1 + lastCount2;
            }
        }
        for (int i = firstIndex; i < n-1; i++) {
            HashSet<Integer> lastSet = map.getOrDefault(sort[i][0],new HashSet<>());
            for (int j = i+1; j < n-1; j++) {
                if (!lastSet.contains(sort[j][0])) {
                    int count2 = map.getOrDefault(sort[j][0], new HashSet<>()).size();
                    max = Math.max(max, lastSet.size() + count2);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaximalNetworkRank maximalNetworkRank = new MaximalNetworkRank();
        System.out.println(5 == maximalNetworkRank.maximalNetworkRank(8, new int[][]{{4,6},{5,2},{3,5},{7,5},{7,6}}));
        System.out.println(maximalNetworkRank.maximalNetworkRank(2, new int[][]{}));
        System.out.println(5 == maximalNetworkRank.maximalNetworkRank(5, new int[][]{{0,1},{0,3},{1,2},{1,3},{2,3},{2,4}}));
        System.out.println(4 == maximalNetworkRank.maximalNetworkRank(4, new int[][]{{0,1},{0,3},{1,2},{1,3}}));
    }
}
