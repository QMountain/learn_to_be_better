package algorithm.leetcode.easy;

import java.util.Arrays;

public class MinimumDifference {

    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int length = nums.length;
        int minDiff = nums[k-1]-nums[0];
        for (int i = 1; i < length - k+1; i++) {
            int diff = nums[i + k - 1] - nums[i];
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        return minDiff;
    }

}
