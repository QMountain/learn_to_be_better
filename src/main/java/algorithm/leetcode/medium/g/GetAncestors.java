package algorithm.leetcode.medium.g;

import java.util.*;

public class GetAncestors {

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        Map<Integer, Set<Integer>> ancestorMap = new HashMap<>();
        for (int[] edge : edges) {
            Set<Integer> set2 = ancestorMap.getOrDefault(edge[1], new HashSet<>());
            set2.add(edge[0]);
            ancestorMap.put(edge[1], set2);
        }
        Map<Integer, TreeSet<Integer>> finishedMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            addToMap(i, ancestorMap, finishedMap);
        }
        List<List<Integer>> ansList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            TreeSet<Integer> treeSet = finishedMap.get(i);
            List<Integer> list = new ArrayList<>();
            while (!treeSet.isEmpty()) {
                list.add(treeSet.pollFirst());
            }
            ansList.add(list);
        }
        return ansList;
    }

    public void addToMap(int node, Map<Integer, Set<Integer>> ancestorMap,
                         Map<Integer, TreeSet<Integer>> finishedMap) {
        if (finishedMap.containsKey(node)) {
            return;
        }
        Set<Integer> ancestorSet = ancestorMap.get(node);
        if (ancestorSet == null) {
            finishedMap.put(node, new TreeSet<>());
            return;
        }
        if (ancestorSet.isEmpty()) {
            return;
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (Integer ancestor : ancestorSet) {
            addToMap(ancestor, ancestorMap, finishedMap);
            set.add(ancestor);
            set.addAll(finishedMap.get(ancestor));
        }
        finishedMap.put(node, set);
    }

    public static void main(String[] args) {
        GetAncestors getAncestors = new GetAncestors();
        System.out.println(getAncestors.getAncestors(8,
                new int[][]{{0,3},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6}}));
    }
}
