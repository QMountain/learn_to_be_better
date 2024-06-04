package algorithm.leetcode.medium.c;

import java.util.*;

public class CountPairsOfConnectableServers {

    TreeMap<Integer, List<int[]>> map;
    int signalSpeed;

    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        this.signalSpeed = signalSpeed;
        int length = edges.length;
        map = new TreeMap<>();
        for (int[] edge : edges) {
            List<int[]> list1 = map.getOrDefault(edge[0], new ArrayList<>());
            list1.add(new int[]{edge[1], edge[2]});
            map.put(edge[0], list1);

            List<int[]> list2 = map.getOrDefault(edge[1], new ArrayList<>());
            list2.add(new int[]{edge[0], edge[2]});
            map.put(edge[1], list2);
        }
        int[] ans = new int[map.size()];
        for (int i = 0; i < map.size(); i++) {
            List<int[]> canArriveNodes = map.get(i);
            List<Integer> countList = new ArrayList<>();
            if (canArriveNodes.size() > 1) {
                for (int[] canArriveNode : canArriveNodes) {
                    int search = search(i, canArriveNode[0], canArriveNode[1]);
                    if (search > 0) {
                        countList.add(search);
                    }
                }
                if (countList.size() >= 2) {
                    int v = 0;
                    for (int j = 0; j < countList.size()-1; j++) {
                        Integer a = countList.get(j);
                        for (int k = j+1; k < countList.size(); k++) {
                            Integer b = countList.get(k);
                            v += a * b;
                        }
                    }
                    ans[i] = v;
                }
            }
        }
        return ans;
    }

    public int search(int p1, int p2, int sum) {
        List<int[]> list = map.get(p2);
        int count = sum % signalSpeed == 0 ? 1 : 0;
        for (int[] arr : list) {
            if (arr[0] != p1) {
                int search = search(p2, arr[0], sum + arr[1]);
                count += search;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountPairsOfConnectableServers countPairsOfConnectableServers = new CountPairsOfConnectableServers();
        System.out.println(Arrays.toString(countPairsOfConnectableServers
                .countPairsOfConnectableServers(
                        new int[][]{{1,0,2},{2,1,4},{3,2,4},{4,0,3},{5,1,4},{6,2,2},{7,6,4},{8,1,2},{9,8,3}}, 1)));
        System.out.println(Arrays.toString(countPairsOfConnectableServers
                .countPairsOfConnectableServers(
                        new int[][]{{0,6,3},{6,5,3},{0,3,1},{3,2,7},{3,1,6},{3,4,2}}, 3)));
        System.out.println(Arrays.toString(countPairsOfConnectableServers
                .countPairsOfConnectableServers(
                        new int[][]{{0,1,1},{1,2,5},{2,3,13},{3,4,9},{4,5,2}}, 1)));
    }
}
