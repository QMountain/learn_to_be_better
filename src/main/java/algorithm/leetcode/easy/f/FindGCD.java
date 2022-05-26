package algorithm.leetcode.easy.f;

public class FindGCD {

    public int findGCD(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        while (max % min != 0) {
            int remain = max % min;
            max = min;
            min = remain;
        }
        return min;
    }

    public static void main(String[] args) {
        FindGCD findGCD = new FindGCD();
        System.out.println(findGCD.findGCD(new int[]{7, 5, 6, 8, 3}));
    }
}
