package algorithm.leetcode.medium.f;

import java.util.Arrays;

public class FindValueOfPartition {

    // 2 <= nums.length <= 10^5
    // 1 <= nums[i] <= 10^9
    public int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int minDiff = nums[1] - nums[0];
        for (int i = 1; i < nums.length; i++) {
            minDiff = Math.min(nums[i] - nums[i-1], minDiff);
        }
        return minDiff;
    }

}
