package algorithm.leetcode.medium.m;

import java.util.HashMap;
import java.util.Map;

public class MaximumPrimeDifference {

    public int maximumPrimeDifference(int[] nums) {
        int length = nums.length;
        int left = 0;
        for (int i = 0; i < length; i++) {
            if (isPrime(nums[i])) {
                left = i;
                break;
            }
        }
        int right = length - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (isPrime(nums[i])) {
                right = i;
                break;
            }
        }
        return right - left;
    }

    Map<Integer, Boolean> cache = new HashMap<>();

    public int maximumPrimeDifference2(int[] nums) {
        int length = nums.length;
        // i 是尝试的长度
        for (int i = length; i > 0; i--) {
            // j 是起点
            for (int j = 0; j <= length - i; j++) {
                if (isPrime(nums[j]) && isPrime(nums[j + i - 1])) {
                    return i - 1;
                }
            }
        }
        return 0;
    }

    public boolean isPrime(int num) {
        if (cache.containsKey(num)) {
            return cache.get(num);
        }
        if (num < 2) {
            return false;
        }
        boolean isPrime = true;
        int half = num >> 1;
        for (int i = 2; i <= half; i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }
        cache.put(num, isPrime);
        return isPrime;
    }

    public static void main(String[] args) {
        MaximumPrimeDifference maximumPrimeDifference = new MaximumPrimeDifference();
        System.out.println(0 == maximumPrimeDifference.maximumPrimeDifference(
                new int[]{4,8,2,8}));
        System.out.println(3 == maximumPrimeDifference.maximumPrimeDifference(
                new int[]{4,2,9,5,3}));
    }
}
