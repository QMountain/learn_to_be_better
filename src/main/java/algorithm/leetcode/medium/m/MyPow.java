package algorithm.leetcode.medium.m;

public class MyPow {

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0d;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1/x;
        }
        if (x == 0) {
            return 0d;
        }
        if (x == 1) {
            return 1d;
        }
        if (n == Integer.MIN_VALUE) {
            return myPow(1/x * (1/x),-(Integer.MIN_VALUE/2));
        }
        if (n < 0) {
            return myPow(1/x,-n);
        }
        double two = x * x;
        if (n % 2 == 0) {
            return myPow(two,n/2);
        }
        return myPow(two,n/2)*x;
        /*int gcd = gcd(n);
        double v = myPow(x, gcd);
        for (int i = 0; i < n/gcd; i++) {
            v *= v;
        }
        return v;*/
    }

    public int gcd(int n) {
        for (int i = n-1; i > 1; i--) {
            if (n % i == 0) {
                return i;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        MyPow myPow = new MyPow();
        System.out.println(myPow.myPow(2.0000d, -2));
        System.out.println(myPow.myPow(2.0000d, -2147483648));
        System.out.println(myPow.myPow(34.00515d, -3));
    }
}
