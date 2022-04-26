package algorithm.leetcode.medium.m;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Multiply {

    public String multiply(String num1, String num2) {
        if (Objects.equals(num1, "0") || Objects.equals(num2, "0")) {
            return "0";
        }
        if (num1.length() > num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        int l1 = num1.length();
        int l2 = num2.length();
        List<String> addString = new ArrayList<>(l2);
        for (int i = l1-1; i >= 0; i--) {
            int n1 = Integer.parseInt(num1.charAt(i)+"");
            StringBuilder ten = new StringBuilder();
            for (int j = 0; j < l1 - i - 1; j++) {
                ten.append("0");
            }
            StringBuilder sb = new StringBuilder();
            int carry = 0;
            for (int j = l2-1; j >= 0; j--) {
                int n2 = Integer.parseInt(num2.charAt(j)+"");
                int m = n1*n2+carry;
                carry = m / 10;
                sb.insert(0,m%10);
            }
            if (carry != 0) {
                sb.insert(0,carry);
            }
            sb.append(ten);
            addString.add(sb.toString());
        }

        int size = addString.size();
        while (size >= 2) {
            String s1 = addString.get(0);
            String s2 = addString.get(1);
            addString.remove(0);
            addString.remove(0);
            int sl1 = s1.length();
            int sl2 = s2.length();
            int maxLength = Math.max(sl1,sl2);
            int carry = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < maxLength; i++) {
                int si1 = 0;
                if (i < sl1) {
                    si1 = Integer.parseInt(s1.charAt(sl1-1-i)+"");
                }
                int si2 = 0;
                if (i < sl2) {
                    si2 = Integer.parseInt(s2.charAt(sl2-1-i)+"");
                }
                int sum = si1 + si2 + carry;
                sb.insert(0,sum%10);
                carry = sum / 10;
            }
            if (carry > 0) {
                sb.insert(0,carry);
            }
            addString.add(sb.toString());
            size--;
        }
        return addString.get(0);
    }

    public static void main(String[] args) {
        Multiply multiply = new Multiply();
        System.out.println("6".equals(multiply.multiply("2", "3")));
        System.out.println("56088".equals(multiply.multiply("123", "456")));
        System.out.println("891".equals(multiply.multiply("9", "99")));
        System.out.println("882".equals(multiply.multiply("98", "9")));
        System.out.println("998001".equals(multiply.multiply("999", "999")));
    }
}
