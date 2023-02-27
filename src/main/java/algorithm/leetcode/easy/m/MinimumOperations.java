package algorithm.leetcode.easy.m;

import java.util.Arrays;

public class MinimumOperations {

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

    public int minimumOperations(int[] nums) {
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
        System.out.println(0 == minimumOperations.minimumOperations(new int[]{0}));
        System.out.println(3 == minimumOperations.minimumOperations(new int[]{1,5,0,3,5}));
    }
}
