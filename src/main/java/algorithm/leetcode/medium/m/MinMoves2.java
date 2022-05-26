package algorithm.leetcode.medium.m;

import java.util.Arrays;

public class MinMoves2 {

    public int minMoves2(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return 0;
        }
        Arrays.sort(nums);

        int[] dp = new int[length];
        dp[0] = nums[0];
        for (int i = 1; i < length; i++) {
            dp[i] = dp[i-1]+nums[i];
        }
        long min = Integer.MAX_VALUE;
        for (int i = 0; i < length-1; i++) {
            long sumRight = dp[length-1]-dp[i];
            long sumLeft = dp[i];
            long count = sumRight-sumLeft;
            int countLeft = i+1;
            int countRight = length-countLeft;
            if (countLeft == countRight) {
                min = Math.min(min,count);
            } else if (countLeft < countRight) {
                long countX = countRight-countLeft;
                long maxX = nums[i+1];
                min = Math.min(count- countX *maxX,min);
            } else {
                long countX = countLeft-countRight;
                long minX = nums[i];
                min = Math.min(count+countX*minX,min);
            }
        }

        return Integer.parseInt(String.valueOf(min));
    }

    public static void main(String[] args) {
        MinMoves2 minMoves2 = new MinMoves2();
        System.out.println(minMoves2.minMoves2(new int[]{203125577,-349566234,230332704,48321315,66379082,386516853,50986744,-250908656,-425653504,-212123143}));
        System.out.println(minMoves2.minMoves2(new int[]{1, 10, 2,9}));
        System.out.println(minMoves2.minMoves2(new int[]{1, 1, 2}));
    }
}
