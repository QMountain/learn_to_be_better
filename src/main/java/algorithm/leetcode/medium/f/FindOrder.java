package algorithm.leetcode.medium.f;

import java.util.*;

public class FindOrder {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,Set<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int key = prerequisite[0];
            HashSet<Integer> set = new HashSet<>(map.getOrDefault(key,new HashSet<>()));
            set.add(prerequisite[1]);
            map.put(key,set);
        }
        Set<Integer> settled = new HashSet<>();
        int[] ans = new int[numCourses];
        int putIndex = 0;
        while (true) {
            boolean find = false;
            for (int i = 0; i < numCourses; i++) {
                if (!settled.contains(i)) {
                    if (!map.containsKey(i) || settled.containsAll(map.get(i))) {
                        ans[putIndex] = i;
                        settled.add(i);
                        putIndex++;
                        find = true;
                        break;
                    }
                }
            }
            if (!find) {
                break;
            }
        }

        if (putIndex != numCourses) {
            return new int[0];
        }
        return ans;
    }

    public static void main(String[] args) {
        FindOrder findOrder = new FindOrder();
        System.out.println(Arrays.toString(findOrder.findOrder(3, new int[][]{{0,1},{0,2},{1,2}})));
        System.out.println(Arrays.toString(findOrder.findOrder(3, new int[][]{{2,0},{2,1}})));
        System.out.println(Arrays.toString(findOrder.findOrder(2, new int[][]{{1,0},{0,1}})));
        System.out.println(Arrays.toString(findOrder.findOrder(1, new int[][]{})));
        System.out.println(Arrays.toString(findOrder.findOrder(4, new int[][]{{1,0},{2,0},{3,1},{3,2}})));
        System.out.println(Arrays.toString(findOrder.findOrder(2, new int[][]{{1,0}})));
    }
}
