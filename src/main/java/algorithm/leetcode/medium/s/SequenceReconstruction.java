package algorithm.leetcode.medium.s;

import algorithm.Node;

import java.util.*;

public class SequenceReconstruction {

    // n == nums.length
    // 1 <= n <= 10^4
    // nums 是 [1, n] 范围内所有整数的排列
    // 1 <= sequences.length <= 10^4
    // 1 <= sequences[i].length <= 10^4
    // 1 <= sum(sequences[i].length) <= 10^5
    // 1 <= sequences[i][j] <= n
    // sequences 的所有数组都是 唯一 的
    // sequences[i] 是 nums 的一个子序列
    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        int n = nums.length;
        int[] indegrees = new int[n + 1];
        Set<Integer>[] graph = new Set[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new HashSet<Integer>();
        }
        for (int[] sequence : sequences) {
            int size = sequence.length;
            for (int i = 1; i < size; i++) {
                int prev = sequence[i - 1], next = sequence[i];
                if (graph[prev].add(next)) {
                    indegrees[next]++;
                }
            }
        }
        Queue<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 1; i <= n; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            if (queue.size() > 1) {
                return false;
            }
            int num = queue.poll();
            Set<Integer> set = graph[num];
            for (int next : set) {
                indegrees[next]--;
                if (indegrees[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return true;
    }

    public boolean sequenceReconstruction2(int[] nums, int[][] sequences) {
        int n = nums.length;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            String key = nums[i] + "," + nums[i+1];
            map.put(key, 0);
        }
        for (int[] sequence : sequences) {
            int length = sequence.length;
            for (int i = 0; i < length-1; i++) {
                String key = sequence[i] + "," + sequence[i+1];
                if (map.containsKey(key)) {
                    map.put(key, map.get(key)+1);
                }
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SequenceReconstruction sequenceReconstruction = new SequenceReconstruction();
        System.out.println(sequenceReconstruction.sequenceReconstruction(
                new int[]{4, 1, 5, 2, 6, 3},
                new int[][]{{5,2,6,3},{4,1,5,2}}));
        System.out.println(!sequenceReconstruction.sequenceReconstruction(new int[]{1, 2, 3},
                new int[][]{{1,2},{1,3}}));
    }
}
