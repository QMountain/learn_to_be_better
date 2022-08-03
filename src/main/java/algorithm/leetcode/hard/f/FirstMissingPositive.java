package algorithm.leetcode.hard.f;

public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        System.out.println(2 == firstMissingPositive.firstMissingPositive(new int[]{1,1}));
        System.out.println(1 == firstMissingPositive.firstMissingPositive(new int[]{7,8,9,11,12}));
        System.out.println(2 == firstMissingPositive.firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println(3 == firstMissingPositive.firstMissingPositive(new int[]{1,2,0}));
    }
}
