package algorithm.leetcode.easy.m;

/**
 * 给你一个下标从 0 开始的整数数组 nums 。
 * 请你从所有满足 i < j < k 的下标三元组 (i, j, k) 中，
 * 找出并返回下标三元组的最大值。如果所有满足条件的三元组的值都是负数，则返回 0 。
 * 下标三元组 (i, j, k) 的值等于 (nums[i] - nums[j]) * nums[k] 。
 */
public class MaximumTripletValue {

    // 3 <= nums.length <= 100
    // 1 <= nums[i] <= 10^6
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long res = 0, imax = 0, dmax = 0;
        for (int k = 0; k < n; k++) {
            res = Math.max(res, dmax * nums[k]);
            dmax = Math.max(dmax, imax - nums[k]);
            imax = Math.max(imax, nums[k]);
        }
        return res;
    }

    public long maximumTripletValue2(int[] nums) {
        int length = nums.length;
        long[] suffix = new long[length];
        suffix[length-2] = nums[length-1];
        for (int i = length-3; i > 0; i--) {
            suffix[i] = Math.max(suffix[i+1], nums[i+1]);
        }
        long ans = 0;
        for (int i = 0; i < length - 2; i++) {
            for (int j = i+1; j < length - 1; j++) {
                long cal = (nums[i] - nums[j]) * suffix[j];
                ans = Math.max(ans, cal);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumTripletValue maximumTripletValue = new MaximumTripletValue();
        System.out.println(maximumTripletValue.maximumTripletValue(new int[]{1000000,1,1000000}));
        System.out.println(77 == maximumTripletValue.maximumTripletValue(new int[]{12,6,1,2,7}));
        System.out.println(133 == maximumTripletValue.maximumTripletValue(new int[]{1,10,3,4,19}));
        System.out.println(0 == maximumTripletValue.maximumTripletValue(new int[]{1,2,3}));
    }
}
