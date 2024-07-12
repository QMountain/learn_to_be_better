package algorithm.leetcode.medium.c;

public class CanSortArray {

    // 1 <= nums.length <= 100
    // 1 <= nums[i] <= 2^8
    public boolean canSortArray(int[] nums) {
        int preCount = 0;
        int preMax = 0;
        int currSegMax = 0;
        for (int num : nums) {
            int bitCount = Integer.bitCount(num);
            if (bitCount == preCount) {
                if (num < preMax) {
                    return false;
                }
                currSegMax = Math.max(currSegMax, num);
            } else {
                preMax = currSegMax;
                if (num < preMax) {
                    return false;
                }
                currSegMax = num;
                preCount = bitCount;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CanSortArray canSortArray = new CanSortArray();
        System.out.println(canSortArray.canSortArray(new int[]{3,16,8,4,2}));
        System.out.println(canSortArray.canSortArray(new int[]{1,2,3,4,5}));
        System.out.println(canSortArray.canSortArray(new int[]{8,4,2,30,15}));
    }
}
