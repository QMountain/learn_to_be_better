package algorithm.leetcode.medium.l;

import java.util.*;

public class LargestValsFromLabels {

    // n == values.length == labels.length
    // 1 <= n <= 2 * 104
    // 0 <= values[i], labels[i] <= 2 * 104
    // 1 <= numWanted, useLimit <= n
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int length = values.length;
        HashMap<Integer, TreeMap<Integer, Integer>> labelMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            TreeMap<Integer, Integer> treeMap = labelMap.get(labels[i]);
            if (treeMap == null) {
                treeMap = new TreeMap<>();
            }
            treeMap.put(values[i], treeMap.getOrDefault(values[i], 0) + 1);
            if (treeMap.size() > useLimit) {
                treeMap.remove(treeMap.firstKey());
            }
            labelMap.put(labels[i], treeMap);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)-> b-a);
        for (Map.Entry<Integer, TreeMap<Integer, Integer>> entry : labelMap.entrySet()) {
            TreeMap<Integer, Integer> treeMap = entry.getValue();
            int count = 0;
            ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(treeMap.entrySet());
            for (int i = entries.size()-1; i >= 0; i--) {
                Map.Entry<Integer, Integer> e = entries.get(i);
                for (int j = 0; j < e.getValue(); j++) {
                    if (++count <= useLimit) {
                        queue.add(e.getKey());
                    } else {
                        break;
                    }
                }
                if (count == useLimit) {
                    break;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < numWanted && !queue.isEmpty(); i++) {
            ans += queue.poll();
        }
        return ans;
    }

    public static void main(String[] args) {
        LargestValsFromLabels largestValsFromLabels = new LargestValsFromLabels();
        System.out.println(24 == largestValsFromLabels.largestValsFromLabels(new int[]{9,8,8,7,6},
                new int[]{0,0,0,1,1}, 3, 2));
        System.out.println(16 == largestValsFromLabels.largestValsFromLabels(new int[]{9,8,8,7,6},
                new int[]{0,0,0,1,1}, 3, 1));
        System.out.println(12 == largestValsFromLabels.largestValsFromLabels(new int[]{5,4,3,2,1},
                new int[]{1,3,3,3,2}, 3, 2));
        System.out.println(9 == largestValsFromLabels.largestValsFromLabels(new int[]{5,4,3,2,1},
                new int[]{1,1,2,2,3}, 3, 1));
    }
}
