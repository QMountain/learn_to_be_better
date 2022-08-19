package algorithm.leetcode.medium.m;

import java.util.Arrays;
import java.util.LinkedList;

public class MinSubArrayLen {

    public int minSubArrayLen(int target, int[] nums) {
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
