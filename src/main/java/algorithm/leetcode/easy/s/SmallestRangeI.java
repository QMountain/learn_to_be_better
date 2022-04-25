package algorithm.leetcode.easy.s;

import java.util.Arrays;

public class SmallestRangeI {

    public int smallestRangeI(int[] nums, int k) {
        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[nums.length-1];
        int diff = max - min;
        if (diff >= k*2) {
            return diff - k*2;
        }
        return 0;
    }

}
