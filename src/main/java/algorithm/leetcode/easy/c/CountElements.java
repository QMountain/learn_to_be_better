package algorithm.leetcode.easy.c;

public class CountElements {

    public int countElements(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        int count = 0;
        for (int num : nums) {
            if (num < max && num > min) {
                count++;
            }
        }
        return count;
    }

}
