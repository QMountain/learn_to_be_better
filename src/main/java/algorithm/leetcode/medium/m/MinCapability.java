package algorithm.leetcode.medium.m;

import java.util.Arrays;

public class MinCapability {

    // 1 <= nums.length <= 10^5
    // 1 <= nums[i] <= 10^9
    // 1 <= k <= (nums.length + 1)/2
    public int minCapability(int[] nums, int k) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        if (length == 2) {
            return Math.min(nums[0], nums[1]);
        }
        int[] sort = new int[length];
        System.arraycopy(nums, 0, sort, 0, length);
        Arrays.sort(sort);
        // 最差的情况，大数都在一侧，那么需要 （k-1）*2 + 1 个房子
        // 最好的情况，k 个就够
        int left = k - 1;
        int right = (k - 1) * 2;
        // length 个房子 选 k 个
        // 如果要求隔一个一选，那么最少要跳过 k - 1个房子
        while (left < right) {
            int mid = (left + right) / 2;
            if (canRobK(nums, sort[mid], k)) {
                right = mid;
            } else {
                if (left < mid) {
                    left = mid;
                } else {
                    break;
                }
            }
        }
        return sort[right];
    }

    public boolean canRobK(int[] nums, int max, int k) {
        int dp1 = nums[0] <= max ? 1 : 0;
        int dp2 = Math.min(nums[0], nums[1]) <= max ? 1 : 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > max) {
                dp1 = dp2;
            } else {
                int dp = dp1 + 1;
                dp1 = dp2;
                dp2 = dp;
            }
        }
        return dp2 >= k;
    }

    public static void main(String[] args) {
        MinCapability minCapability = new MinCapability();
        System.out.println(2 == minCapability.minCapability(new int[]{2,7,9,3,1}, 2));
        System.out.println(20 == minCapability.minCapability(new int[]{9,6,20,21,8}, 3));
        System.out.println(5 == minCapability.minCapability(new int[]{7,3,9,5}, 2));

        System.out.println(5 == minCapability.minCapability(new int[]{2, 3, 5, 9}, 2));
    }
}
