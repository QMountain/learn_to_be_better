package algorithm.leetcode.medium.i;

public class IntegerReplacement {

    public int integerReplacement(int n) {
        int ans = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                ++ans;
                n /= 2;
            } else if (n % 4 == 1) {
                ans += 2;
                n /= 2;
            } else {
                if (n == 3) {
                    ans += 2;
                    n = 1;
                } else {
                    ans += 2;
                    n = n / 2 + 1;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        IntegerReplacement integerReplacement = new IntegerReplacement();
        System.out.println(17 == integerReplacement.integerReplacement(65535));
        System.out.println(32 == integerReplacement.integerReplacement(2147483647));
        System.out.println(31 == integerReplacement.integerReplacement(100000000));
        System.out.println(2 == integerReplacement.integerReplacement(3));
        System.out.println(2 == integerReplacement.integerReplacement(4));
        System.out.println(4 == integerReplacement.integerReplacement(7));
        System.out.println(3 == integerReplacement.integerReplacement(8));

    }
}
