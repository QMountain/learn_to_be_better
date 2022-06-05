package algorithm.leetcode.medium.s;

public class SumOfBeauties {

    public int sumOfBeauties(int[] nums) {
        int length = nums.length;
        int[] leftMax = new int[length];
        leftMax[1] = nums[0];
        for (int i = 2; i < length; i++) {
            leftMax[i] = Math.max(leftMax[i-1],nums[i-1]);
        }
        int[] rightMin = new int[length];
        rightMin[length-2] = nums[length-1];
        for (int i = length-3; i > 0; i--) {
            rightMin[i] = Math.min(rightMin[i+1],nums[i+1]);
        }
        int ans = 0;
        for (int i = 1; i < length-1; i++) {
            if (nums[i] > leftMax[i] && nums[i] < rightMin[i]) {
                ans += 2;
            } else if (nums[i] > nums[i-1] && nums[i] < nums[i+1]) {
                ans += 1;
            }
        }
        return ans;
    }

}
