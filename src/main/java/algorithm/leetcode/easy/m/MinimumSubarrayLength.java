package algorithm.leetcode.easy.m;

public class MinimumSubarrayLength {

    public int minimumSubarrayLength(int[] nums, int k) {
        int length = nums.length;
        int ans = -1;
        for (int i = 0; i < length; i++) {
            if (nums[i] >= k) {
                return 1;
            }
            int cal = nums[i];
            for (int j = i+1; j < length; j++) {
                if (j - i + 1 >= ans && ans != -1) {
                    break;
                }
                cal |= nums[j];
                if (cal >= k) {
                    if (ans == -1) {
                        ans = j - i + 1;
                    } else {
                        ans = Math.min(ans, j - i + 1);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MinimumSubarrayLength minimumSubarrayLength = new MinimumSubarrayLength();
        System.out.println(4 == minimumSubarrayLength.minimumSubarrayLength(
                new int[]{32, 1, 25, 11, 2}, 59));
    }
}
