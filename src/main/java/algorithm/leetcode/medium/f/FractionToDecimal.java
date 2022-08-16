package algorithm.leetcode.medium.f;

import java.util.ArrayList;
import java.util.List;

public class FractionToDecimal {

    public String fractionToDecimal(int numerator, int denominator) {
        long bcs = numerator;
        long cs = denominator;
        if (bcs % cs == 0) {
            return String.valueOf(bcs/cs);
        }
        List<Long> list = new ArrayList<>();
        StringBuilder ans = new StringBuilder();
        if (bcs < 0 && cs < 0) {
            bcs = -bcs;
            cs = -cs;
        } else if (bcs < 0) {
            bcs = -bcs;
            ans.append("-");
        } else if (bcs > 0 && cs < 0) {
            cs = -cs;
            ans.append("-");
        }
        ans.append(bcs/cs);
        ans.append(".");
        bcs %= cs;
        bcs *= 10;
        boolean circle = false;
        while (true) {
            list.add(bcs);
            int index = list.indexOf(bcs);
            if (index != -1 && index != list.size()-1) {
                circle = true;
                break;
            }
            if (bcs < cs) {
                bcs *= 10;
                ans.append("0");
                continue;
            }
            long bs = bcs / cs;
            long ys = bcs % cs;
            ans.append(bs);
            if (ys == 0) {
                break;
            }
            bcs = ys*10;
        }
        if (circle) {
            String s = String.valueOf(ans);
            int firstShowUp = list.indexOf(list.get(list.size() - 1));
            int l = list.size()-1 - firstShowUp;
            String cir = s.substring(s.length()-l);
            String firstPart = s.substring(0, s.length()-l);
            if (firstPart.contains(".")) {
                return firstPart +"("+cir+")";
            }
            return firstPart +".("+cir+")";
        }
        return String.valueOf(ans);
    }

    public static void main(String[] args) {
        FractionToDecimal fractionToDecimal = new FractionToDecimal();
        System.out.println(fractionToDecimal.fractionToDecimal(-2147483648, -1));
        System.out.println(fractionToDecimal.fractionToDecimal(-1, -2147483648));
        System.out.println(fractionToDecimal.fractionToDecimal(7, -12));
        System.out.println(fractionToDecimal.fractionToDecimal(-50, 8));
        System.out.println(fractionToDecimal.fractionToDecimal(1, 17));
        System.out.println(fractionToDecimal.fractionToDecimal(1, 6));
        System.out.println(fractionToDecimal.fractionToDecimal(2, 3));
        System.out.println(fractionToDecimal.fractionToDecimal(1, 2));
        System.out.println(fractionToDecimal.fractionToDecimal(2, 1));
        System.out.println(fractionToDecimal.fractionToDecimal(4, 333));
    }
}
