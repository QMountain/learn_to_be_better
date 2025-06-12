package algorithm.leetcode.easy.m;

public class MaxAdjacentDistance {

    public int maxAdjacentDistance(int[] nums) {
        int length = nums.length;
        int max = Math.abs(nums[0] - nums[length-1]);
        for (int i = 0; i < length-1; i++) {
            max = Math.max(max, Math.abs(nums[i] - nums[i+1]));
        }
        return max;
    }

}
