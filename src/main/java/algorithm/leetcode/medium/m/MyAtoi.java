package algorithm.leetcode.medium.m;

public class MyAtoi {

    public int myAtoi(String s) {
        s = s.trim();
        if ("".equals(s)) {
            return 0;
        }
        int startIndex = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            if (s.charAt(i) == '+' || s.charAt(i) == '-' ||
                    (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                startIndex = i;
                break;
            }
            return 0;
        }
        int endIndex = startIndex;
        for (int i = startIndex+1; i < length; i++) {
            if ((s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                endIndex = i;
            } else {
                break;
            }
        }
        String substring = s.substring(startIndex, endIndex+1);
        substring = substring.replaceFirst("\\+", "");
        if (substring.equals("") || substring.equals("-")) {
            return 0;
        }

        if (substring.startsWith("-")) {
            substring = substring.replaceFirst("-","");
            while (substring.startsWith("0")) {
                substring = substring.replaceFirst("0","");
            }
            if ("".equals(substring)) {
                return 0;
            }
            substring = "-" + substring;
            if (substring.length() > 11) {
                return Integer.MIN_VALUE;
            }
            if (substring.length() < 11) {
                return Integer.parseInt(substring);
            }
            String min = String.valueOf(Integer.MIN_VALUE);
            if (substring.compareTo(min) <= 0) {
                return Integer.parseInt(substring);
            } else {
                return Integer.MIN_VALUE;
            }
        }
        while (substring.startsWith("0")) {
            substring = substring.replaceFirst("0","");
        }
        if ("".equals(substring)) {
            return 0;
        }
        if (substring.length() > 10) {
            return Integer.MAX_VALUE;
        }
        if (substring.length() < 10) {
            return Integer.parseInt(substring);
        }
        String max = String.valueOf(Integer.MAX_VALUE);
        if (substring.compareTo(max) <= 0) {
            return Integer.parseInt(substring);
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        MyAtoi myAtoi = new MyAtoi();
        /*System.out.println(myAtoi.myAtoi("42"));
        System.out.println(myAtoi.myAtoi("   -42"));
        System.out.println(myAtoi.myAtoi("4193 with words"));
        System.out.println(myAtoi.myAtoi("words and 987"));
        System.out.println(myAtoi.myAtoi("-91283472332"));
        System.out.println(myAtoi.myAtoi("3.14159"));
        System.out.println(myAtoi.myAtoi("+-12"));
        System.out.println(myAtoi.myAtoi("-+12"));
        System.out.println(myAtoi.myAtoi("21474836460"));
        System.out.println(myAtoi.myAtoi("  0000000000012345678"));
        System.out.println(myAtoi.myAtoi("      -11919730356x"));
        System.out.println(myAtoi.myAtoi("-000000000000001"));
        System.out.println(myAtoi.myAtoi("    +1146905820n1"));
        System.out.println(myAtoi.myAtoi("00000-42a1234"));*/
        System.out.println(myAtoi.myAtoi("  -0012a42"));
    }
}
