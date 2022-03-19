package algorithm.leetcode.easy;

public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        if (length == 1) {
            if (nums[0] >= target) {
                return 0;
            }
            return 1;
        }
        if (target <= nums[0]) {
            return 0;
        }
        if (target > nums[length-1]) {
            return length;
        }
        int startIndex = 0;
        int endIndex = length-1;
        while (endIndex > startIndex) {
            if (endIndex - startIndex == 1) {
                if (nums[startIndex] == target) {
                    return startIndex;
                }
                if (nums[endIndex] == target) {
                    return endIndex;
                }
                return endIndex;
            } else {
                int midIndex = startIndex+(endIndex-startIndex)/2;
                if (nums[midIndex] == target) {
                    return midIndex;
                } else if (nums[midIndex] < target) {
                    startIndex = midIndex;
                } else {
                    endIndex = midIndex;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        SearchInsert searchInsert = new SearchInsert();
        System.out.println(2 == searchInsert.searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(1 == searchInsert.searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(4 == searchInsert.searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(0 == searchInsert.searchInsert(new int[]{1, 3, 5, 6}, 0));
    }
}
