package algorithm.leetcode.medium.t;

public class TrailingZeroes {

    public int trailingZeroes(int n) {
        int res = 0;
        for (int i = 5; i <= n; i++) {
            int num = i;
            while (num % 5 == 0) {
                res++;
                num = num/5;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TrailingZeroes trailingZeroes = new TrailingZeroes();
        System.out.println(trailingZeroes.trailingZeroes(50));
        System.out.println(trailingZeroes.trailingZeroes(30));
    }
}
