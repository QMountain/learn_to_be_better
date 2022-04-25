package algorithm.leetcode.easy.m;

public class MySqrt {

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int length = String.valueOf(x).length();
        int maxLength = (length+1)/2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxLength; i++) {
            sb.append("9");
        }
        int left = 0;
        int right = Integer.parseInt(sb.toString());
        while (right > left) {
            if (left+1 == right) {
                if (right <= x/right) {
                    return right;
                }
                return left;
            }
            int mid = left + (right-left)/2;
            if (mid == x/mid) {
                return mid;
            } else if (mid < x/mid) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        MySqrt mySqrt = new MySqrt();
        System.out.println(2 == mySqrt.mySqrt(4));
        System.out.println(2 == mySqrt.mySqrt(8));
        System.out.println(3 == mySqrt.mySqrt(11));
        System.out.println(46339 == mySqrt.mySqrt(2147395599));
    }

}
