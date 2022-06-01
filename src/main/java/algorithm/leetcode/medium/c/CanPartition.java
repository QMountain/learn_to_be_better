package algorithm.leetcode.medium.c;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CanPartition {

    public boolean canPartition(int[] nums) {
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
        System.out.println(canPartition.canPartition(new int[]{1,2,3,5}));
        System.out.println(canPartition.canPartition(new int[]{1,5,11,5}));
    }
}
