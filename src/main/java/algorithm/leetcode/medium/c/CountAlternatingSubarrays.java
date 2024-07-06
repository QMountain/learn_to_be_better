package algorithm.leetcode.medium.c;

public class CountAlternatingSubarrays {

    // 1 <= nums.length <= 10^5
    // nums[i] 不是 0 就是 1
    public long countAlternatingSubarrays(int[] nums) {
        int length = nums.length;
        long ans = 0;
        for (int i = 0; i < length; i++) {
            ans++;
            for (int j = i + 1; j < length; j++) {
                if (nums[j] == nums[j-1]) {
                    ans += (long) (j - i + 1) * (j - i) >> 1;
                    ans--;
                    i = j - 1;
                    break;
                } else if (j == length - 1) {
                    ans += (long) (j - i + 2) * (j - i + 1) >> 1;
                    ans--;
                    i = j;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        CountAlternatingSubarrays countAlternatingSubarrays = new CountAlternatingSubarrays();
        System.out.println(10 == countAlternatingSubarrays.countAlternatingSubarrays(
                new int[]{1,0,1,0}));
        System.out.println(5 == countAlternatingSubarrays.countAlternatingSubarrays(
                new int[]{0,1,1,1}));
    }
}
