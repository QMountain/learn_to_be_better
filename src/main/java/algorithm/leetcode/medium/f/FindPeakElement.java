package algorithm.leetcode.medium.f;

public class FindPeakElement {

    // 不是符合要求的 logn 的最优解，需要好好读读题，理解里面的条件，用二分
    public int findPeakElement(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[length-1] > nums[length-2]) {
            return length-1;
        }
        for (int i = 1; i < length - 1; i++) {
            if (nums[i-1] < nums[i] && nums[i] > nums[i+1]) {
                return i;
            }
            if (nums[i] >= nums[i+1]) {
                i++;
            }
        }
        return -1;
    }

}
