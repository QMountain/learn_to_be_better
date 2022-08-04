package algorithm.leetcode.easy.c;

public class Check {

    public boolean check(int[] nums) {
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            if (nums[i] < nums[i-1]) {
                if (nums[0] < nums[length-1]) {
                    return false;
                }
                for (int j = i+1; j < length; j++) {
                    if (nums[j] < nums[j-1]) {
                        return false;
                    }
                }
                return true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Check check = new Check();
        System.out.println(check.check(new int[]{3,6,10,1,8,9,9,8,9}));
        System.out.println(check.check(new int[]{1,2,3}));
        System.out.println(check.check(new int[]{2,1,3,4}));
        System.out.println(check.check(new int[]{3,4,5,1,2}));
    }
}
