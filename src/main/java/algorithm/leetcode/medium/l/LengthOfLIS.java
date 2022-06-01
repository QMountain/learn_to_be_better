package algorithm.leetcode.medium.l;

public class LengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        LengthOfLIS lengthOfLIS = new LengthOfLIS();
        System.out.println(6 == lengthOfLIS.lengthOfLIS(new int[]{3,5,6,2,5,4,19,5,6,7,12}));
        System.out.println(6 == lengthOfLIS.lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
        System.out.println(3 == lengthOfLIS.lengthOfLIS(new int[]{4,10,4,3,8,9}));
        System.out.println(1 == lengthOfLIS.lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
        System.out.println(4 == lengthOfLIS.lengthOfLIS(new int[]{0,1,0,3,2,3}));
        System.out.println(4 == lengthOfLIS.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
}
