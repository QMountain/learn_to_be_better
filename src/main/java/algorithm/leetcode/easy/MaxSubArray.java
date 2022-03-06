package algorithm.leetcode.easy;

public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }

        int maxElement = Math.max(nums[0],nums[length-1]);
        int leftIndex = 0;
        int rightIndex = length-1;

        while (leftIndex <= rightIndex) {
            if (nums[leftIndex] <= 0) {
                leftIndex++;
            }
            if (nums[rightIndex] <= 0) {
                rightIndex--;
            }
            leftIndex++;
            rightIndex--;
        }
        return Math.max(0,maxElement);
    }

    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        System.out.println(6 == maxSubArray.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(1 == maxSubArray.maxSubArray(new int[]{1}));
        System.out.println(23 == maxSubArray.maxSubArray(new int[]{5,4,-1,7,8}));
    }
}
