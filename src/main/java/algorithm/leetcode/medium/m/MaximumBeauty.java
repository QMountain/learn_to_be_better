package algorithm.leetcode.medium.m;

import java.util.Arrays;

public class MaximumBeauty {

    public int maximumBeauty(int[] nums, int k) {
        int m = 0;
        for (int x : nums) {
            m = Math.max(m, x);
        }
        int[] diff = new int[m + 2];
        for (int x : nums) {
            diff[Math.max(x - k, 0)]++;
            diff[Math.min(x + k + 1, m + 1)]--;
        }
        int res = 0, count = 0;
        for (int x : diff) {
            count += x;
            res = Math.max(res, count);
        }
        return res;
    }

    public int maximumBeauty2(int[] nums, int k) {
        Arrays.sort(nums);
        int maxDiff = k << 1;
        int ans = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            int start = nums[i];
            for (int j = i + ans; j < nums.length; j++) {
                int curr = nums[j];
                if (curr - start > maxDiff) {
                    ans = Math.max(ans, j - i);
                    break;
                }
                if (j == nums.length - 1) {
                    ans = Math.max(ans, j - i + 1);
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumBeauty maximumBeauty = new MaximumBeauty();
        System.out.println(4 == maximumBeauty.maximumBeauty(new int[]{1,1,1,1}, 10));
        System.out.println(3 == maximumBeauty.maximumBeauty(new int[]{4,6,1,2}, 2));
    }
}
