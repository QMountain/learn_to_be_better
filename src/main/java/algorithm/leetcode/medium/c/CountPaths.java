package algorithm.leetcode.medium.c;

import java.util.*;

public class CountPaths {

    // 1 <= n <= 200
    // 1 <= time[i] <= 10^9
    // 时间 5.02%  空间 5.00%
    public int countPaths(int n, int[][] roads) {
        if (roads.length == 0) {
            return 1;
        }
        Map<Integer, TreeMap<Integer, Set<Integer>>> map = new HashMap<>();
        for (int[] road : roads) {
            int key1 = road[0];
            TreeMap<Integer, Set<Integer>> treeMap1 = map.getOrDefault(key1, new TreeMap<>());
            Set<Integer> set1 = treeMap1.getOrDefault(road[2], new HashSet<>());
            set1.add(road[1]);
            treeMap1.put(road[2], set1);
            map.put(key1, treeMap1);

            int key2 = road[1];
            TreeMap<Integer, Set<Integer>> treeMap2 = map.getOrDefault(key2, new TreeMap<>());
            Set<Integer> set2 = treeMap2.getOrDefault(road[2], new HashSet<>());
            set2.add(road[0]);
            treeMap2.put(road[2], set2);
            map.put(key2, treeMap2);
        }
        Map<Integer, int[]> minMap = new HashMap<>();
        minMap.put(0, new int[]{0, 1});
        Set<Integer> nodes = new HashSet<>();
        nodes.add(0);
        while (true) {
            int min = Integer.MAX_VALUE;
            for (Integer node : nodes) {
                TreeMap<Integer, Set<Integer>> treeMap = map.get(node);
                if (treeMap != null) {
                    if (!treeMap.isEmpty()) {
                        int minStepToNextNode = treeMap.firstKey() + minMap.get(node)[0];
                        min = Math.min(minStepToNextNode, min);
                    } else {
                        map.remove(node);
                    }
                }
            }
            Set<Integer> next = new HashSet<>();
            for (Integer node : nodes) {
                int[] minArr = minMap.get(node);
                int zeroToCurrNode = minArr[0];
                TreeMap<Integer, Set<Integer>> treeMap = map.get(node);
                while (treeMap != null && !treeMap.isEmpty()
                        && treeMap.firstKey() + minMap.get(node)[0] <= min) {
                    Map.Entry<Integer, Set<Integer>> entry = treeMap.pollFirstEntry();
                    Integer steps = entry.getKey();
                    Set<Integer> value = entry.getValue();
                    for (Integer i : value) {
                        if (!nodes.contains(i)) {
                            next.add(i);
                            int[] currArr = minMap.getOrDefault(i, new int[]{zeroToCurrNode + steps, 0});
                            currArr[1] += minArr[1];
                            currArr[1] %= 1000_000007;
                            minMap.put(i, currArr);

                            Set<Integer> set = map.get(i).get(steps);
                            if (set.size() > 1) {
                                set.remove(node);
                            } else {
                                map.get(i).remove(steps);
                            }
                        }
                    }
                }
            }
            if (next.contains(n-1)) {
                return minMap.get(n-1)[1];
            }
            nodes.addAll(next);
        }
    }

