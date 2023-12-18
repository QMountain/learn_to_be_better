package algorithm.leetcode.medium.m;

public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        int startIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                if (startIndex == -1) {
                    startIndex = i;
                    sum += nums[i];
                } else {
                    if (sum > 0) {
                        nums[i] += sum;
                    }
                    sum = nums[i];
                }
            } else {
                if (startIndex != -1) {
                    sum += nums[i];
                }
            }
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        int length = nums.length;
        int max = nums[0];
        for (int i = 1; i < length; i++) {
            max = Math.max(max, nums[i]);
        }
        if (max <= 0) {
            return max;
        }
        int left = 0;
        int right = length - 1;
        while (nums[left] <= 0) {
            left++;
        }
        while (nums[right] <= 0) {
            right--;
        }
        while (left < right) {
            int sumLeft = nums[left];
            for (int i = left+1; i <= right; i++) {
                if (nums[i] > 0) {
                    if (sumLeft > 0) {
                        nums[i] += sumLeft;
                        max = Math.max(max, nums[i]);
                    }
                    left = i;
                    break;
                }
                sumLeft += nums[i];
            }

            int sumRight = nums[right];
            for (int i = right-1; i >= left; i--) {
                if (nums[i] > 0) {
                    if (sumRight > 0) {
                        nums[i] += sumRight;
                        max = Math.max(max, nums[i]);
                    }
                    right = i;
                    break;
                }
                sumRight += nums[i];
            }
            if (left + 1 == right) {
                return Math.max(nums[left] + nums[right], max);
            }
        }
        return Math.max(nums[left], max);
    }

    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        System.out.println(3 == maxSubArray.maxSubArray(new int[]{-1,-2,3,-1,-2,1,1}));
        System.out.println(5 == maxSubArray.maxSubArray(new int[]{3,2,-2,1}));
        System.out.println(2 == maxSubArray.maxSubArray(new int[]{-3,1,-2,2}));
        System.out.println(5 == maxSubArray.maxSubArray(new int[]{3,2,-3,-1,1,-3,1,-1}));
        System.out.println(3 == maxSubArray.maxSubArray(new int[]{3,-3,2,-3}));
        System.out.println(1 == maxSubArray.maxSubArray(new int[]{1,0,0,0}));
        System.out.println(23 == maxSubArray.maxSubArray(new int[]{5,4,-1,7,8}));
        System.out.println(1 == maxSubArray.maxSubArray(new int[]{1}));
        System.out.println(6 == maxSubArray.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
