package algorithm.leetcode.medium.c;

import java.util.*;

public class CanPartition {

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int j = target; j >= num; --j) {
                dp[j] |= dp[j - num];
            }
        }
        return dp[target];
    }

    public boolean canPartition2(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return false;
        }
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum/2;
        if (nums[0] == target) {
            return true;
        }
        Set<Integer> set = new HashSet<>();
        set.add(nums[0]);
        for (int i = 1; i < length; i++) {
            if (nums[i] == target) {
                return true;
            }
            Set<Integer> ns = new HashSet<>(set);
            ns.add(nums[i]);
            for (Integer integer : set) {
                int v = integer+nums[i];
                if (v == target) {
                    return true;
                }
                ns.add(v);
            }
            set = ns;
        }
        return false;
    }

    public static void main(String[] args) {
        CanPartition canPartition = new CanPartition();
        System.out.println(canPartition.canPartition(new int[]{4,4,4,4,4,4,4,4,8,8,8,8,8,8,8,8,12,12,12,12,12,12,12,12,16,16,16,16,16,16,16,16,20,20,20,20,20,20,20,20,24,24,24,24,24,24,24,24,28,28,28,28,28,28,28,28,32,32,32,32,32,32,32,32,36,36,36,36,36,36,36,36,40,40,40,40,40,40,40,40,44,44,44,44,44,44,44,44,48,48,48,48,48,48,48,48,52,52,52,52,52,52,52,52,56,56,56,56,56,56,56,56,60,60,60,60,60,60,60,60,64,64,64,64,64,64,64,64,68,68,68,68,68,68,68,68,72,72,72,72,72,72,72,72,76,76,76,76,76,76,76,76,80,80,80,80,80,80,80,80,84,84,84,84,84,84,84,84,88,88,88,88,88,88,88,88,92,92,92,92,92,92,92,92,96,96,96,96,96,96,96,96,97,99}));
        System.out.println(canPartition.canPartition(new int[]{23,13,11,7,6,5,5}));
        System.out.println(!canPartition.canPartition(new int[]{1,3,4,4}));
        System.out.println(canPartition.canPartition(new int[]{2,2,3,5}));
        System.out.println(canPartition.canPartition(new int[]{1,2,3,5}));
        System.out.println(canPartition.canPartition(new int[]{1,5,11,5}));
    }
}
