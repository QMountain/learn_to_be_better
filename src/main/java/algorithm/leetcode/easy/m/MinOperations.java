package algorithm.leetcode.easy.m;

import java.util.HashSet;
import java.util.Set;

public class MinOperations {

    /**
     * 给你一个整数数组 nums 和一个整数 k 。
     * 如果一个数组中所有 严格大于 h 的整数值都 相等 ，那么我们称整数 h 是 合法的 。
     * 比方说，如果 nums = [10, 8, 10, 8] ，那么 h = 9 是一个 合法 整数，
     * 因为所有满足 nums[i] > 9 的数都等于 10 ，但是 5 不是 合法 整数。
     * 你可以对 nums 执行以下操作：
     * 选择一个整数 h ，它对于 当前 nums 中的值是合法的。
     * 对于每个下标 i ，如果它满足 nums[i] > h ，那么将 nums[i] 变为 h 。
     * 你的目标是将 nums 中的所有元素都变为 k ，请你返回 最少 操作次数。
     * 如果无法将所有元素都变 k ，那么返回 -1 。
     */
    public int minOperations(int[] nums, int k) {
        int min = nums[0];
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
            min = Math.min(min, num);
        }
        if (min < k) {
            return -1;
        }
        if (min == k) {
            return set.size() - 1;
        }
        return set.size();
    }

    public int minOperations(int[] nums) {
        int ans = 0;
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            if (nums[i] <= nums[i-1]) {
                int shouldBe = nums[i-1]+1;
                ans += shouldBe - nums[i];
                nums[i] = shouldBe;
            }
        }
        return ans;
    }

    public int minOperations2(int[] nums, int k) {
        int count = 0;
        for (int num : nums) {
            if (num < k) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MinOperations minOperations = new MinOperations();
        System.out.println(2 == minOperations.minOperations(new int[]{5, 2, 5, 4, 5}, 2));
        System.out.println(-1 == minOperations.minOperations(new int[]{2,1,2}, 2));
        System.out.println(4 == minOperations.minOperations(new int[]{9,7,5,3}, 1));



        System.out.println(minOperations.minOperations(new int[]{1,5,2,4,1}));
    }
}
