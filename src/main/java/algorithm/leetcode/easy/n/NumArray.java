package algorithm.leetcode.easy.n;

public class NumArray {

    private final int[] prefixSum;

    public NumArray(int[] nums) {
        int length = nums.length;
        prefixSum = new int[length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < length; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return prefixSum[right];
        }
        return prefixSum[right] - prefixSum[left-1];
    }
}
