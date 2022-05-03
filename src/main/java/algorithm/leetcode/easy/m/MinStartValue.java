package algorithm.leetcode.easy.m;

public class MinStartValue {

    public int minStartValue(int[] nums) {
        int length = nums.length;
        int[] diff = new int[length];
        diff[0] = nums[0];
        for (int i = 1; i < length; i++) {
            diff[i] = diff[i-1] + nums[i];
        }
        int min = diff[0];
        for (int i = 1; i < length; i++) {
            if (diff[i] < min) {
                min = diff[i];
            }
        }
        return 1-min <= 0 ? 1 : 1-min;
    }

}
