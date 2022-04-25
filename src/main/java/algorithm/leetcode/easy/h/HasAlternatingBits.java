package algorithm.leetcode.easy.h;

public class HasAlternatingBits {

    public boolean hasAlternatingBits(int n) {
        int check;
        if (n % 2 == 0) {
            check = 0;
        } else {
            check = 1;
        }
        while (n > 0) {
            boolean c = check(n, check);
            if (!c) {
                return false;
            }
            check = check == 0 ? 1 : 0;
            if (n % 2 != 0) {
                n = (n-1)/2;

            } else {
                n /= 2;
            }
        }
        return true;
    }

    public boolean check(int n, int check) {
        if (n % 2 == 0 && check == 0) {
            return true;
        }
        return n % 2 == 1 && check == 1;
    }

    public static void main(String[] args) {
        HasAlternatingBits hasAlternatingBits = new HasAlternatingBits();
        System.out.println(hasAlternatingBits.hasAlternatingBits(10));
        System.out.println(hasAlternatingBits.hasAlternatingBits(5));
        System.out.println(hasAlternatingBits.hasAlternatingBits(7));
        System.out.println(hasAlternatingBits.hasAlternatingBits(11));
    }
}
