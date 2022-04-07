package algorithm.leetcode.medium;

import java.util.List;

public class FindMinHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[] count = new int[n];
        for (int[] edge : edges) {
            count[edge[0]]++;
            count[edge[1]]++;
        }
        while (true) {
            int maxIndex = findMaxIndex(count);
            int c = count[maxIndex];
            int length = edges.length;
            int[][] newEdges = new int[length-c][2];
            int i = 0;
            for (int[] edge : edges) {
                if (edge[0] != maxIndex && edge[1] != maxIndex) {
                    newEdges[i][0] = edge[0];
                    newEdges[i][1] = edge[1];
                }
            }
        }
    }

    public int findMaxIndex(int[] count) {
        int maxIndex = 0;
        int length = count.length;
        for (int i = 1; i < length; i++) {
            if (count[i] > count[0]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
