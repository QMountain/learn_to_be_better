package algorithm.leetcode.easy;

import java.util.Arrays;

public class SortArrayByParity {

    public int[] sortArrayByParity(int[] nums) {
        int length = nums.length;
        int lastOddNumberIndex = length-1;
        for (int i = 0; i <= lastOddNumberIndex; i++) {
            if (nums[i] % 2 == 1) {
                for (int j = lastOddNumberIndex; j > i; j--) {
                    if (nums[j] % 2 == 0) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        lastOddNumberIndex = j;
                        break;
                    }
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        SortArrayByParity sortArrayByParity = new SortArrayByParity();
        System.out.println(Arrays.toString(sortArrayByParity.sortArrayByParity(new int[]{3,1,2,4})));
        System.out.println(Arrays.toString(sortArrayByParity.sortArrayByParity(new int[]{0})));
    }
}
