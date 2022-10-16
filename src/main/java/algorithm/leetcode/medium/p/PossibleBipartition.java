package algorithm.leetcode.medium.p;

import java.util.*;

public class PossibleBipartition {

    public boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] dislike : dislikes) {
            Set<Integer> oldSet = map.get(dislike[0]);
            Set<Integer> newSet = new HashSet<>();
            if (oldSet != null) {
                newSet.addAll(oldSet);
            }
            newSet.add(dislike[1]);
            map.put(dislike[0],newSet);
            Set<Integer> oldSet2 = map.get(dislike[1]);
            Set<Integer> newSet2 = new HashSet<>();
            if (oldSet2 != null) {
                newSet2.addAll(oldSet2);
            }
            newSet2.add(dislike[0]);
            map.put(dislike[1],newSet2);
        }
        Set<Integer> total = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!total.contains(i+1) && map.containsKey(i+1)) {
                Set<Integer> current = new HashSet<>();
                Set<Integer> set = Collections.singleton(i+1);
                int circleSize = 0;
                boolean isCircle = false;
                while (!set.isEmpty()) {
                    circleSize++;
                    current.addAll(set);
                    Set<Integer> ns = new HashSet<>();
                    for (Integer s : set) {
                        Set<Integer> s2 = new HashSet<>(map.get(s));
                        for (Integer integer : s2) {
                            if (!current.contains(integer)) {
                                ns.add(integer);
                                map.get(s).remove(integer);
                                map.get(integer).remove(s);
                            } else {
                                isCircle = true;
                                if (circleSize % 2 == 0) {
                                    return false;
                                }
                            }
                        }
                    }
                    set = ns;
                }
                if (isCircle && circleSize % 2 == 1) {
                    return false;
                }
                total.addAll(current);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PossibleBipartition possibleBipartition = new PossibleBipartition();
        System.out.println(possibleBipartition.possibleBipartition(3, new int[][]{{1,2},{1,3},{2,3}}));
        System.out.println(possibleBipartition.possibleBipartition(4, new int[][]{{1,2},{1,3},{2,4}}));
    }
}
