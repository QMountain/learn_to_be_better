package algorithm.leetcode.medium.m;

import java.util.HashMap;
import java.util.Map;

public class MaxOperations {

    // 2 <= nums.length <= 2000
    public int maxOperations(int[] nums) {
        Map<String, Integer> map = new HashMap<>();
        int m1 = cut(nums, 2, nums.length-1, nums[0] + nums[1], map);
        int m2 = cut(nums, 1, nums.length-2, nums[0] + nums[nums.length-1], map);
        int m3 = cut(nums, 0, nums.length-3, nums[nums.length-2] + nums[nums.length-1], map);
        return Math.max(m1, Math.max(m2, m3)) + 1;
    }

    public int cut(int[] nums, int left, int right, int target, Map<String, Integer> map) {
        if (left >= right) {
            return 0;
        }
        String key = target + "," + left + "," + right;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int maxValue = (right - left + 1) >> 1;
        int value = 0;
        if (nums[left] + nums[left+1] == target) {
            value = cut(nums, left+2, right, target, map) + 1;
        }
        if (value < maxValue && right - left > 1) {
            if (nums[left] + nums[right] == target) {
                int m = cut(nums, left+1, right-1, target, map) + 1;
                value = Math.max(value, m);
            }
            if (value < maxValue && nums[right] + nums[right-1] == target) {
                int m = cut(nums, left, right-2, target, map) + 1;
                value = Math.max(value, m);
            }
        }
        map.put(key, value);
        return value;
    }

    public static void main(String[] args) {
        MaxOperations maxOperations = new MaxOperations();
        System.out.println(2 == maxOperations.maxOperations(new int[]{3,2,6,1,4}));
        System.out.println(3 == maxOperations.maxOperations(new int[]{3,2,1,2,3,4}));
    }
}
