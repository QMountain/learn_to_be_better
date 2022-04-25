package algorithm.leetcode.easy.i;

public class IsUgly {

    public boolean isUgly(int n) {
        if (n < 0) {
            return false;
        }
        if (n <= 3 || n == 5) {
            return true;
        }
        if (n % 5 != 0 && n % 3 != 0 && n % 2 != 0) {
            return false;
        }
        if (n % 5 == 0) {
            return isUgly(n/5);
        }
        if (n % 3 == 0) {
            return isUgly(n/3);
        }
        return isUgly(n/2);
    }

    public static void main(String[] args) {
        IsUgly isUgly = new IsUgly();
        System.out.println(isUgly.isUgly(-2147483648));
        System.out.println(isUgly.isUgly(6));
        System.out.println(isUgly.isUgly(1));
        System.out.println(isUgly.isUgly(14));
    }
}
