package algorithm.leetcode.medium.i;

public class IntegerBreak {

    public int integerBreak(int n) {
        if (n < 4) {
            return n-1;
        }
        int ans = 1;
        while (n > 3) {
            int remain = n % 3;
            if (remain == 1) {
                ans *= 4;
                n -= 4;
            } else if (remain == 2){
                ans *= 2;
                n -= 2;
            } else {
                ans *= 3;
                n -= 3;
            }
        }
        if (n != 0) {
            return ans*n;
        }
        return ans;
    }

    public static void main(String[] args) {
        IntegerBreak integerBreak = new IntegerBreak();
        System.out.println(18 == integerBreak.integerBreak(8));
        System.out.println(36 == integerBreak.integerBreak(10));
        System.out.println(1 == integerBreak.integerBreak(2));
    }
}
