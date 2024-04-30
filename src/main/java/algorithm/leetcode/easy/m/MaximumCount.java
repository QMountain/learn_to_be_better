package algorithm.leetcode.easy.m;

public class MaximumCount {

    // 1 <= nums.length <= 2000
    public int maximumCount(int[] nums) {
        if (nums[0] > 0 || nums[nums.length-1] < 0) {
            return nums.length;
        }
        int maxNegIndex = -1;
        if (nums[0] < 0) {
            int left = 0;
            int right = nums.length-1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (nums[mid] >= 0) {
                    right = mid;
                } else {
                    if (left < mid) {
                        left = mid;
                    } else {
                        if (nums[right] < 0) {
                            maxNegIndex = right;
                        } else {
                            maxNegIndex = left;
                        }
                        break;
                    }
                }
            }
        }
        int minPosIndex = nums.length;
        if (nums[nums.length-1] > 0) {
            int left = 0;
            int right = nums.length-1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (nums[mid] > 0) {
                    right = mid;
                } else {
                    if (left < mid) {
                        left = mid;
                    } else {
                        minPosIndex = right;
                        break;
                    }
                }
            }
        }
        int pos = nums.length - minPosIndex;
        int neg = maxNegIndex + 1;
        return Math.max(pos, neg);
    }

    public static void main(String[] args) {
        MaximumCount maximumCount = new MaximumCount();
        System.out.println(maximumCount.maximumCount(new int[]{-3, -2, -1, 0, 0, 1, 2}));
    }
}
