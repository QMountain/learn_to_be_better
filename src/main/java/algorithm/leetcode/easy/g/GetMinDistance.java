package algorithm.leetcode.easy.g;

public class GetMinDistance {

    public int getMinDistance(int[] nums, int target, int start) {
        int length = nums.length;
        int left = start;
        int right = start;
        while (true) {
            if (nums[left] == target) {
                return Math.abs(left-start);
            }
            if (nums[right] == target) {
                return Math.abs(right-start);
            }
            if (left > 0) {
                left--;
            }
            if (right < length-1) {
                right++;
            }
        }
    }

}
