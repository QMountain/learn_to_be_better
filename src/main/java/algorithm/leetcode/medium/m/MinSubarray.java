package algorithm.leetcode.medium.m;

import java.util.*;

public class MinSubarray {

    // 1 <= nums.length <= 10^5
    // 1 <= nums[i] <= 10^9
    // 1 <= p <= 10^9
    public int minSubarray(int[] nums, int p) {
        int remainder = 0;
        for (int num : nums) {
            remainder = ((num % p) + remainder) % p;
        }
        if (remainder == 0) {
            return 0;
        }
        // 余数，lastIndex
        HashMap<Integer, Integer> map = new HashMap<>();
        int minLength = nums.length;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = (nums[i] % p + sum) % p;
            // 左侧累计 取余
            int key = sum % p;
            if (key == remainder) {
                minLength = Math.min(minLength, i + 1);
            }
            Set<Integer> needKeySet = new HashSet<>();
            needKeySet.add((key - remainder + p) % p);
            needKeySet.add((key - remainder + (p*2)) % p);
            if (key > remainder) {
                needKeySet.add(key - remainder);
            } else if (key == remainder) {
                needKeySet.add(0);
            }
            int lastIndex = -1;
            for (Integer needKey : needKeySet) {
                if (map.containsKey(needKey)) {
                    lastIndex = Math.max(lastIndex, map.get(needKey));
                }
            }
            if (lastIndex == -1) {
                map.put(key, i);
                continue;
            }
            int curr = i - lastIndex;
            minLength = Math.min(minLength, curr);
            map.put(key, i);
        }
        if (minLength < nums.length) {
            return minLength;
        }
        return -1;
    }

    public static void main(String[] args) {
        MinSubarray minSubarray = new MinSubarray();
        System.out.println(2 == minSubarray.minSubarray(new int[]{6,3,5,2}, 9));
        System.out.println(1 == minSubarray.minSubarray(new int[]{3, 1, 4, 2}, 6));

        System.out.println(7 == minSubarray.minSubarray(new int[]{8,32,31,18,34,20,21,13,1,27,23,22,11,15,30,4,2}, 148));
        System.out.println(0 == minSubarray.minSubarray(new int[]{1000000000,1000000000,1000000000}, 3));
        System.out.println(-1 == minSubarray.minSubarray(new int[]{1,2,3}, 7));
        System.out.println(0 == minSubarray.minSubarray(new int[]{1,2,3}, 3));

    }
}
