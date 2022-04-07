package algorithm.leetcode.easy;

import java.util.Arrays;

public class MaximumProduct {

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        return Math.max(
                nums[length-1]*nums[length-2]*nums[length-3],
                nums[0]*nums[1]*nums[length-1]);
    }

}
