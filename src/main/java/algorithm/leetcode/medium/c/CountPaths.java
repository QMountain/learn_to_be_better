package algorithm.leetcode.medium.c;

import java.util.*;

public class CountPaths {

    // 1 <= n <= 200
    public int countPaths2(int n, int[][] roads) {
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

    public int countPaths(int n, int[][] roads) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] road : roads) {
            List<int[]> list = map.getOrDefault(road[0], new ArrayList<>());
            list.add(new int[]{road[1], road[2]});
            map.put(road[0], list);

            List<int[]> list2 = map.getOrDefault(road[1], new ArrayList<>());
            list2.add(new int[]{road[0], road[2]});
            map.put(road[1], list2);
        }
        HashMap<Integer, Integer> minMap = new HashMap<>();
        minMap.put(0, 0);
        Set<String> finishedPath = new HashSet<>();
        LinkedList<Integer> nodeStack = new LinkedList<>();
        nodeStack.addLast(0);
        Stack<Integer> weightStack = new Stack<>();
        weightStack.push(0);
        int minSum = Integer.MAX_VALUE;
        int count = 0;
        int currSum = 0;
        while (!nodeStack.isEmpty()) {
            int currNode = nodeStack.peekLast();
            List<int[]> nextNodes = map.get(currNode);
            boolean getNext = false;
            for (int[] nextNode : nextNodes) {
                nodeStack.addLast(nextNode[0]);
                if (finishedPath.contains(nodeStack.toString())) {
                    nodeStack.pollLast();
                    continue;
                }
                // 当前节点重复，终结
                if (currSum + nextNode[1] > minMap.getOrDefault(nextNode[0], Integer.MAX_VALUE)) {
                    finishedPath.add(nodeStack.toString());
                    nodeStack.pollLast();
                    continue;
                } else {
                    minMap.put(nextNode[0], currSum + nextNode[1]);
                }
                // 当前节点不可能是最短路径，终结
                if (currSum + nextNode[1] > minSum) {
                    finishedPath.add(nodeStack.toString());
                    nodeStack.pollLast();
                    continue;
                }

                // 真 入栈
                currSum += nextNode[1];
                weightStack.push(nextNode[1]);
                getNext = true;
                if (nextNode[0] == n - 1) {
                    finishedPath.add(nodeStack.toString());
                    if (minSum == currSum) {
                        count++;
                    } else if (currSum < minSum) {
                        minSum = currSum;
                        count = 1;
                    }
                    nodeStack.pollLast();
                    currSum -= weightStack.pop();
                }
                break;
            }
            if (!getNext) {
                finishedPath.add(nodeStack.toString());
                nodeStack.pollLast();
                currSum -= weightStack.pop();
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountPaths countPaths = new CountPaths();
        System.out.println(countPaths.countPaths(2, new int[][]{{1, 0, 10}}));
        //System.out.println(countPaths.countPaths(12,
                //new int[][]{{1, 0, 2348}, {2, 1, 2852}, {2, 0, 5200}, {3, 1, 12480}, {2, 3, 9628}, {4, 3, 7367}, {4, 0, 22195}, {5, 4, 5668}, {1, 5, 25515}, {0, 5, 27863}, {6, 5, 836}, {6, 0, 28699}, {2, 6, 23499}, {6, 3, 13871}, {1, 6, 26351}, {5, 7, 6229}, {2, 7, 28892}, {1, 7, 31744}, {3, 7, 19264}, {6, 7, 5393}, {2, 8, 31998}, {8, 7, 3106}, {3, 8, 22370}, {8, 4, 15003}, {8, 6, 8499}, {8, 5, 9335}, {8, 9, 5258}, {9, 2, 37256}, {3, 9, 27628}, {7, 9, 8364}, {1, 9, 40108}, {9, 5, 14593}, {2, 10, 45922}, {5, 10, 23259}, {9, 10, 8666}, {10, 0, 51122}, {10, 3, 36294}, {10, 4, 28927}, {11, 4, 25190}, {11, 9, 4929}, {11, 8, 10187}, {11, 6, 18686}, {2, 11, 42185}, {11, 3, 32557}, {1, 11, 45037}}));
        System.out.println(countPaths.countPaths(7,
                new int[][]{{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}}));
    }
}
