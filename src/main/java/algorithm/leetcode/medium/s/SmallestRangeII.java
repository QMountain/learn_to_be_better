package algorithm.leetcode.medium.s;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;

public class SmallestRangeII {

    // 1 <= nums.length <= 10^4
    // 0 <= nums[i] <= 10^4
    // 0 <= k <= 10^4
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int length = nums.length;
        int ans = nums[length - 1] - nums[0];
        for (int i = 1; i < length; i++) {
            int left = Math.min(nums[i] - k, nums[0] + k);
            int right = Math.max(nums[i-1]+k, nums[length-1] - k);
            ans = Math.min(ans, right - left);
        }
        return ans;
    }

    public static void main(String[] args) {
        SmallestRangeII smallestRangeII = new SmallestRangeII();
        System.out.println(2 == smallestRangeII.smallestRangeII(
                new int[]{3,1,10}, 4));
        System.out.println(6 == smallestRangeII.smallestRangeII(
                new int[]{0,6,10,2,0,7}, 5));
        System.out.println(1 == smallestRangeII.smallestRangeII(
                new int[]{7, 8, 8}, 5));
        System.out.println(3 == smallestRangeII.smallestRangeII(
                new int[]{1, 3, 6}, 3));
        System.out.println(6 == smallestRangeII.smallestRangeII(
                new int[]{0, 10}, 2));
        System.out.println(0 == smallestRangeII.smallestRangeII(
                new int[]{1}, 0));
    }
}
