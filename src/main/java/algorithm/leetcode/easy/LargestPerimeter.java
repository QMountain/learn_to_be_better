package algorithm.leetcode.easy;

import java.util.Arrays;

public class LargestPerimeter {

    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = length-3; i >= 0; i--) {
            if (nums[i] + nums[i+1] > nums[i+2]) {
                return nums[i]+ nums[i+1] + nums[i+2];
            }
        }
        return 0;
    }

}
