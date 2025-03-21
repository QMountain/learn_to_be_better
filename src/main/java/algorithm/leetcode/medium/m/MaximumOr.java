package algorithm.leetcode.medium.m;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个下标从 0 开始长度为 n 的整数数组 nums 和一个整数 k 。
 * 每一次操作中，你可以选择一个数并将它乘 2 。
 * 你最多可以进行 k 次操作，请你返回 nums[0] | nums[1] | ... | nums[n - 1] 的最大值。
 * a | b 表示两个整数 a 和 b 的 按位或 运算。
 */
public class MaximumOr {

    /**
     * 1 <= nums.length <= 10^5
     * 1 <= nums[i] <= 10^9
     * 1 <= k <= 15
     */
    public long maximumOr2(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int[] bitCount = new int[32];
        int maxLength = 0;
        for (int num : nums) {
            String binaryString = Integer.toBinaryString(num);
            int length = binaryString.length();
            if (length > maxLength) {
                maxLength = length;
                set.clear();
                set.add(num);
                for (int i = 0; i < length; i++) {
                    if (binaryString.charAt(i) == '1') {
                        bitCount[32 - length + i]++;
                    }
                }
            } else if (length == maxLength) {
                set.add(num);
                for (int i = 0; i < length; i++) {
                    if (binaryString.charAt(i) == '1') {
                        bitCount[32 - length + i]++;
                    }
                }
            }
        }
        long other = 0;
        for (int num : nums) {
            if (!set.contains(num)) {
                other |= num;
            }
        }
        long max = 0;
        for (Integer i : set) {
            long n = 0;
            long base = 1;
            String binaryString = Integer.toBinaryString(i);
            for (int j = 0; j < binaryString.length(); j++) {
                if (bitCount[31 - j] - (binaryString.charAt(binaryString.length() - 1 - j) - '0') > 0) {
                    n += base;
                }
                base <<= 1;
            }
            n |= (long) i << k;
            n |= other;
            max = Math.max(max, n);
        }
        return max;
    }

    public long maximumOr(int[] nums, int k) {
        long orSum = 0, multiBits = 0;
        for (int x : nums) {
            multiBits |= x & orSum;
            orSum |= x;
        }
        long res = 0;
        for (int x : nums) {
            res = Math.max(res, (orSum ^ x) | ((long) x << k) | multiBits);
        }
        return res;
    }

    public static void main(String[] args) {
        MaximumOr maximumOr = new MaximumOr();
        System.out.println(30 == maximumOr.maximumOr(new int[]{12, 9}, 1));
        System.out.println(35 == maximumOr.maximumOr(new int[]{8,1,2}, 2));
    }
}
