package algorithm.leetcode.medium.w;

public class WaysToSplitArray {

    public int waysToSplitArray(int[] nums) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int count = 0;
        long leftSum = 0;
        for (int i = 0; i < nums.length-1; i++) {
            leftSum += nums[i];
            if (leftSum >= sum - leftSum) {
                count++;
            }
        }
        return count;
    }

}
