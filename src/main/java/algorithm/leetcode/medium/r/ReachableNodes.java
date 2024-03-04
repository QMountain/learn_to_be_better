package algorithm.leetcode.medium.r;

import java.util.*;

public class ReachableNodes {

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            Set<Integer> set = map.getOrDefault(edge[0], new HashSet<>());
            set.add(edge[1]);
            map.put(edge[0], set);

            Set<Integer> set2 = map.getOrDefault(edge[1], new HashSet<>());
            set2.add(edge[0]);
            map.put(edge[1], set2);
        }
        Set<Integer> restrictedSet = new HashSet<>();
        for (int i : restricted) {
            restrictedSet.add(i);
        }
        int ans = 1;
        List<Integer> nodes = Collections.singletonList(0);
        while (!nodes.isEmpty()) {
            List<Integer> next = new ArrayList<>();
            for (Integer node : nodes) {
                Set<Integer> set = map.get(node);
                if (set == null) {
                    continue;
                }
                for (Integer i : set) {
                    if (!restrictedSet.contains(i)) {
                        ans++;
                        next.add(i);
                    }
                }
                restrictedSet.add(node);
            }
            nodes = next;
        }
        return ans;
    }

    public static void main(String[] args) {
        ReachableNodes reachableNodes = new ReachableNodes();
        System.out.println(reachableNodes.reachableNodes(7,
                new int[][]{{0,1},{1,2},{3,1},{4,0},{0,5},{5,6}},
                new int[]{4,5}));
    }
}
