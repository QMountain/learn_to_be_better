package algorithm.leetcode.easy;

public class IsMonotonic {

    public boolean isMonotonic(int[] nums) {
        int length = nums.length;
        boolean increase = true;
        boolean decrease = true;
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] > nums[i+1]) {
                increase = false;
            }
            if (nums[i] < nums[i+1]) {
                decrease = false;
            }
        }
        return increase || decrease;
    }

}
