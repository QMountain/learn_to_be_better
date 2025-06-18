package algorithm.leetcode.medium.d;

import java.util.Arrays;

public class DivideArray {

    /**
     * 2966. 划分数组并满足最大差限制
     * 给你一个长度为 n 的整数数组 nums，以及一个正整数 k 。
     * 将这个数组划分为 n / 3 个长度为 3 的子数组，并满足以下条件：
     * 子数组中 任意 两个元素的差必须 小于或等于 k 。
     * 返回一个 二维数组 ，包含所有的子数组。如果不可能满足条件，就返回一个空数组。
     * 如果有多个答案，返回 任意一个 即可。
     * n == nums.length
     * 1 <= n <= 10^5
     * n 是 3 的倍数
     * 1 <= nums[i] <= 10^5
     * 1 <= k <= 10^5
     */
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int length = nums.length;
        int[][] arr = new int[length/3][3];
        for (int i = 0; i < length - 2; i+=3) {
            if (nums[i+2] - nums[i] > k) {
                return new int[0][0];
            }
            arr[i/3][0] = nums[i];
            arr[i/3][1] = nums[i+1];
            arr[i/3][2] = nums[i+2];
        }
        return arr;
    }

    public static void main(String[] args) {
        DivideArray divideArray = new DivideArray();
        System.out.println(Arrays.deepToString(divideArray.divideArray(
                new int[]{1,3,4,8,7,9,3,5,1}, 2)));
    }
}
