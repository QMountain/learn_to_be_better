package algorithm.leetcode.medium.p;

public class PredictTheWinner {

    int[] nums;

    public boolean predictTheWinner(int[] nums) {
        this.nums = nums;
        return predictByIndex(0,nums.length-1,0,0);
    }

    public boolean predictByIndex(int left, int right, int sum1, int sum2) {
        if (left > right) {
            return sum1 >= sum2;
        }
        if (left == right) {
            return sum1+nums[left] >= sum2;
        }
        // 1,left 2,left
        boolean ll = predictByIndex(left+2, right, sum1+nums[left], sum2+nums[left+1]);
        // 1,left 2,right
        boolean lr = predictByIndex(left+1, right-1, sum1+nums[left], sum2+nums[right]);
        if (ll && lr) {
            return true;
        }
        // 1,right 2,left
        boolean rl = predictByIndex(left+1, right-1, sum1+nums[right], sum2+nums[left]);
        // 1,right 2,right
        boolean rr = predictByIndex(left, right - 2, sum1 + nums[right], sum2 + nums[right - 1]);
        return rl && rr;
    }

    // 题号486 预测赢家 官解2, dp
    public boolean predictTheWinner2(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        System.arraycopy(nums, 0, dp, 0, length);
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
            }
        }
        return dp[length - 1] >= 0;
    }

    public static void main(String[] args) {
        PredictTheWinner predictTheWinner = new PredictTheWinner();
        System.out.println(predictTheWinner.predictTheWinner(new int[]{1, 5, 233,7}));
        System.out.println(predictTheWinner.predictTheWinner(new int[]{1, 5, 2}));
    }
}
