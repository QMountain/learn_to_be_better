package algorithm.leetcode.easy;

import java.util.Arrays;

public class SortArrayByParityII {

    public int[] sortArrayByParityII(int[] nums) {
        int length = nums.length;
        for (int i = 0,j = 1; i < length && j < length;) {
            if (nums[i] % 2 == 0 && nums[j] % 2 != 0) {
                i += 2;
                j += 2;
            } else if (nums[i] % 2 == 0 && nums[j] % 2 == 0) {
                i += 2;
            } else if (nums[i] % 2 != 0 && nums[j] % 2 != 0) {
                j += 2;
            } else  {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i += 2;
                j += 2;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        SortArrayByParityII sortArrayByParityII = new SortArrayByParityII();
        System.out.println(Arrays.toString(sortArrayByParityII.sortArrayByParityII(new int[]{2,3})));
        System.out.println(Arrays.toString(sortArrayByParityII.sortArrayByParityII(new int[]{4,2,5,7})));
    }
}
