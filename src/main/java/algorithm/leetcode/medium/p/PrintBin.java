package algorithm.leetcode.medium.p;

import java.util.Objects;

public class PrintBin {

    public String printBin(double num) {
        String s = String.valueOf(num);
        if (s.charAt(s.length()-1) != '5') {
            return "ERROR";
        }
        StringBuilder sb = new StringBuilder("0.");
        double curr = 0.5d;
        while (num != 0) {
            if (num >= curr) {
                sb.append("1");
                num -= curr;
            } else {
                sb.append("0");
            }
            curr /= 2;
        }
        String res = sb.toString();
        if (res.length() < 32) {
            return res;
        }
        return "ERROR";
    }

    public static void main(String[] args) {
        PrintBin printBin = new PrintBin();
        System.out.println(Objects.equals(printBin.printBin(0.835d), "ERROR"));
        System.out.println(Objects.equals(printBin.printBin(0.625d), "0.101"));
        System.out.println(printBin.printBin(0.1d).equals("ERROR"));
    }
}
