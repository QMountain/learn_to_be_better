package algorithm.leetcode.medium.m;

import java.util.Arrays;
import java.util.LinkedList;

public class MinSubArrayLen {

    /**
     * LCR 008. 长度最小的子数组
     * 给定一个含有 n 个正整数的数组和一个正整数 target 。
     * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
     * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
     * 1 <= target <= 10^9
     * 1 <= nums.length <= 10^5
     * 1 <= nums[i] <= 10^5
     * 进阶：
     * 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
     */
    public int minSubArrayLen(int target, int[] nums) {
        int length = nums.length;
        int left = 0;
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            if (sum >= target) {
                if (ans == 0) {
                    ans = i - left + 1;
                } else {
                    ans = Math.min(ans, i - left + 1);
                }
                for (int j = left; j < i; j++) {
                    sum -= nums[left++];
                    if (sum < target) {
                        break;
                    } else {
                        ans = Math.min(ans, i - left + 1);
                    }
                }

            }
        }
        return ans;
    }

    public int minSubArrayLen3(int target, int[] nums) {
        int length = nums.length;
        int startIndex = 0;
        int endIndex = 0;
        int sum = nums[0];
        int minLength = 0;
        while (true) {
            if (sum >= target) {
                if (minLength == 0) {
                    minLength = endIndex-startIndex+1;
                } else {
                    minLength = Math.min(minLength,endIndex-startIndex+1);
                }
                sum -= nums[startIndex++];
            } else {
                if (endIndex + 1 < length) {
                    sum += nums[++endIndex];
                } else {
                    break;
                }
            }
        }
        return minLength;
    }

    public int minSubArrayLen2(int target, int[] nums) {
        int allSum = Arrays.stream(nums).sum();
        if (allSum < target) {
            return 0;
        }
        int minLength = nums.length;
        LinkedList<Integer> list = new LinkedList<>();
        int sum = 0;
        for (int num : nums) {
            sum += num;
            list.add(num);
            while (sum >= target) {
                minLength = Math.min(minLength, list.size());
                sum -= list.peekFirst();
                list.pollFirst();
            }
        }
        return minLength;
    }

    public static void main(String[] args) {
        MinSubArrayLen minSubArrayLen = new MinSubArrayLen();
        System.out.println(minSubArrayLen.minSubArrayLen(4, new int[]{1,4,4}));
        System.out.println(minSubArrayLen.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
}
