package algorithm.leetcode.easy;

public class DominantIndex {

    public int dominantIndex(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return 0;
        }
        int maxIndex = 0;
        int secondMaxIndex = 0;
        if (nums[0] > nums[1]) {
            secondMaxIndex = 1;
        } else {
            maxIndex = 1;
        }
        for (int i = 2; i < length; i++) {
            if (nums[i] >= nums[maxIndex]) {
                secondMaxIndex = maxIndex;
                maxIndex = i;
            } else if (nums[i] >= nums[secondMaxIndex]) {
                secondMaxIndex = i;
            }
        }
        if (nums[secondMaxIndex] == 0) {
            return maxIndex;
        }
        return nums[maxIndex] / nums[secondMaxIndex] >= 2 ? maxIndex : -1;
    }

}
