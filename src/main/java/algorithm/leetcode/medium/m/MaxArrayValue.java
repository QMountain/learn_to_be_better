package algorithm.leetcode.medium.m;

public class MaxArrayValue {

    // 1 <= nums.length <= 10^5
    public long maxArrayValue(int[] nums) {
        int length = nums.length;
        long currSum = nums[length-1];
        for (int i = length-2; i >= 0; i--) {
            if (nums[i] > currSum) {
                currSum = nums[i];
            } else {
                currSum += nums[i];
            }
        }
        return currSum;
    }

    public static void main(String[] args) {
        MaxArrayValue maxArrayValue = new MaxArrayValue();
        System.out.println(11 == maxArrayValue.maxArrayValue(new int[]{5,3,3}));
        System.out.println(21 == maxArrayValue.maxArrayValue(new int[]{2,3,7,9,3}));
    }
}
