package algorithm.leetcode.easy.m;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinimumOperations {

    /**
     * 给你一个整数数组 nums，你需要确保数组中的元素 互不相同 。为此，你可以执行以下操作任意次：
     * 从数组的开头移除 3 个元素。如果数组中元素少于 3 个，则移除所有剩余元素。
     * 注意：空数组也视作为数组元素互不相同。返回使数组元素互不相同所需的 最少操作次数 。
     */
    public int minimumOperations(int[] nums) {
        int length = nums.length;
        int remain = length % 3;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < remain; i++) {
            if (!set.add(nums[length-1-i])) {
                return (length / 3) + 1;
            }
        }
        for (int i = nums.length-1-remain; i >= 0; i-=3) {
            for (int j = 0; j < 3; j++) {
                if (!set.add(nums[i-j])) {
                    return (i + 1) / 3;
                }
            }
        }
        return 0;
    }

    public int minimumOperations2(int[] nums) {
        Arrays.sort(nums);
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                index = i;
                break;
            }
        }
        if (index == nums.length-1) {
            if (nums[nums.length-1] == 0) {
                return 0;
            }
            return 1;
        }
        int ans = 0;
        while (index < nums.length && nums[index] > 0) {
            int cut = nums[index];
            int nIndex = 0;
            for (int i = nums.length-1; i >= index; i--) {
                if (nums[i] > cut) {
                    nIndex = i;
                }
                nums[i] -= cut;
            }
            index = nIndex;
            ans++;
        }
        return ans;
    }

    public int minimumOperations3(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int cut = 0;
        for (int num : nums) {
            if (num > cut) {
                cut = num;
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MinimumOperations minimumOperations = new MinimumOperations();
        System.out.println(2 == minimumOperations.minimumOperations(
                new int[]{1, 2, 3, 4, 2, 3, 3, 5, 7}));
        System.out.println(2 == minimumOperations.minimumOperations(
                new int[]{4,5,6,4,4}));
        System.out.println(0 == minimumOperations.minimumOperations(
                new int[]{6,7,8,9}));



        System.out.println(0 == minimumOperations.minimumOperations(new int[]{0}));
        System.out.println(3 == minimumOperations.minimumOperations(new int[]{1,5,0,3,5}));
    }
}
