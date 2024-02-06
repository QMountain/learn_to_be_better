package algorithm.leetcode.medium.m;

import java.util.Map;
import java.util.TreeMap;

public class MaxResult {

    // 1 <= nums.length, k <= 10^5
    // -10^4 <= nums[i] <= 10^4
    public int maxResult(int[] nums, int k) {
        int length = nums.length;
        // key score; value index
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(nums[0], 0);
        for (int i = 1; i < length; i++) {
            Map.Entry<Integer, Integer> lastEntry;
            while (true) {
                lastEntry = map.lastEntry();
                Integer index = lastEntry.getValue();
                if (index + k < i) {
                    map.pollLastEntry();
                } else {
                    break;
                }
            }
            if (i == length-1) {
                return nums[i] + lastEntry.getKey();
            }
            map.put(nums[i] + lastEntry.getKey(), i);
        }
        return map.lastKey();
    }

    public static void main(String[] args) {
        MaxResult maxResult = new MaxResult();
        System.out.println(0 == maxResult.maxResult(new int[]{1,-5,-20,4,-1,3,-6,-3}, 2));
        System.out.println(17 == maxResult.maxResult(new int[]{10,-5,-2,4,0,3}, 3));
        System.out.println(7 == maxResult.maxResult(new int[]{1,-1,-2,4,-7,3}, 2));
    }
}
