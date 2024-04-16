package algorithm.leetcode.hard.t;

import java.util.*;

public class TreeAncestor {

    //int[] parent;
    //Map<Integer, LinkedList<Integer>> map;
    Map<Integer, List<Integer>> map;
    Map<Integer, Integer> indexMap;
    //int[] depthArr;

    // 1 <= k <= n <= 5 * 10^4
    public TreeAncestor(int n, int[] parent) {
        //this.parent = parent;
        map = new HashMap<>();
        indexMap = new HashMap<>();
        int[] isParent = new int[n];
        isParent[0] = 1;
        for (int i = 1; i < parent.length; i++) {
            isParent[parent[i]] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (isParent[i] == 0) {
                List<Integer> list = new ArrayList<>();
                int p = i;
                int index = 0;
                while (p != -1) {
                    indexMap.put(p, index++);
                    map.put(p, list);
                    list.add(p);
                    p = parent[p];
                }
            }
        }

        /*depthArr = new int[n];
        Map<Integer, List<Integer>> childrenMap = new HashMap<>();
        for (int i = 0; i < parent.length; i++) {
            List<Integer> list = childrenMap.getOrDefault(parent[i], new ArrayList<>());
            list.add(i);
            childrenMap.put(parent[i], list);
        }
        List<Integer> parents = Collections.singletonList(0);
        while (!parents.isEmpty()) {
            List<Integer> next = new ArrayList<>();
            for (Integer dad : parents) {
                List<Integer> children = childrenMap.get(dad);
                if (children != null) {
                    for (Integer child : children) {
                        depthArr[child] = depthArr[dad] + 1;
                        next.add(child);
                    }
                }
            }
            parents = next;
        }*/
    }

    public int getKthAncestor(int node, int k) {
        List<Integer> list = map.get(node);
        Integer index = indexMap.get(node);
        if (index + k >= list.size()) {
            return -1;
        }
        return list.get(index+k);
    }

    public static void main(String[] args) {
        TreeAncestor treeAncestor = new TreeAncestor(5, new int[]{-1,0,0,0,3});
        System.out.println(-1 == treeAncestor.getKthAncestor(1, 5));
        System.out.println(-1 == treeAncestor.getKthAncestor(3, 2));
        System.out.println(-1 == treeAncestor.getKthAncestor(0, 1));
        System.out.println(0 == treeAncestor.getKthAncestor(3, 1));
        System.out.println(-1 == treeAncestor.getKthAncestor(3, 5));
        System.out.println("-----------------------------------");

        TreeAncestor treeAncestor2 = new TreeAncestor(7, new int[]{-1,0,0,1,1,2,2});
        System.out.println(1 == treeAncestor2.getKthAncestor(3, 1));
        System.out.println(0 == treeAncestor2.getKthAncestor(5, 2));
        System.out.println(-1 == treeAncestor2.getKthAncestor(6, 3));
    }
}
