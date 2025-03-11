package algorithm.leetcode.medium.s;

/**
 * 给你一个下标从 0 开始的整数数组 nums 。
 * 对于每个下标 i（1 <= i <= nums.length - 2），nums[i] 的 美丽值 等于：
 * 2，对于所有 0 <= j < i 且 i < k <= nums.length - 1 ，满足 nums[j] < nums[i] < nums[k]
 * 1，如果满足 nums[i - 1] < nums[i] < nums[i + 1] ，且不满足前面的条件
 * 0，如果上述条件全部不满足
 * 返回符合 1 <= i <= nums.length - 2 的所有 nums[i] 的 美丽值的总和 。
 */
public class SumOfBeauties {

    public int sumOfBeauties(int[] nums) {
        int length = nums.length;
        int[] rightMin = new int[length];
        rightMin[length-2] = nums[length-1];
        for (int i = length-3; i > 0; i--) {
            rightMin[i] = Math.min(rightMin[i+1],nums[i+1]);
        }
        int leftMax = nums[0];
        int ans = 0;
        for (int i = 1; i < length-1; i++) {
            if (nums[i] > leftMax && nums[i] < rightMin[i]) {
                ans += 2;
            } else if (nums[i] > nums[i-1] && nums[i] < nums[i+1]) {
                ans += 1;
            }
            leftMax = Math.max(leftMax, nums[i]);
        }
        return ans;
    }

    public int sumOfBeauties2(int[] nums) {
        int length = nums.length;
        int[] leftMax = new int[length];
        leftMax[1] = nums[0];
        for (int i = 2; i < length; i++) {
            leftMax[i] = Math.max(leftMax[i-1],nums[i-1]);
        }
        int[] rightMin = new int[length];
        rightMin[length-2] = nums[length-1];
        for (int i = length-3; i > 0; i--) {
            rightMin[i] = Math.min(rightMin[i+1],nums[i+1]);
        }
        int ans = 0;
        for (int i = 1; i < length-1; i++) {
            if (nums[i] > leftMax[i] && nums[i] < rightMin[i]) {
                ans += 2;
            } else if (nums[i] > nums[i-1] && nums[i] < nums[i+1]) {
                ans += 1;
            }
        }
        return ans;
    }

}
