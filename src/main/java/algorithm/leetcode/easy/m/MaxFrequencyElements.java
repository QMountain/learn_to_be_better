package algorithm.leetcode.easy.m;

public class MaxFrequencyElements {

    /**
     * 1 <= nums.length <= 100
     * 1 <= nums[i] <= 100
     */
    public int maxFrequencyElements(int[] nums) {
        int ans = 0;
        int maxFrequency = 0;
        int[] count = new int[100];
        for (int num : nums) {
            int frequency = ++count[num - 1];
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                ans = maxFrequency;
            } else if (frequency == maxFrequency) {
                ans += frequency;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxFrequencyElements maxFrequencyElements = new MaxFrequencyElements();
        System.out.println(5 == maxFrequencyElements.maxFrequencyElements(
                new int[]{1,2,3,4,5}));
        System.out.println(4 == maxFrequencyElements.maxFrequencyElements(
                new int[]{1,2,2,3,1,4}));
    }
}
