package algorithm.leetcode.easy.t;

public class Tribonacci {

    public int tribonacci(int n) {
        if (n <= 1) {
            return n;
        }
        if (n == 2) {
            return 1;
        }
        int a = 0;
        int b = 1;
        int c = 1;
        int res = 0;
        for (int i = 3; i <= n; i++) {
            res = a + b + c;
            a = b;
            b = c;
            c = res;
        }
        return res;
    }

}
