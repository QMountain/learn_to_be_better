package algorithm.leetcode.easy.g;

public class GetConcatenation {

    public int[] getConcatenation(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length << 1];
        System.arraycopy(nums, 0, ans, 0, length);
        System.arraycopy(nums, 0, ans, length, length);
        return ans;
    }

}
