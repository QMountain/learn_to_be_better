package algorithm.leetcode.medium.m;

public class MaxProduct {

    public int maxProduct(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        if (nums[0] == 0) {
            int[] arr = new int[length-1];
            System.arraycopy(nums,1,arr,0,length-1);
            int i = maxProduct(arr);
            return Math.max(i,0);
        }
        for (int i = 1; i < length; i++) {
            if (nums[i] == 0) {
                int[] arr1 = new int[i];
                System.arraycopy(nums,0,arr1,0,i);
                int maxProduct1 = maxProduct(arr1);
                int[] arr2 = new int[length-i-1];
                System.arraycopy(nums,i+1,arr2,0,length-i-1);
                if (arr2.length > 0) {
                    int maxProduct2 = maxProduct(arr2);
                    maxProduct1 = Math.max(maxProduct1,maxProduct2);
                }
                return Math.max(maxProduct1,0);
            }
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        int countNegative;
        if (nums[0] < 0) {
            countNegative = 1;
        } else {
            countNegative = 0;
        }
        for (int i = 1; i < length; i++) {
            int num = nums[i];
            if (num < 0) {
                countNegative++;
            }
            dp[i] = dp[i-1]*num;
        }

        if (countNegative % 2 == 0) {
            return dp[length-1];
        }
        int max = dp[length-1];
        if (nums[0] < 0) {
            max = Math.max(dp[length-1]/nums[0],max);
        }
        for (int i = 1; i < length;i++) {
            if (nums[i] < 0) {
                max = Math.max(dp[i-1],max);
                max = Math.max(dp[length-1]/dp[i],max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaxProduct maxProduct = new MaxProduct();
        System.out.println(maxProduct.maxProduct(new int[]{-2,0}));
        System.out.println(maxProduct.maxProduct(new int[]{-3,-1,-1}));
        System.out.println(maxProduct.maxProduct(new int[]{0,2}));
        System.out.println(maxProduct.maxProduct(new int[]{-2}));
        System.out.println(maxProduct.maxProduct(new int[]{-2, 0, -1}));
    }
}
