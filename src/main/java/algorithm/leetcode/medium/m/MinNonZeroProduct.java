package algorithm.leetcode.medium.m;

public class MinNonZeroProduct {

    // 1 <= p <= 60
    public int minNonZeroProduct(int p) {
        if (p == 1) {
            return 1;
        }
        if (p == 2) {
            return 6;
        }
        long times = 1;
        for (int i = 0; i < p; i++) {
            times <<= 1;
        }
        long base = times -= 2;
        base %= 10000_00007;
        times >>= 1;
        long ans = base;
        long suffix = 1;
        while (times > 1) {
            if (times % 2 != 0) {
                suffix *= ans;
                suffix %= 10000_00007;
            }
            ans *= ans;
            ans %= 10000_00007;
            times >>= 1;
        }
        ans *= suffix;
        ans %= 10000_00007;
        ans *= base + 1;
        ans %= 10000_00007;
        return (int) ans;
    }

    public static void main(String[] args) {
        MinNonZeroProduct minNonZeroProduct = new MinNonZeroProduct();
        System.out.println(1 == minNonZeroProduct.minNonZeroProduct(1));
        System.out.println(6 == minNonZeroProduct.minNonZeroProduct(2));
        System.out.println(1512 == minNonZeroProduct.minNonZeroProduct(3));
        System.out.println(minNonZeroProduct.minNonZeroProduct(4));
        System.out.println(26450314 == minNonZeroProduct.minNonZeroProduct(29));
    }
}
