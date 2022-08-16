package algorithm.leetcode.medium.f;

public class FindMin {

    public int findMin(int[] nums) {
        int length = nums.length;
        if (nums[0] < nums[length-1]) {
            return nums[0];
        }
        for (int i = 1; i < length; i++) {
            if (nums[i] < nums[i-1]) {
                return nums[i];
            }
        }
        return nums[0];
    }

}
