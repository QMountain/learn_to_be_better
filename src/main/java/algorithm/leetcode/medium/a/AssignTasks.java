package algorithm.leetcode.medium.a;

import java.util.*;

public class AssignTasks {

    public int[] assignTasks(int[] servers, int[] tasks) {
        TreeMap<Integer, Queue<Integer>> availableMap = new TreeMap<>();
        int n = servers.length;
        for (int i = 0; i < n; i++) {
            availableMap.computeIfAbsent(servers[i], k -> new PriorityQueue<>()).add(i);
        }
        TreeMap<Integer, List<Integer>> workingMap = new TreeMap<>();
        int m = tasks.length;
        int[] ans = new int[m];
        int time = 0;
        for (int i = 0; i < m; i++) {
            while (!workingMap.isEmpty() && workingMap.firstKey() != null && workingMap.firstKey() <= i) {
                Map.Entry<Integer, List<Integer>> entry = workingMap.pollFirstEntry();
                List<Integer> serverIndexes = entry.getValue();
                for (Integer serverIndex : serverIndexes) {
                    availableMap.computeIfAbsent(servers[serverIndex], k -> new PriorityQueue<>()).add(serverIndex);
                }
            }
            while (true) {
                Map.Entry<Integer, Queue<Integer>> entry = availableMap.firstEntry();
                if (entry == null) {
                    Map.Entry<Integer, List<Integer>> entry1 = workingMap.pollFirstEntry();
                    time = entry1.getKey();
                    List<Integer> value = entry1.getValue();
                    for (Integer serverIndex : value) {
                        availableMap.computeIfAbsent(servers[serverIndex], k -> new PriorityQueue<>()).add(serverIndex);
                    }
                    entry = availableMap.firstEntry();
                } else {
                    time = Math.max(time, i);
                }
                Queue<Integer> queue = entry.getValue();
                if (queue != null && !queue.isEmpty()) {
                    Integer serverIndex = queue.poll();
                    if (queue.isEmpty()) {
                        availableMap.pollFirstEntry();
                    }
                    ans[i] = serverIndex;
                    workingMap.computeIfAbsent(time + tasks[i], k -> new ArrayList<>()).add(serverIndex);
                    break;
                } else {
                    availableMap.pollFirstEntry();
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        AssignTasks assignTasks = new AssignTasks();
        System.out.println(Arrays.toString(assignTasks.assignTasks(
                new int[]{31,96,73,90,15,11,1,90,72,9,30,88},
                new int[]{87,10,3,5,76,74,38,64,16,64,93,95,60,79,54,26,30,44,64,71})));
        System.out.println(Arrays.toString(assignTasks.assignTasks(
                new int[]{10,63,95,16,85,57,83,95,6,29,71},
                new int[]{70,31,83,15,32,67,98,65,56,48,38,90,5})));
        System.out.println(Arrays.toString(assignTasks.assignTasks(
                new int[]{5,1,4,3,2}, new int[]{2,1,2,4,5,2,1})));
        System.out.println(Arrays.toString(assignTasks.assignTasks(
                new int[]{3, 3, 2}, new int[]{1, 2, 3, 2, 1, 2})));
    }
}
