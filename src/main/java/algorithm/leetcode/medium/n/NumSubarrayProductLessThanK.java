package algorithm.leetcode.medium.n;

public class NumSubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) {
            return 0;
        }
        int res = 0;
        int length = nums.length;
        int product = nums[0];
        int leftIndex = 0;
        int rightIndex = 0;
        while (true) {
            if (product < k && rightIndex < length-1) {
                product *= nums[++rightIndex];
            } else {
                if (rightIndex == length-1) {
                    if (product < k) {
                        res += (rightIndex-leftIndex+2)*(rightIndex-leftIndex+1)/2;
                        break;
                    } else {
                        if (leftIndex < rightIndex) {
                            res += rightIndex-leftIndex;
                            product /= nums[leftIndex++];
                        } else {
                            break;
                        }

                    }

                } else {
                    if (leftIndex < rightIndex) {
                        res += rightIndex-leftIndex;
                        product /= nums[leftIndex++];
                        if (rightIndex == length-1) {
                            break;
                        }
                    } else {
                        leftIndex++;
                        rightIndex++;
                        product = nums[leftIndex];
                    }

                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        NumSubarrayProductLessThanK numSubarrayProductLessThanK = new NumSubarrayProductLessThanK();
        System.out.println(numSubarrayProductLessThanK.numSubarrayProductLessThanK(new int[]{10,2,2,5,4,4,4,3,7,7}, 289));
        System.out.println(numSubarrayProductLessThanK.numSubarrayProductLessThanK(new int[]{1,1,1}, 1));
        System.out.println(numSubarrayProductLessThanK.numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100));
    }
}
