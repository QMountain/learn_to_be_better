package algorithm.leetcode.easy;

public class Fib {

    //dp
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int p;
        int q = 0;
        int r = 1;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = r;
            r = p+q;
        }
        return r;
    }

}
