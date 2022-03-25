package algorithm.leetcode.medium;

public class TrailingZeroes {

    public int trailingZeroes(int n) {
        int ten = n / 10;
        int left = n % 10;
        if (left >= 5) {
            left = 1;
        } else {
            left = 0;
        }
        int i = 1;
        int pow = 0;
        while (i < n) {
            i *= 5;
            pow++;
            if (i >= n) {
                pow--;
            }
        }
        int cover = 0;
        for (int j = 1; j < pow; j++) {
            cover += j;
        }
        return ten*2+left+cover;
    }

    public static void main(String[] args) {
        TrailingZeroes trailingZeroes = new TrailingZeroes();
        System.out.println(trailingZeroes.trailingZeroes(50));
        System.out.println(trailingZeroes.trailingZeroes(30));
    }
}
