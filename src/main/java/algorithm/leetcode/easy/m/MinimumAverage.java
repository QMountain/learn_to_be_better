package algorithm.leetcode.easy.m;

import java.util.Arrays;

public class MinimumAverage {

    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        int max = nums.length >> 1;
        double ans = (nums[0] + nums[nums.length-1]) / 2D;
        for (int i = 1; i < max; i++) {
            ans = Math.min(ans , (nums[i] + nums[nums.length-1-i]) / 2D);
        }
        return ans;
    }

    public static void main(String[] args) {
        MinimumAverage minimumAverage = new MinimumAverage();
        System.out.println(5.5 == minimumAverage.minimumAverage(
                new int[]{7,8,3,4,15,13,4,1}));
    }
}
