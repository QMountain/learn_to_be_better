package algorithm.leetcode.easy.m;

public class MaxSum {

    /**
     * 3487. 删除后的最大子数组元素和
     * 1 <= nums.length <= 100
     * -100 <= nums[i] <= 100
     */
    public int maxSum(int[] nums) {
        int[] arr = new int[100];
        int ans = 0;
        int maxMinus = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num <= 0) {
                maxMinus = Math.max(maxMinus, num);
            } else {
                if (arr[num-1] == 0) {
                    arr[num-1] = 1;
                    ans += num;
                }
            }
        }
        return ans == 0 ? maxMinus : ans;
    }

}
