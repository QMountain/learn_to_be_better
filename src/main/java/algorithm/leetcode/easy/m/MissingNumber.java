package algorithm.leetcode.easy.m;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        int length = nums.length;
        int total = (1+length)*length/2;
        for (int num : nums) {
            total -= num;
        }
        return total;
    }

}
