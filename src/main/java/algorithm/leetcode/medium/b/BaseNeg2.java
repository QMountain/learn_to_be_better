package algorithm.leetcode.medium.b;

public class BaseNeg2 {

    public String baseNeg2(int n) {
        if (n == 0) {
            return "0";
        }
        if (n % 2 == 1) {
            String s = baseNeg2(n - 1);
            return s.substring(0, s.length() - 1) + "1";
        }
        int arrLength = 1;
        // 首项 1
        int a1 = 1;
        // 末项 4
        long an = 4;
        while ((an - a1) < 3L *n) {
            an *= 4;
            arrLength += 2;
        }
        char[] chars = new char[arrLength];
        chars[0] = '1';
        long sum = (an - a1) / 3;
        an /= 4;
        long lastSum = sum - an;
        if (an / 2 + lastSum >= n) {
            chars[1] = '1';
            n -= an / 2;
        } else {
            chars[1] = '0';
            n = (int) (n - an);
        }
        if (n == 0) {
            for (int i = 2; i < arrLength; i++) {
                chars[i] = '0';
            }
            return new String(chars);
        }
        if (n > 0) {
            String s = baseNeg2(n);
            char[] array = s.toCharArray();
            System.arraycopy(array,0,chars,arrLength-s.length(),s.length());
            for (int i = 2; i < arrLength-s.length(); i++) {
                chars[i] = '0';
            }
            return new String(chars);
        }
        String neg = getNeg(n);
        int length = neg.length();
        int l = arrLength - 2 - length;
        for (int i = 0; i < l; i++) {
            chars[i+2] = '0';
        }
        char[] array = neg.toCharArray();
        System.arraycopy(array,0,chars,arrLength-length,array.length);
        return new String(chars);
    }

    public String getNeg(int n) {
        n = -n;
        int arrLength = 2;
        // 首项 2
        int a1 = 2;
        // 末项 8
        int an = 8;
        while ((an - a1) < 3*n) {
            an *= 4;
            arrLength += 2;
        }
        char[] chars = new char[arrLength];
        chars[0] = '1';
        int sum = (an - a1) / 3;
        an /= 4;
        int lastSum = sum - an;
        if (an / 2 + lastSum >= n) {
            chars[1] = '1';
            n -= an / 2;
        } else {
            chars[1] = '0';
            n = n - an;
        }
        if (n == 0) {
            for (int i = 2; i < arrLength; i++) {
                chars[i] = '0';
            }
            return new String(chars);
        }
        String s;
        if (n > 0) {
            s = getNeg(-n);
        } else {
            s = baseNeg2(-n);
        }
        char[] array = s.toCharArray();
        System.arraycopy(array,0,chars,arrLength-s.length(),s.length());
        for (int i = 2; i < arrLength-s.length(); i++) {
            chars[i] = '0';
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        BaseNeg2 baseNeg2 = new BaseNeg2();
        System.out.println(baseNeg2.baseNeg2(419887699));
        System.out.println(baseNeg2.baseNeg2(98));
        System.out.println(baseNeg2.baseNeg2(94));
        System.out.println(baseNeg2.baseNeg2(34));
        System.out.println(baseNeg2.baseNeg2(22));
        System.out.println(baseNeg2.baseNeg2(8));
        System.out.println(baseNeg2.baseNeg2(10));
        System.out.println(baseNeg2.baseNeg2(6));
        System.out.println(baseNeg2.baseNeg2(0));
        System.out.println(baseNeg2.baseNeg2(4));
        System.out.println(baseNeg2.baseNeg2(3));
        System.out.println(baseNeg2.baseNeg2(2));
    }
}
