package algorithm.leetcode.medium.s;

import java.util.Arrays;

public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int[] resArr = new int[2];
        resArr[0] = -1;
        resArr[1] = -1;

        int length = nums.length;
        if (length == 0) {
            return resArr;
        }
        int leftIndex = getLeftIndex(0,length-1,nums,target);
        if (leftIndex == -1) {
            return resArr;
        }
        resArr[0] = leftIndex;
        int rightIndex = getRightIndex(leftIndex, length - 1, nums, target);
        if (rightIndex == -1) {
            resArr[1] = resArr[0];
        } else {
            resArr[1] = rightIndex;
        }
        return resArr;
    }

    public int getLeftIndex(int leftBound, int rightBound, int[] nums, int target) {
        if (rightBound - 1 == leftBound) {
            if (nums[leftBound] == target) {
                return leftBound;
            }
            if (nums[rightBound] == target) {
                return rightBound;
            }
            return -1;
        }
        int index = leftBound + (rightBound - leftBound) / 2;

        if (index == leftBound || index == rightBound) {
            if (nums[index] == target && (index == 0 || nums[index-1] < target)) {
                return index;
            } else {
                return -1;
            }
        }
        while (true) {
            if (nums[index] == target) {
                if (index == 0 || nums[index-1] < target) {
                    return index;
                } else {
                    return getLeftIndex(leftBound, index, nums, target);
                }
            } else if (nums[index] > target) {
                return getLeftIndex(leftBound, index-1, nums, target);
            } else {
                return getLeftIndex(index+1,rightBound,nums,target);
            }
        }
    }

    public int getRightIndex(int leftBound, int rightBound, int[] nums, int target) {
        if (rightBound - 1 == leftBound) {
            if (nums[rightBound] == target) {
                return rightBound;
            }
            if (nums[leftBound] == target) {
                return leftBound;
            }
            return -1;
        }
        int index = leftBound + (rightBound - leftBound) / 2;
        if (index == leftBound || index == rightBound) {
            if (nums[index] == target && (index == rightBound || nums[index+1] > target)) {
                return index;
            } else {
                return -1;
            }
        }
        while (true) {
            if (nums[index] == target && (index == rightBound || nums[index+1] > target)) {
                return index;
            } else if (nums[index] > target) {
                return getRightIndex(leftBound, index-1, nums, target);
            } else {
                return getRightIndex(index+1,rightBound,nums,target);
            }
        }
    }

    public static void main(String[] args) {
        SearchRange searchRange = new SearchRange();
        System.out.println(Arrays.toString(searchRange.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(searchRange.searchRange(new int[]{5,7,7,8,8,10}, 6)));
        System.out.println(Arrays.toString(searchRange.searchRange(new int[]{}, 0)));
        System.out.println(Arrays.toString(searchRange.searchRange(new int[]{2,2}, 3)));
        System.out.println(Arrays.toString(searchRange.searchRange(new int[]{2,2}, 2)));
        System.out.println(Arrays.toString(searchRange.searchRange(new int[]{3,3,3}, 3)));
        System.out.println(Arrays.toString(searchRange.searchRange(new int[]{0,0,0,1,2,3}, 0)));
        System.out.println(Arrays.toString(searchRange.searchRange(new int[]{0,0,1,1,1,4,5,5}, 2)));
        System.out.println(Arrays.toString(searchRange.searchRange(new int[]{1,3}, 1)));
        System.out.println(Arrays.toString(searchRange.searchRange(new int[]{1,4}, 4)));
    }
}
