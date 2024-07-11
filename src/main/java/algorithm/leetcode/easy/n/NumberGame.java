package algorithm.leetcode.easy.n;

import java.util.Arrays;

public class NumberGame {

    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length; i+=2) {
            int t = nums[i];
            nums[i] = nums[i+1];
            nums[i+1] = t;
        }
        return nums;
    }

}
