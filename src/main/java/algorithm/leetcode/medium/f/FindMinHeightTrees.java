package algorithm.leetcode.medium.f;

import java.util.*;

public class FindMinHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            List<Integer> list1 = map.getOrDefault(edge[0], new ArrayList<>());
            list1.add(edge[1]);
            map.put(edge[0], list1);

            List<Integer> list2 = map.getOrDefault(edge[1], new ArrayList<>());
            list2.add(edge[0]);
            map.put(edge[1], list2);
        }
        int testRoot = 0;
        for (int i = 0; i < n; i++) {
            if (map.get(i).size() > 1) {
                testRoot = i;
                break;
            }
        }
        int minDepth = n;
        int maxDepth = 0;
        Set<Integer> usedSet = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        set.add(testRoot);
        while (!set.isEmpty()) {
            Set<Integer> nextSet = new HashSet<>();
            for (Integer node : set) {
                //map.get(node)
            }
        }
        return null;
    }

    public List<Integer> findMinHeightTrees2(int n, int[][] edges) {
        if (edges.length == 0) {
            return Collections.singletonList(0);
        }
        int[] arr = new int[n];
        List<int[]> list = new ArrayList<>();
        for (int[] edge : edges) {
            list.add(edge);
            arr[edge[0]]++;
            arr[edge[1]]++;
        }
        while (true) {
            List<int[]> nl = new ArrayList<>();
            int[] minus = new int[n];
            for (int[] ints : list) {
                if (arr[ints[0]] == 1 || arr[ints[1]] == 1) {
                    minus[ints[0]]++;
                    minus[ints[1]]++;
                } else {
                    nl.add(ints);
                }
            }
            for (int i = 0; i < n; i++) {
                arr[i] -= minus[i];
            }
            if (nl.isEmpty()) {
                Map<Integer,Integer> map = new HashMap<>();
                int max = 0;
                for (int[] ints : list) {
                    int k1NewValue = map.getOrDefault(ints[0], 0) + 1;
                    map.put(ints[0], k1NewValue);
                    max = Math.max(max,k1NewValue);
                    int k2NewValue = map.getOrDefault(ints[1], 0) + 1;
                    map.put(ints[1], k2NewValue);
                    max = Math.max(max,k2NewValue);
                }
                List<Integer> ans = new ArrayList<>();
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    if (entry.getValue() == max) {
                        ans.add(entry.getKey());
                    }
                }
                return ans;
            }
            list = nl;
        }
    }

    public static void main(String[] args) {
        FindMinHeightTrees findMinHeightTrees = new FindMinHeightTrees();
        System.out.println(findMinHeightTrees.findMinHeightTrees(6, new int[][]{{0,1},{0,2},{0,3},{3,4},{4,5}}));
        System.out.println(findMinHeightTrees.findMinHeightTrees(4, new int[][]{{1,0},{1,2},{1,3}}));
        System.out.println(findMinHeightTrees.findMinHeightTrees(6, new int[][]{{3,0},{3,1},{3,2},{3,4},{5,4}}));
    }
}
