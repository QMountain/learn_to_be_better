package algorithm.leetcode.hard.s;

public class ShortestSubarray {

    public int shortestSubarray(int[] nums, int k) {
        int length = nums.length;
        if (nums[0] >= k) {
            return 1;
        }
        int[] dp = new int[length];
        dp[0] = -1;
        for (int i = 1; i < length; i++) {
            dp[i] = dp[i-1];
            if (nums[i] > 0) {
                int left = 0;
                if (dp[i-1] != -1) {
                    left = i - dp[i-1]+1;
                }
                int sum = 0;
                for (int j = i; j >= left; j--) {
                    sum += nums[j];
                    if (sum >= k) {
                        dp[i] = i - j + 1;
                        break;
                    }
                    if (sum < 0) {
                        break;
                    }
                    if (nums[left] < 0) {
                        left++;
                    }
                }
            }
            if (dp[i] == 1) {
                return 1;
            }
        }
        return dp[length-1];
    }

    public static void main(String[] args) {
        System.out.println(26 & 23);
        ShortestSubarray shortestSubarray = new ShortestSubarray();
        System.out.println(1 == shortestSubarray.shortestSubarray(new int[]{-11,-15,76,41,-41,68,41,12,73,-8}, 50));
        System.out.println(2 == shortestSubarray.shortestSubarray(new int[]{48,99,37,4,-31}, 140));
        System.out.println(-1 == shortestSubarray.shortestSubarray(new int[]{1,2}, 4));
        System.out.println(1 == shortestSubarray.shortestSubarray(new int[]{77,19,35,10,-14}, 19));
        System.out.println(3 == shortestSubarray.shortestSubarray(new int[]{2,-1,2}, 3));

        System.out.println(1 == shortestSubarray.shortestSubarray(new int[]{1}, 1));
    }
}
