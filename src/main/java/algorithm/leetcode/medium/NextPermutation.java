package algorithm.leetcode.medium;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums == null) {
            return;
        }
        int length = nums.length;
        if (length == 0) {
            return;
        }
        boolean decrease = true;
        int max = nums[length-1];
        for (int i = 0; i < length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < nums[i+1]) {
                decrease = false;
            }
        }
        if (decrease) {
            for (int i = 0; i < length / 2; i++) {
                nums[i] = nums[length-1-i];
            }
            return;
        }
        if (nums[length-1] > nums[length-2]) {
            int temp = nums[length-1];
            nums[length-1] = nums[length-2];
            nums[length-2] = temp;
        } else {

        }


    }

}
