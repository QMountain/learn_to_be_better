package algorithm.leetcode.easy.f;

public class FindIndices {

    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int[] ans = new int[2];
        int length = nums.length;
        for (int i = 0; i < length - indexDifference; i++) {
            for (int j = i + indexDifference; j < length; j++) {
                if (Math.abs(nums[i] - nums[j]) >= valueDifference) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        ans[0] = -1;
        ans[1] = -1;
        return ans;
    }

}
