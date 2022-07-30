package algorithm.leetcode.medium.v;

public class ValidUtf8 {

    public boolean validUtf8(int[] data) {
        int length = data.length;
        for (int i = 0; i < length; i++) {
            String str = Integer.toBinaryString(data[i]);
            int sLength = str.length();
            if (sLength < 8) {
                continue;
            }
            if (str.charAt(0) == '0') {
                continue;
            }
            if (str.startsWith("10")) {
                return false;
            }
            int countOne = 0;
            for (int j = 0; j < sLength; j++) {
                if (str.charAt(j) == '1') {
                    countOne++;
                } else {
                    break;
                }
            }
            if (countOne > 4) {
                return false;
            }
            if (countOne > length-i) {
                return false;
            } else {
                for (int j = i+1; j < i+countOne; j++) {
                    String string = Integer.toBinaryString(data[j]);
                    int stringLength = string.length();
                    if (stringLength < 8) {
                        return false;
                    }
                    if (!string.startsWith("10")) {
                        return false;
                    }
                }
                i += countOne-1;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidUtf8 validUtf8 = new ValidUtf8();
        /*System.out.println(validUtf8.validUtf8(new int[]{197,130,1}));
        System.out.println(!validUtf8.validUtf8(new int[]{235,140,4}));
        System.out.println(validUtf8.validUtf8(new int[]{10}));
        System.out.println(validUtf8.validUtf8(new int[]{230,136,145}));
        System.out.println(!validUtf8.validUtf8(new int[]{145}));
        System.out.println(!validUtf8.validUtf8(new int[]{240,162,138,147,145}));
        System.out.println(!validUtf8.validUtf8(new int[]{250,145,145,145,145}));*/
        System.out.println(validUtf8.validUtf8(new int[]{115,100,102,231,154,132,13,10}));
    }
}
