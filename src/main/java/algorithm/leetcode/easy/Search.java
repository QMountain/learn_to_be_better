package algorithm.leetcode.easy;

public class Search {

    public int search(int[] nums, int target) {
        int length = nums.length;
        int left = 0;
        int right = length-1;
        while (left < right) {
            if (left == right-1) {
                if (nums[left] == target) {
                    return left;
                }
                if (nums[right] == target) {
                    return right;
                }
                return -1;
            }
            int mid = (right-left)/2+left;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return nums[0] == target ? 0 : -1;
    }

    public static void main(String[] args) {
        Search search = new Search();
        System.out.println(search.search(new int[]{-1,0,3,5,9,12},9));
    }
}
