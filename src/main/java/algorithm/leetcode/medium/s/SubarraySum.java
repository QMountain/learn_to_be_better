package algorithm.leetcode.medium.s;

public class SubarraySum {

    public int subarraySum(int[] nums, int k) {
        int length = nums.length;
        int[] prefixSum = new int[length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < length; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
        int res = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] == k) {
                res++;
            }
            for (int j = i+1; j < length; j++) {
                if (prefixSum[j]-prefixSum[i]+nums[i] == k) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SubarraySum subarraySum = new SubarraySum();
        System.out.println(subarraySum.subarraySum(new int[]{1,1,1}, 2));
    }
}
