package algorithm.leetcode.easy;

import java.util.Arrays;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        int length = digits.length;
        int index = length-1;
        boolean needMore = false;
        while (index >= 0) {
            if (digits[index] < 9) {
                digits[index] += 1;
                return digits;
            }
            if (index <= 0 && digits[0] == 9) {
                needMore = true;
                digits[0] = 0;
                break;
            }
            digits[index] = 0;
            index--;
        }
        if (needMore) {
            int[] arr = new int[length+1];
            arr[0] = 1;
            System.arraycopy(digits,0,arr,1,length);
            return arr;
        }

        return digits;
    }

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        System.out.println(Arrays.toString(plusOne.plusOne(new int[]{1,2,3})));
        System.out.println(Arrays.toString(plusOne.plusOne(new int[]{4,3,2,1})));
        System.out.println(Arrays.toString(plusOne.plusOne(new int[]{0})));
        System.out.println(Arrays.toString(plusOne.plusOne(new int[]{9})));
        System.out.println(Arrays.toString(plusOne.plusOne(new int[]{9,9,9})));
    }
}
