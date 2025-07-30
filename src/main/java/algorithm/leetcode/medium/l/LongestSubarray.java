package algorithm.leetcode.medium.l;

public class LongestSubarray {

    /**
     * 2419. 按位与最大的最长子数组
     * 给你一个长度为 n 的整数数组 nums 。
     * 考虑 nums 中进行 按位与（bitwise AND）运算得到的值 最大 的 非空 子数组。
     * 换句话说，令 k 是 nums 任意 子数组执行按位与运算所能得到的最大值。那么，只需要考虑那些执行一次按位与运算后等于 k 的子数组。
     * 返回满足要求的 最长 子数组的长度。
     * 数组的按位与就是对数组中的所有数字进行按位与运算。
     * 子数组 是数组中的一个连续元素序列。
     * 1 <= nums.length <= 10^5
     * 1 <= nums[i] <= 10^6
     */
    public int longestSubarray(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max) {
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] == max) {
                        ans = Math.max(ans, j - i + 1);
                        if (j == nums.length - 1) {
                            return ans;
                        }
                    } else {
                        i = j;
                        break;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestSubarray longestSubarray = new LongestSubarray();
        System.out.println(7 == longestSubarray.longestSubarray(new int[]{323376,323376,323376,323376,323376,323376,323376,75940,75940}));
        System.out.println(2 == longestSubarray.longestSubarray(new int[]{1,2,3,3,2,2}));
        System.out.println(1 == longestSubarray.longestSubarray(new int[]{1,2,3,4}));
    }
}
