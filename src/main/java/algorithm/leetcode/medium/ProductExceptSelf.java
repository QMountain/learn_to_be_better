package algorithm.leetcode.medium;

import java.util.Arrays;

public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] left = new int[length];
        left[0] = 1;
        for (int i = 1; i < length; i++) {
            left[i] = left[i-1] * nums[i-1];
        }
        int[] right = new int[length];
        right[length-1] = 1;
        for (int i = length-2; i >= 0; i--) {
            right[i] = right[i+1] * nums[i+1];
        }
        nums[0] = right[0];
        nums[length-1] = left[length-1];
        for (int i = 1; i < length-1; i++) {
            nums[i] = left[i] * right[i];
        }
        return nums;
    }

    public static void main(String[] args) {
        ProductExceptSelf productExceptSelf = new ProductExceptSelf();
        System.out.println(Arrays.toString(
                productExceptSelf.productExceptSelf(new int[]{1, 2, 3, 4})));
    }
}
