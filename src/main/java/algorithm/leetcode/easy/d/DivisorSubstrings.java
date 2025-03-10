package algorithm.leetcode.easy.d;

public class DivisorSubstrings {

    public int divisorSubstrings(int num, int k) {
        int base = 1;
        for (int i = 0; i < k; i++) {
            base *= 10;
        }
        int copy = num;
        int ans = 0;
        while (copy >= (base / 10)) {
            int divider = copy % base;
            if (divider != 0 && num % divider == 0) {
                ans++;
            }
            copy /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        DivisorSubstrings divisorSubstrings = new DivisorSubstrings();
        System.out.println(2 == divisorSubstrings.divisorSubstrings(430043, 2));
        System.out.println(2 == divisorSubstrings.divisorSubstrings(240, 2));
    }
}
