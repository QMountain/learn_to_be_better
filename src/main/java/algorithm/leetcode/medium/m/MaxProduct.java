package algorithm.leetcode.medium.m;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class MaxProduct {

    // 题号 318 最大单词长度乘积 尝试方法2, 实际提交结果没提升，题解提供的思路是位运算
    // 把出现的字符表示为01串，然后 & 运算，为0即没有相同字符
    public int maxProduct2(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int length = words.length;
        int max = 0;
        for (int i = length-1; i > 0; i--) {
            for (int j = i-1; j >= 0; j--) {
                int length1 = words[i].length();
                int length2 = words[j].length();
                if (length1 * length2 > max) {
                    if (check(words[i],words[j])) {
                        max = Math.max(max, length1 * length2);
                    }
                } else {
                    break;
                }
            }
        }
        return max;
    }

    // 题号 318 最大单词长度乘积
    public int maxProduct(String[] words) {
        int max = 0;
        int length = words.length;
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                int length1 = words[i].length();
                int length2 = words[j].length();
                if (length1 * length2 > max) {
                    if (check(words[i],words[j])) {
                        max = Math.max(max, length1 * length2);
                    }
                }
            }
        }
        return max;
    }

    public boolean check(String s1, String s2) {
        Set<Character> set = new HashSet<>();
        int length1 = s1.length();
        int length2 = s2.length();
        for (int i = 0; i < length1; i++) {
            set.add(s1.charAt(i));
        }
        for (int i = 0; i < length2; i++) {
            if (set.contains(s2.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public int maxProduct(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        if (nums[0] == 0) {
            int[] arr = new int[length-1];
            System.arraycopy(nums,1,arr,0,length-1);
            int i = maxProduct(arr);
            return Math.max(i,0);
        }
        for (int i = 1; i < length; i++) {
            if (nums[i] == 0) {
                int[] arr1 = new int[i];
                System.arraycopy(nums,0,arr1,0,i);
                int maxProduct1 = maxProduct(arr1);
                int[] arr2 = new int[length-i-1];
                System.arraycopy(nums,i+1,arr2,0,length-i-1);
                if (arr2.length > 0) {
                    int maxProduct2 = maxProduct(arr2);
                    maxProduct1 = Math.max(maxProduct1,maxProduct2);
                }
                return Math.max(maxProduct1,0);
            }
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        int countNegative;
        if (nums[0] < 0) {
            countNegative = 1;
        } else {
            countNegative = 0;
        }
        for (int i = 1; i < length; i++) {
            int num = nums[i];
            if (num < 0) {
                countNegative++;
            }
            dp[i] = dp[i-1]*num;
        }

        if (countNegative % 2 == 0) {
            return dp[length-1];
        }
        int max = dp[length-1];
        if (nums[0] < 0) {
            max = Math.max(dp[length-1]/nums[0],max);
        }
        for (int i = 1; i < length;i++) {
            if (nums[i] < 0) {
                max = Math.max(dp[i-1],max);
                max = Math.max(dp[length-1]/dp[i],max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaxProduct maxProduct = new MaxProduct();
        System.out.println(maxProduct.maxProduct2(new String[]{"eae","ea","aaf","bda","fcf","dc","ac","ce","cefde","dabae"}));
        System.out.println(maxProduct.maxProduct(new int[]{-2,0}));
        System.out.println(maxProduct.maxProduct(new int[]{-3,-1,-1}));
        System.out.println(maxProduct.maxProduct(new int[]{0,2}));
        System.out.println(maxProduct.maxProduct(new int[]{-2}));
        System.out.println(maxProduct.maxProduct(new int[]{-2, 0, -1}));
    }
}
