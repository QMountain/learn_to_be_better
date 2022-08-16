package algorithm.leetcode.medium.t;

import java.util.Arrays;

public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        int length = numbers.length;
        int[] ans = new int[2];
        for (int i = 0; i < length; i++) {
            int index = binarySearchIndex(numbers, target - numbers[i],i+1,length-1);
            if (index != -1) {
                ans[0] = i+1;
                ans[1] = index+1;
                return ans;
            }
        }
        return ans;
    }

    public int binarySearchIndex(int[] numbers, int target, int left, int right) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (numbers[mid] == target) {
                return mid;
            } else if (numbers[mid] > target) {
                right = mid;
            } else {
                if (left < mid) {
                    left = mid;
                } else {
                    left++;
                }
            }
        }
        return numbers[left] == target ? left : -1;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{1,2,3,4,4,9,56,90}, 8)));
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{-1,0}, -1)));
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{2,3,4}, 6)));
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{2,7,11,15}, 9)));
    }
}
