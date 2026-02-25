package algorithm.leetcode.easy.s;

import java.util.PriorityQueue;
import java.util.TreeMap;

public class SortByBits {

    /**
     * 1356. 根据数字二进制下 1 的数目排序
     * 给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
     * 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
     * 请你返回排序后的数组。
     * 1 <= arr.length <= 500
     * 0 <= arr[i] <= 10^4
     */
    public int[] sortByBits(int[] arr) {
        TreeMap<Integer, PriorityQueue<Integer>> map = new TreeMap<>();
        for (int i : arr) {
            int n = i;
            int oneCount = 0;
            while (n > 0) {
                if (n % 2 == 1) {
                    oneCount++;
                }
                n >>= 1;
            }
            PriorityQueue<Integer> queue = map.getOrDefault(oneCount, new PriorityQueue<>());
            queue.add(i);
            map.put(oneCount, queue);
        }
        int[] res = new int[arr.length];
        int index = 0;
        while (!map.isEmpty()) {
            PriorityQueue<Integer> queue = map.pollFirstEntry().getValue();
            while (!queue.isEmpty()) {
                res[index++] = queue.poll();
            }
        }
        return res;
    }

}
