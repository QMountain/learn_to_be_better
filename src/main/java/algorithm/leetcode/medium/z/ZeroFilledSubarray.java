package algorithm.leetcode.medium.z;

public class ZeroFilledSubarray {

    /**
     * 1 <= nums.length <= 10^5
     * -10^9 <= nums[i] <= 10^9
     */
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        int start = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (start == -1) {
                    start = i;
                }
                if (i == nums.length - 1) {
                    int count = i - start + 1;
                    ans += (1L + count) * count >> 1;
                }
            } else {
                if (start != -1) {
                    int count = i - start;
                    ans += (1L + count) * count >> 1;
                    start = -1;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ZeroFilledSubarray zeroFilledSubarray = new ZeroFilledSubarray();
        System.out.println(9 == zeroFilledSubarray.zeroFilledSubarray(
                new int[]{0,0,0,2,0,0}));
        System.out.println(6 == zeroFilledSubarray.zeroFilledSubarray(
                new int[]{1,3,0,0,2,0,0,4}));
    }
}
