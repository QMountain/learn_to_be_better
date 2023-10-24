package algorithm.leetcode.medium.c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CountPairs {

    // 1 <= n <= 10^5
    // 0 <= edges.length <= 2 * 10^5
    // edges[i].length == 2
    // 0 <= ai, bi < n
    // ai != bi
    // 不会有重复边。
    public long countPairs(int n, int[][] edges) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            HashSet<Integer> set1 = map.get(edge[0]);
            set1.add(edge[1]);
            map.put(edge[0], set1);

            HashSet<Integer> set2 = map.get(edge[1]);
            set2.add(edge[0]);
            map.put(edge[1], set2);
        }
        boolean[] searched = new boolean[n];
        List<HashSet<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!searched[i]) {
                HashSet<Integer> total = new HashSet<>();
                HashSet<Integer> set = map.get(i);
                total.add(i);
                searched[i] = true;
                while (!set.isEmpty()) {
                    total.addAll(set);
                    HashSet<Integer> ns = new HashSet<>();
                    for (Integer key : set) {
                        searched[key] = true;
                        HashSet<Integer> next = map.get(key);
                        for (Integer a : next) {
                            if (!searched[a]) {
                                ns.add(a);
                                searched[a] = true;
                            }
                        }
                    }
                    set = ns;
                }
                list.add(total);
            }
        }
        long ans = 0L;
        int size = list.size();
        for (int i = 0; i < size-1; i++) {
            int currSize = list.get(i).size();
            ans += (long) currSize * (n - currSize);
            n -= currSize;
        }
        return ans;
    }

    public static void main(String[] args) {
        CountPairs countPairs = new CountPairs();
        System.out.println(14 == countPairs.countPairs(7, new int[][]{{0,2},{0,5},{2,4},{1,6},{5,4}}));
        System.out.println(0 == countPairs.countPairs(3, new int[][]{{0,1},{0,2},{1,2}}));
    }
}
