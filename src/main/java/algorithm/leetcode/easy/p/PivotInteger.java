package algorithm.leetcode.easy.p;

public class PivotInteger {

    // 1 <= n <= 1000
    public int pivotInteger(int n) {
        int i = n * (n + 1) / 2;
        int sqrt = (int)Math.sqrt(i);
        if (sqrt * sqrt == i) {
            return sqrt;
        }
        return -1;
    }

}
