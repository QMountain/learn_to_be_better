package algorithm.leetcode.easy;

public class IsPowerOfFour {

    public boolean isPowerOfFour(int n) {
        if (n == 1) {
            return true;
        }
        if (n < 4) {
            return false;
        }
        if (n % 4 != 0) {
            return false;
        }
        return isPowerOfFour(n/4);
    }

    public static void main(String[] args) {
        int i = 4;
        while (i < Integer.MAX_VALUE/4) {
            i *= 4;
        }
        System.out.println(i);
    }
}
