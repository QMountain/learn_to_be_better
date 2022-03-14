package algorithm.leetcode.medium;

import java.util.Arrays;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int length = nums.length;
        boolean needReverse = true;
        for (int i = length-1; i > 0; i--) {
            if (nums[i] > nums[i-1]) {
                needReverse = false;
                for (int j = length-1; j >= i; j--) {
                    if (nums[j] > nums[i-1]) {
                        int temp = nums[i-1];
                        nums[i-1] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                }
                for (int j = 0; j <= (length - 1 - i) / 2; j++) {
                    int temp = nums[i+j];
                    nums[i+j] = nums[length-1-j];
                    nums[length-1-j] = temp;
                }
                for (int j = i; j < length-2; j++) {
                    if (nums[j] > nums[j+1]) {
                        int temp = nums[j];
                        nums[j] = nums[j+1];
                        nums[j+1] = temp;
                    }
                }
                break;
            }
        }
        if (needReverse) {
            for (int i = 0; i < length / 2; i++) {
                int temp = nums[i];
                nums[i] = nums[length-1-i];
                nums[length-1-i] = temp;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(new int[]{1,2,3});
        nextPermutation.nextPermutation(new int[]{3,2,1});
        nextPermutation.nextPermutation(new int[]{1,1,5});
        nextPermutation.nextPermutation(new int[]{1,3,2});
        nextPermutation.nextPermutation(new int[]{2,3,1});
    }
}
