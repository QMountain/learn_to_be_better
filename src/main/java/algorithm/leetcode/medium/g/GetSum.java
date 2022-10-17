package algorithm.leetcode.medium.g;

public class GetSum {

    // 题号371 两整数之和
    public int getSum(int a, int b) {
        while (b != 0) {
            String s1 = Integer.toBinaryString(a);
            String s2 = Integer.toBinaryString(b);
            int mid = a & b;
            String s = Integer.toBinaryString(mid);
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }

    public int getSum2(int a, int b) {
        if (a*b < 0 && Math.abs(a) == Math.abs(b)) {
            return 0;
        }
        String s1 = Integer.toBinaryString(a);
        String s2 = Integer.toBinaryString(b);
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (true) {
            int indexS1OfZero = s1.lastIndexOf("0");
            int indexS1OfOne = s1.lastIndexOf("1");
            int indexS1 = Math.max(indexS1OfZero,indexS1OfOne);
            int i1 = Integer.parseInt(String.valueOf(s1.charAt(indexS1)));
            int indexS2OfZero = s2.lastIndexOf("0");
            int indexS2OfOne = s2.lastIndexOf("1");
            int indexS2 = Math.max(indexS2OfZero, indexS2OfOne);
            int i2 = Integer.parseInt(String.valueOf(s2.charAt(indexS2)));
            sb.insert(0,i1 ^ i2 ^ carry);
            if (i1 == 1 && i2 == 1) {
                carry = 1;
            } else if (i1 == 0 && i2 == 0) {
                carry = 0;
            }
            s1 = s1.substring(0,indexS1);
            s2 = s2.substring(0,indexS2);
            if (s1.length() == 0 && s2.length() == 0) {
                break;
            } else if (s1.length() == 0) {
                s1 = "0";
            } else if (s2.length() == 0) {
                s2 = "0";
            }
        }
        int length = sb.length();
        if (length == 32) {
            StringBuilder sb2 = new StringBuilder();
            String substring = sb.substring(1);
            while (substring.startsWith("0") && substring.length() > 1) {
                substring = substring.substring(1);
            }
            while (substring.length() > 0) {
                int indexOfZero = substring.lastIndexOf("0");
                int indexOfOne = substring.lastIndexOf("1");
                int index = Math.max(indexOfZero,indexOfOne);
                if (substring.charAt(index) == '1') {
                    sb2.insert(0,0);
                } else {
                    sb2.insert(0,1);
                }
                substring = substring.substring(0,index);
            }
            int sum = getSum(Integer.valueOf(sb2.toString(), 2), 1);
            if (sb.charAt(0) == '1') {
                return Integer.parseInt("-"+sum);
            }
            return sum;
        }
        if (carry == 1 && length < 31) {
            sb.insert(0,carry);
        }
        return Integer.valueOf(sb.toString(),2);
    }

    public static void main(String[] args) {
        GetSum getSum = new GetSum();
        System.out.println(0 == getSum.getSum(-1, 1));
        System.out.println(2 == getSum.getSum(-14, 16));
        System.out.println(-50 == getSum.getSum(-100, 50));
        System.out.println(600 == getSum.getSum(399, 201));
        System.out.println(300 == getSum.getSum(100, 200));
        System.out.println(5 == getSum.getSum(2, 3));
        System.out.println(3 == getSum.getSum(1, 2));
    }
}
