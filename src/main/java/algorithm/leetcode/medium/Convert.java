package algorithm.leetcode.medium;

public class Convert {

    public String convert(String s, int numRows) {
        if (s.length() == 1 || numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows-1) {
                for (int j = i; j < s.length(); j+=numRows*2-2) {
                    sb.append(s.charAt(j));
                }
            } else {
                boolean b = true;
                for (int j = i; j < s.length(); ) {
                    sb.append(s.charAt(j));
                    if (b) {
                        j+=(numRows-i)*2-2;
                        b = false;
                    } else {
                        j += i*2;
                        b = true;
                    }
                }
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Convert convert = new Convert();
        System.out.println("PAHNAPLSIIGYIR".equals(convert.convert("PAYPALISHIRING", 3)));
        System.out.println("PINALSIGYAHRPI".equals(convert.convert("PAYPALISHIRING", 4)));
        System.out.println("A".equals(convert.convert("A", 1)));
        System.out.println("AB".equals(convert.convert("AB", 1)));
    }
}
