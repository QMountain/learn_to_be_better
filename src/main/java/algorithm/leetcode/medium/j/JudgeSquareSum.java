package algorithm.leetcode.medium.j;

import java.util.Set;
import java.util.TreeSet;

public class JudgeSquareSum {

    public boolean judgeSquareSum(int c) {
        for (long i = 0; i <= c; i++) {
            long a = i * i;
            if (a > c) {
                return false;
            }
            if (a == c) {
                return true;
            }
            long b = c - a;
            int sqrt = (int) Math.sqrt(b);
            if (b == (long) sqrt * sqrt) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        JudgeSquareSum judgeSquareSum = new JudgeSquareSum();
        System.out.println(judgeSquareSum.judgeSquareSum(2147482647));
        System.out.println(judgeSquareSum.judgeSquareSum(58));
        System.out.println(!judgeSquareSum.judgeSquareSum(999999999));
        System.out.println(judgeSquareSum.judgeSquareSum(5));
        System.out.println(!judgeSquareSum.judgeSquareSum(3));
    }
}
