package algorithm.leetcode.medium.w;

import java.util.Arrays;

public class WiggleSort {

    public void wiggleSort(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int length = nums.length;
        int average = sum / length;
        int biggerIndex = length % 2 == 0 ? length-1 : length-2;
        for (int smallerIndex = 0; smallerIndex < length;) {
            if (nums[smallerIndex] <= average) {
                smallerIndex += 2;
                continue;
            }
            if (nums[biggerIndex] >= average) {
                biggerIndex -= 2;
                continue;
            }
            int temp = nums[smallerIndex];
            nums[smallerIndex] = nums[biggerIndex];
            nums[biggerIndex] = temp;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        WiggleSort wiggleSort = new WiggleSort();
        wiggleSort.wiggleSort(new int[]{1,3,2,2,3,1});
        wiggleSort.wiggleSort(new int[]{1,5,1,1,6,4});
    }
}
