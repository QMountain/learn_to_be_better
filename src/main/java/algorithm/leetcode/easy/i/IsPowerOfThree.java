package algorithm.leetcode.easy.i;

public class IsPowerOfThree {

    public boolean isPowerOfThree(int n) {
        if (n == 1) {
            return true;
        }
        if (n < 3) {
            return false;
        }
        if (n % 3 != 0) {
            return false;
        }
        return isPowerOfThree(n/3);
    }

    public static void main(String[] args) {
        IsPowerOfThree isPowerOfThree = new IsPowerOfThree();
        System.out.println(isPowerOfThree.isPowerOfThree(27));
        System.out.println(isPowerOfThree.isPowerOfThree(0));
        System.out.println(isPowerOfThree.isPowerOfThree(9));
        System.out.println(isPowerOfThree.isPowerOfThree(45));
    }
}
