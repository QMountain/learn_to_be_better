package algorithm.leetcode.easy.f;

public class FindMaxAverage {

    public double findMaxAverage(int[] nums, int k) {
        int length = nums.length;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double maxSum = sum;
        for (int i = k; i < length; i++) {
            sum -= nums[i-k];
            sum += nums[i];
            maxSum = Math.max(maxSum,sum);
        }
        return maxSum/k;
    }

}
