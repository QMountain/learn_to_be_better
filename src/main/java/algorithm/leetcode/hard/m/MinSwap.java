package algorithm.leetcode.hard.m;

public class MinSwap {

    public int minSwap(int[] nums1, int[] nums2) {
        int length = nums1.length;
        // 0,swap min  1,not swap min
        int[][] dp = new int[length][2];
        dp[0][1] = 1;
        for (int i = 1; i < length; i++) {
            int noSwapMin = Integer.MAX_VALUE;
            // 1. 前一步不swap，这一步也不swap
            // 满足条件
            if (nums1[i] > nums1[i-1] && nums2[i] > nums2[i-1]) {
                noSwapMin = Math.min(noSwapMin,dp[i-1][0]);
            }
            // 2. 前一步swap, 这一步不swap
            if (nums1[i] > nums2[i-1] && nums2[i] > nums1[i-1]) {
                noSwapMin = Math.min(noSwapMin,dp[i-1][1]);
            }
            dp[i][0] = noSwapMin;
            int swapMin = Integer.MAX_VALUE;
            // 1. 前一步不swap，这一步swap
            // 满足条件
            if (nums1[i] > nums2[i-1] && nums2[i] > nums1[i-1]) {
                swapMin = Math.min(swapMin,dp[i-1][0]+1);
            }
            // 2. 前一步swap, 这一步swap
            if (nums1[i] > nums1[i-1] && nums2[i] > nums2[i-1]) {
                swapMin = Math.min(swapMin,dp[i-1][1]+1);
            }
            dp[i][1] = swapMin;
        }
        return Math.min(dp[length-1][0],dp[length-1][1]);
    }

    public static void main(String[] args) {
        MinSwap minSwap = new MinSwap();
        System.out.println(1 == minSwap.minSwap(new int[]{0,3,5,8,9}, new int[]{2,1,4,6,9}));
        System.out.println(1 == minSwap.minSwap(new int[]{1,3,5,4}, new int[]{1,2,3,7}));
    }
}
