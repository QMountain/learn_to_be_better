package algorithm.leetcode.medium.c;

import java.util.*;

public class CountPaths {

    // 1 <= n <= 200
    public int countPaths(int n, int[][] roads) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] road : roads) {
            List<int[]> list = map.getOrDefault(road[0], new ArrayList<>());
            list.add(new int[]{road[1], road[2]});
            map.put(road[0], list);

            List<int[]> list2 = map.getOrDefault(road[1], new ArrayList<>());
            list2.add(new int[]{road[0], road[2]});
            map.put(road[1], list2);
        }
        Map<Integer, Integer> minMap = new HashMap<>();
        minMap.put(0, 0);
        List<int[]> nodes = Collections.singletonList(new int[]{0, 0});
        int min = Integer.MAX_VALUE;
        int ans = 1;
        while (!nodes.isEmpty()) {
            List<int[]> next = new ArrayList<>();
            for (int[] node : nodes) {
                List<int[]> list = map.get(node[0]);
                for (int[] ints : list) {
                    int weight = node[1] + ints[1];
                    if (!minMap.containsKey(ints[0]) || weight <= minMap.get(ints[0])) {
                        minMap.put(ints[0], weight);
                        if (ints[0] == n-1) {
                            if (weight < min) {
                                min = weight;
                                ans = 1;
                            } else if (weight == min) {
                                ans++;
                            }
                        } else {
                            next.add(new int[]{ints[0], weight});
                        }
                    }
                }
            }
            nodes = next;
        }
        return ans;
    }

    public static void main(String[] args) {
        CountPaths countPaths = new CountPaths();
        System.out.println(countPaths.countPaths(7,
                new int[][]{{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}}));
    }
}
