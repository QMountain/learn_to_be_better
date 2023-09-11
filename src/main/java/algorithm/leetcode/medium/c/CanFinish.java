package algorithm.leetcode.medium.c;

import java.util.*;

public class CanFinish {

    List<List<Integer>> edges;
    int[] indeg;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<>());
        }
        indeg = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            ++indeg[info[0]];
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }

        int visited = 0;
        while (!queue.isEmpty()) {
            ++visited;
            int u = queue.poll();
            for (int v: edges.get(u)) {
                --indeg[v];
                if (indeg[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return visited == numCourses;
    }

    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        HashSet<Integer> canBeHead = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            canBeHead.add(i);
        }
        HashSet<int[]> prerequisiteSet = new HashSet<>(Arrays.asList(prerequisites));
        while (!prerequisiteSet.isEmpty()) {
            HashSet<Integer> currHead = new HashSet<>(canBeHead);
            for (int[] prerequisite : prerequisiteSet) {
                currHead.remove(prerequisite[0]);
            }
            HashSet<int[]> nps = new HashSet<>();
            for (int[] prerequisite : prerequisiteSet) {
                if (!currHead.contains(prerequisite[1])) {
                    nps.add(prerequisite);
                }
            }
            if (nps.size() == prerequisiteSet.size()) {
                return false;
            }
            prerequisiteSet = nps;
        }
        return true;
    }

    public static void main(String[] args) {
        CanFinish canFinish = new CanFinish();
        System.out.println(canFinish.canFinish(8, new int[][]{{1,0},{2,6},{1,7},{6,4},{7,0},{0,5}}));

        System.out.println(!canFinish.canFinish(4, new int[][]{{2,0},{1,0},{3,1},{3,2},{1,3}}));
        System.out.println(!canFinish.canFinish(4, new int[][]{{0,1},{3,1},{1,3},{3,2}}));
        System.out.println(canFinish.canFinish(5, new int[][]{{1,4},{2,4},{3,1},{3,2}}));
        System.out.println(!canFinish.canFinish(3, new int[][]{{1,0},{2,0},{0,2}}));
        System.out.println(!canFinish.canFinish(2, new int[][]{{1, 0},{0,1}}));
        System.out.println(!canFinish.canFinish(13, new int[][]{{1,2},{2,3},{2,10},{3,4},{4,5},{4,11},{5,1}}));
        System.out.println(!canFinish.canFinish(3, new int[][]{{1,0},{0,2},{2,1}}));

        System.out.println(!canFinish.canFinish(20, new int[][]{{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}}));

        System.out.println(canFinish.canFinish(2, new int[][]{{1, 0}}));
    }
}