    public int countPaths3(int n, int[][] roads) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] road : roads) {
            List<int[]> list = map.getOrDefault(road[0], new ArrayList<>());
            list.add(new int[]{road[1], road[2]});
            map.put(road[0], list);

            List<int[]> list2 = map.getOrDefault(road[1], new ArrayList<>());
            list2.add(new int[]{road[0], road[2]});
            map.put(road[1], list2);
        }
        // 到达 key 这个点，最少需要 value[0]分钟，有 value[1] 种方式
        Map<Integer, int[]> minMap = new HashMap<>();
        minMap.put(0, new int[]{0, 1});
        Set<Integer> nodes = Collections.singleton(0);
        Set<Integer> passSet = new HashSet<>();
        passSet.add(0);
        while (!nodes.isEmpty()) {
            Set<Integer> next = new HashSet<>();
            for (int fromNode : nodes) {
                int untilFromNodeMin = minMap.get(fromNode)[0];
                int untilFromNodeMethods = minMap.get(fromNode)[1];
                List<int[]> list = map.get(fromNode);
                for (int[] arriveNode : list) {
                    int weight = untilFromNodeMin + arriveNode[1];
                    if (!minMap.containsKey(arriveNode[0])) {
                        minMap.put(arriveNode[0], new int[]{weight, untilFromNodeMethods});
                        if (arriveNode[0] != n-1 && !passSet.contains(arriveNode[0])) {
                            next.add(arriveNode[0]);
                        }
                    } else {
                        int[] arr = minMap.get(arriveNode[0]);
                        if (weight == arr[0]) {
                            arr[1] += untilFromNodeMethods;
                            if (arriveNode[0] != n-1 && !passSet.contains(arriveNode[0])) {
                                next.add(arriveNode[0]);
                            }
                        } else if (weight < arr[0]) {
                            arr[0] = weight;
                            arr[1] = 1;
                            if (arriveNode[0] != n-1 && !passSet.contains(arriveNode[0])) {
                                next.add(arriveNode[0]);
                            }
                        }
                    }
                }
            }
            passSet.addAll(nodes);
            nodes = next;
        }
        return minMap.get(n-1)[1];
    }

    public int countPaths2(int n, int[][] roads) {
        Map<Integer, TreeMap<Integer, Integer>> map = new HashMap<>();
        for (int[] road : roads) {
            TreeMap<Integer, Integer> map1 = map.getOrDefault(road[0], new TreeMap<>());
            map1.put(road[1], road[2]);
            map.put(road[0], map1);

            TreeMap<Integer, Integer> map2 = map.getOrDefault(road[1], new TreeMap<>());
            map2.put(road[0], road[2]);
            map.put(road[1], map2);
        }
        // key node
        // value    0 到达当前节点已知的最短路径用时
        //          1 到达当前节点最少用时的方案数
        HashMap<Integer, int[]> minMap = new HashMap<>();
        minMap.put(0, new int[]{0, 1});
        Set<Integer> passedSet = new HashSet<>();
        Set<Integer> fromNodes = new HashSet<>();
        fromNodes.add(0);
        int minSum = Integer.MAX_VALUE;
        int count = 0;
        while (!fromNodes.isEmpty()) {
            passedSet.addAll(fromNodes);
            Set<Integer> nextNodes = new HashSet<>();
            for (Integer fromNode : fromNodes) {
                Set<Integer> totalCanArriveNextNodes = new HashSet<>();
                TreeMap<Integer, Integer> canArriveNextNodes = map.get(fromNode);
                for (Map.Entry<Integer, Integer> entry : canArriveNextNodes.entrySet()) {
                    if (entry.getKey() == n-1) {
                        int totalToEnd = entry.getValue() + minMap.get(fromNode)[0];
                        if (totalToEnd == minSum) {
                            count++;
                        } else if (totalToEnd < minSum) {
                            minSum = totalToEnd;
                            count = minMap.get(fromNode)[1];
                        }
                    } else {
                        int currUntil = entry.getValue() + minMap.get(fromNode)[0];
                        int[] arr = minMap.getOrDefault(entry.getKey(), new int[]{Integer.MAX_VALUE, 0});
                        if (currUntil == arr[0]) {
                            arr[1]++;
                            totalCanArriveNextNodes.add(entry.getKey());
                        } else if (currUntil < arr[0]) {
                            arr[0] = currUntil;
                            arr[1] = 1;
                            totalCanArriveNextNodes.add(entry.getKey());
                        }
                        minMap.put(entry.getKey(), arr);
                    }
                }
                for (Integer possibleNextNode : totalCanArriveNextNodes) {
                    int fromNodeToPossibleTime = minMap.get(possibleNextNode)[0];
                    for (Map.Entry<Integer, Integer> entry : map.get(possibleNextNode).entrySet()) {
                        if (!passedSet.contains(entry.getKey())) {
                            if (!totalCanArriveNextNodes.contains(entry.getKey())) {
                                nextNodes.add(entry.getKey());
                            } else {
                                Integer fromNodeToEntryTime = minMap.get(entry.getKey())[0];
                                Integer currPossibleToEntry = map.get(possibleNextNode).get(entry.getKey());
                                if (fromNodeToPossibleTime == fromNodeToEntryTime + currPossibleToEntry) {
                                    minMap.get(entry.getKey())[1]++;
                                } else if (fromNodeToPossibleTime > fromNodeToEntryTime + currPossibleToEntry) {
                                    minMap.put(entry.getKey(), new int[]{fromNodeToEntryTime + currPossibleToEntry, 1});
                                } else {
                                    map.get(entry.getKey()).remove(possibleNextNode);
                                }
                            }
                        }
                    }
                }
            }
            fromNodes = nextNodes;
        }
        return count;
    }

    public static void main(String[] args) {
        CountPaths countPaths = new CountPaths();
        System.out.println(2 == countPaths.countPaths(6, new int[][]{{3,0,4},{0,2,3},{1,2,2},{4,1,3},{2,5,5},{2,3,1},{0,4,1},{2,4,6},{4,3,1}}));
        System.out.println(countPaths.countPaths(1, new int[][]{}));
        System.out.println(1 == countPaths.countPaths(2, new int[][]{{1, 0, 10}}));
        System.out.println(countPaths.countPaths(12,
                new int[][]{{1, 0, 2348}, {2, 1, 2852}, {2, 0, 5200}, {3, 1, 12480}, {2, 3, 9628}, {4, 3, 7367}, {4, 0, 22195}, {5, 4, 5668}, {1, 5, 25515}, {0, 5, 27863}, {6, 5, 836}, {6, 0, 28699}, {2, 6, 23499}, {6, 3, 13871}, {1, 6, 26351}, {5, 7, 6229}, {2, 7, 28892}, {1, 7, 31744}, {3, 7, 19264}, {6, 7, 5393}, {2, 8, 31998}, {8, 7, 3106}, {3, 8, 22370}, {8, 4, 15003}, {8, 6, 8499}, {8, 5, 9335}, {8, 9, 5258}, {9, 2, 37256}, {3, 9, 27628}, {7, 9, 8364}, {1, 9, 40108}, {9, 5, 14593}, {2, 10, 45922}, {5, 10, 23259}, {9, 10, 8666}, {10, 0, 51122}, {10, 3, 36294}, {10, 4, 28927}, {11, 4, 25190}, {11, 9, 4929}, {11, 8, 10187}, {11, 6, 18686}, {2, 11, 42185}, {11, 3, 32557}, {1, 11, 45037}}));
        System.out.println(4 == countPaths.countPaths(7,
                new int[][]{{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}}));
    }
}
