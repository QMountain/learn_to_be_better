package algorithm.leetcode.easy.b;

public class BitwiseComplement {

    public int bitwiseComplement(int n) {
        if (n == 0) {
            return 1;
        }
        int res = 0;
        int base = 1;
        while (n > 0) {
            if (n % 2 == 0) {
                res += base;
            }
            n /= 2;
            base *= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        BitwiseComplement bitwiseComplement = new BitwiseComplement();
        System.out.println(bitwiseComplement.bitwiseComplement(10));
        System.out.println(bitwiseComplement.bitwiseComplement(7));
        System.out.println(bitwiseComplement.bitwiseComplement(5));
    }
}
