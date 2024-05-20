package algorithm.leetcode.medium.c;

public class CheckPossibility {

    public boolean checkPossibility(int[] nums) {
        int length = nums.length;
        Integer leftMax = null;
        for (int i = 0; i < length-1; i++) {
            if (nums[i] > nums[i+1]) {
                if (leftMax != null && nums[i+1] < leftMax) {
                    nums[i+1] = nums[i];
                }
                for (int j = i+1; j < length-1; j++) {
                    if (nums[j] > nums[j+1]) {
                        return false;
                    }
                }
                return true;
            } else {
                leftMax = nums[i];
            }
        }
        return true;
    }

}
