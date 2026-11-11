package algorithm.leetcode.easy.l;

public class LongestMonotonicSubarray {

    /**
     * 3105. 最长的严格递增或递减子数组
     * 1 <= nums.length <= 50
     * 1 <= nums[i] <= 50
     */
    public int longestMonotonicSubarray(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return 1;
        }
        int max = 1;
        int state = 0;
        int count = 1;
        for (int i = 1; i < length; i++) {
            if (nums[i] == nums[i - 1]) {
                state = 0;
                max = Math.max(count, max);
                count = 1;
            } else if (nums[i] > nums[i - 1]) {
                if (state >= 0) {
                    state = 1;
                    count++;
                    max = Math.max(count, max);
                } else {
                    state = 1;
                    count = 2;
                }
            } else {
                if (state <= 0) {
                    state = -1;
                    count++;
                    max = Math.max(count, max);
                } else {
                    state = -1;
                    count = 2;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestMonotonicSubarray longestMonotonicSubarray = new LongestMonotonicSubarray();
        System.out.println(3 == longestMonotonicSubarray.longestMonotonicSubarray(
                new int[]{2,1,2,4}));
        System.out.println(3 == longestMonotonicSubarray.longestMonotonicSubarray(
                new int[]{1,9,7,1}));
        System.out.println(3 == longestMonotonicSubarray.longestMonotonicSubarray(
                new int[]{3,2,1}));
        System.out.println(1 == longestMonotonicSubarray.longestMonotonicSubarray(
                new int[]{3,3,3,3}));
        System.out.println(2 == longestMonotonicSubarray.longestMonotonicSubarray(
                new int[]{1,4,3,3,2}));
    }
}
