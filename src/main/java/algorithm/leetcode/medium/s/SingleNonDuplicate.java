package algorithm.leetcode.medium.s;

public class SingleNonDuplicate {

    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (mid % 2 == 0) {
                if (nums[mid] == nums[mid+1]) {
                    left = mid;
                } else {
                    right = mid;
                }
            } else {
                if (nums[mid] == nums[mid+1]) {
                    right = mid;
                } else {
                    if (left + 1 == right) {
                        if (left % 2 == 1) {
                            return nums[right];
                        }
                        return nums[left];
                    }
                    left = mid;
                }
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        SingleNonDuplicate singleNonDuplicate = new SingleNonDuplicate();
        System.out.println(10 == singleNonDuplicate.singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));
        System.out.println(2 == singleNonDuplicate.singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
    }
}
