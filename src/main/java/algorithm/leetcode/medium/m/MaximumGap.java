package algorithm.leetcode.medium.m;

import java.util.Arrays;

/**
 * 给定一个无序的数组 nums，返回 数组在排序之后，相邻元素之间最大的差值 。
 * 如果数组元素个数小于 2，则返回 0 。
 * 您必须编写一个在「线性时间」内运行并使用「线性额外空间」的算法。
 */
public class MaximumGap {

    // 1 <= nums.length <= 10^5
    // 0 <= nums[i] <= 10^9
    // 官解，基数排序
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        long exp = 1;
        int[] buf = new int[n];
        int maxVal = Arrays.stream(nums).max().getAsInt();

        while (maxVal >= exp) {
            int[] cnt = new int[10];
            for (int i = 0; i < n; i++) {
                int digit = (nums[i] / (int) exp) % 10;
                cnt[digit]++;
            }
            for (int i = 1; i < 10; i++) {
                cnt[i] += cnt[i - 1];
            }
            for (int i = n - 1; i >= 0; i--) {
                int digit = (nums[i] / (int) exp) % 10;
                buf[cnt[digit] - 1] = nums[i];
                cnt[digit]--;
            }
            System.arraycopy(buf, 0, nums, 0, n);
            exp *= 10;
        }

        int ret = 0;
        for (int i = 1; i < n; i++) {
            ret = Math.max(ret, nums[i] - nums[i - 1]);
        }
        return ret;
    }

    public static void main(String[] args) {
        MaximumGap maximumGap = new MaximumGap();
        System.out.println(3 == maximumGap.maximumGap(new int[]{21,4000,8,509,333333}));
        System.out.println(3 == maximumGap.maximumGap(new int[]{2,4,8,5,3}));
        System.out.println(3 == maximumGap.maximumGap(new int[]{3,6,9,1}));
        System.out.println(0 == maximumGap.maximumGap(new int[]{10}));
    }
}
