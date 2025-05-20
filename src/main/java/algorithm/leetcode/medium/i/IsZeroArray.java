package algorithm.leetcode.medium.i;

import java.util.*;

public class IsZeroArray {

    /**
     * 3355. 零数组变换 I
     * 给定一个长度为 n 的整数数组 nums 和一个二维数组 queries，其中 queries[i] = [li, ri]。
     * 对于每个查询 queries[i]：
     *      在 nums 的下标范围 [li, ri] 内选择一个下标 子集。
     *      将选中的每个下标对应的元素值减 1。
     * 零数组 是指所有元素都等于 0 的数组。
     * 如果在按顺序处理所有查询后，可以将 nums 转换为 零数组 ，则返回 true，否则返回 false。
     * 1 <= nums.length <= 10^5
     * 0 <= nums[i] <= 10^5
     * 1 <= queries.length <= 10^5
     * queries[i].length == 2
     * 0 <= li <= ri < nums.length
     */
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] deltaArray = new int[nums.length + 1];
        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];
            deltaArray[left] += 1;
            deltaArray[right + 1] -= 1;
        }
        int[] operationCounts = new int[deltaArray.length];
        int currentOperations = 0;
        for (int i = 0; i < deltaArray.length; i++) {
            currentOperations += deltaArray[i];
            operationCounts[i] = currentOperations;
        }
        for (int i = 0; i < nums.length; i++) {
            if (operationCounts[i] < nums[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean isZeroArray3(int[] nums, int[][] queries) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] query : queries) {
            List<int[]> list = map.getOrDefault(query[0], new ArrayList<>());
            list.add(query);
            map.put(query[0], list);
        }
        Map<Integer, Integer> endMap = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            List<int[]> list = map.get(i);
            int size = list == null ? 0 : list.size();
            if (size + count < nums[i]) {
                return false;
            }
            count -= endMap.getOrDefault(i, 0);
            endMap.remove(i);
            if (list != null) {
                for (int[] arr : list) {
                    if (arr[1] > i) {
                        endMap.put(arr[1], endMap.getOrDefault(arr[1], 0) + 1);
                        count++;
                    }
                }
            }
        }
        return true;
    }

    public boolean isZeroArray2(int[] nums, int[][] queries) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] query : queries) {
            List<int[]> list = map.getOrDefault(query[0], new ArrayList<>());
            list.add(query);
            map.put(query[0], list);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            List<int[]> list = map.get(i);
            int size = list == null ? 0 : list.size();
            if (size + queue.size() < nums[i]) {
                return false;
            }
            while (!queue.isEmpty() && queue.peek() == i) {
                queue.poll();
            }
            if (list != null) {
                for (int[] arr : list) {
                    if (arr[1] > i) {
                        queue.add(arr[1]);
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsZeroArray isZeroArray = new IsZeroArray();
        System.out.println(isZeroArray.isZeroArray(new int[]{5,6}, new int[][]{{0,1},{0,1},{0,1},{0,1},{0,0},{1,1},{0,0},{1,1},{0,1},{1,1},{1,1},{0,0},{0,0},{1,1},{0,1}}));
        System.out.println(!isZeroArray.isZeroArray(new int[]{4,3,2,1}, new int[][]{{1,3},{0,2}}));
        System.out.println(isZeroArray.isZeroArray(new int[]{1,0,1}, new int[][]{{0,2}}));
    }

}
