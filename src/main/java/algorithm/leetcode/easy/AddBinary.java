package algorithm.leetcode.easy;

public class AddBinary {

    public String addBinary(String a, String b) {
        int aL = a.length();
        int bL = b.length();
        int length = aL;
        if (aL > bL) {
            int dis = aL - bL;
            StringBuilder zero = new StringBuilder();
            for (int i = 0; i < dis; i++) {
                zero.append("0");
            }
            b = zero.append(b).toString();
        }
        if (aL < bL) {
            int dis = bL - aL;
            StringBuilder zero = new StringBuilder();
            for (int i = 0; i < dis; i++) {
                zero.append("0");
            }
            a = zero.append(a).toString();
            length = bL;
        }
        StringBuilder str = new StringBuilder();
        int carry = 0;
        for (int i = length-1; i >= 0; i--) {
            char ca = a.charAt(i);
            char cb = b.charAt(i);
            if (carry == 1) {
                if (ca == '1' && cb == '1') {
                    str.insert(0,1);
                } else if (ca == '1' && cb == '0') {
                    str.insert(0,0);
                } else if (ca == '0' && cb == '1') {
                    str.insert(0,0);
                } else {
                    str.insert(0,1);
                    carry = 0;
                }
            } else {
                if (ca == '1' && cb == '1') {
                    str.insert(0,0);
                    carry = 1;
                } else if (ca == '1' && cb == '0') {
                    str.insert(0,1);
                } else if (ca == '0' && cb == '1') {
                    str.insert(0,1);
                } else {
                    str.insert(0,0);
                }
            }

        }

        if (carry == 1) {
            str.insert(0,1);
        }
        return str.toString();
    }

    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        System.out.println(addBinary.addBinary("11", "1"));
        System.out.println(addBinary.addBinary("1010", "1011"));
    }
}
