package algorithm.leetcode.easy.s;

import java.util.Arrays;

public class SpecialArray {

    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        if (length <= nums[0]) {
            return length;
        }
        for (int i = 1; i < length; i++) {
            if (length-i > nums[i-1] && length-i <= nums[i]) {
                return length-i;
            }
        }
        return -1;
    }

}
