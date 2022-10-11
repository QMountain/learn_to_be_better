package algorithm.leetcode.easy.v;

import java.util.*;

public class ValidPath {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) {
            return true;
        }
        Set<Integer> sourceSet = Collections.singleton(source);
        List<int[]> totalList = new ArrayList<>(Arrays.asList(edges));
        while (true) {
            Set<Integer> nSourceSet = new HashSet<>();
            List<int[]> nTotalList = new ArrayList<>();
            for (int[] ints : totalList) {
                if (sourceSet.contains(ints[0])) {
                    nSourceSet.add(ints[1]);
                } else if (sourceSet.contains(ints[1])) {
                    nSourceSet.add(ints[0]);
                } else {
                    nTotalList.add(ints);
                }
            }
            if (nSourceSet.contains(destination)) {
                return true;
            }
            if (nSourceSet.isEmpty()) {
                return false;
            }
            sourceSet = nSourceSet;
            totalList = nTotalList;
        }
    }

    public static void main(String[] args) {
        ValidPath validPath = new ValidPath();
        System.out.println(validPath.validPath(1, new int[][]{}, 0, 0));
        System.out.println(validPath.validPath(6, new int[][]{{0,1},{0,2},{3,5},{5,4},{4,3}}, 0, 5));
        System.out.println(validPath.validPath(3, new int[][]{{0,1},{1,2},{2,0}}, 0, 2));
    }
}
