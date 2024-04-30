package algorithm.leetcode.hard.m;

import java.util.*;

public class MinOperations {

    // 时间 8.7%  空间 21.74%
    public int minOperations(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int targetDiff = nums.length - 1;
        if (set.last() - set.first() == targetDiff && set.size() == nums.length) {
            return 0;
        }
        List<Integer> queue = new ArrayList<>(set.size());
        while (!set.isEmpty()) {
            queue.add(set.pollFirst());
        }
        int left = 0;
        int right = 0;
        int ans = nums.length;
        while (left <= right && right < queue.size()) {
            if (queue.get(right) - queue.get(left) <= targetDiff) {
                // 需要的操作数
                int operations = nums.length - (right - left + 1);
                ans = Math.min(ans, operations);
                right++;
            } else {
                left++;
            }
        }
        return ans;
    }

    // 时间 8.7%  空间 21.74%
    public int minOperations2(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int targetDiff = nums.length - 1;
        if (map.lastKey() - map.firstKey() == targetDiff && map.size() == nums.length) {
            return 0;
        }
        LinkedList<int[]> queue = new LinkedList<>();
        int ans = nums.length;
        while (!map.isEmpty()) {
            Map.Entry<Integer, Integer> polledFirstEntry = map.pollFirstEntry();
            Integer nextKey = polledFirstEntry.getKey();
            if (queue.isEmpty() || nextKey - queue.peekFirst()[0] <= targetDiff) {
                queue.add(new int[]{nextKey, polledFirstEntry.getValue()});
            } else {
                // 需要的操作数
                int operations = nums.length - queue.size();
                ans = Math.min(ans, operations);

                while (!queue.isEmpty() && nextKey - queue.peekFirst()[0] > targetDiff) {
                    queue.pollFirst();
                }
                queue.addLast(new int[]{nextKey, polledFirstEntry.getValue()});
            }
        }
        // 需要的操作数
        int operations = nums.length - queue.size();
        return Math.min(ans, operations);
    }

    public static void main(String[] args) {
        MinOperations minOperations = new MinOperations();
        System.out.println(8 == minOperations.minOperations(
                new int[]{11,45,36,3,17,9,9,39,4,2,43,27,42}));
        System.out.println(9 == minOperations.minOperations(new int[]{29,32,46,30,11,32,49,26,18,33,34,16,48,42,23,33}));
        System.out.println(0 == minOperations.minOperations(new int[]{4, 2, 5, 3}));
        System.out.println(1 == minOperations.minOperations(new int[]{1,2,3,5,6}));
        System.out.println(3 == minOperations.minOperations(new int[]{1,10,100,1000}));
    }
}
