package algorithm.leetcode.easy.m;

public class MinOperations {

    public int minOperations(int[] nums) {
        int ans = 0;
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            if (nums[i] <= nums[i-1]) {
                int shouldBe = nums[i-1]+1;
                ans += shouldBe - nums[i];
                nums[i] = shouldBe;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MinOperations minOperations = new MinOperations();
        System.out.println(minOperations.minOperations(new int[]{1,5,2,4,1}));
    }
}
