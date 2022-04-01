package algorithm.leetcode.easy;

import java.util.Arrays;

public class ArrayPairSum {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int res = 0;
        for (int i = 0; i < length / 2; i++) {
            res += nums[i*2];
        }
        return res;
    }

}
