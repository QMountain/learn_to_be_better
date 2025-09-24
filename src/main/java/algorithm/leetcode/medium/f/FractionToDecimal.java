package algorithm.leetcode.medium.f;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FractionToDecimal {

    /**
     * 166. 分数到小数
     * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。
     * 如果小数部分为循环小数，则将循环的部分括在括号内。
     * 如果存在多个答案，只需返回 任意一个 。
     * 对于所有给定的输入，保证 答案字符串的长度小于 10^4 。
     * -2^31 <= numerator, denominator <= 2^31 - 1
     * denominator != 0
     */
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        long num = numerator;
        long den = denominator;
        if (num < 0 && den > 0) {
            ans.append("-");
            num = -num;
        } else if (num > 0 && den < 0) {
            ans.append("-");
            den = -den;
        } else if (num < 0 && den < 0) {
            num = -num;
            den = -den;
        }
        Map<Long, Integer> map = new HashMap<>();
        boolean pointed = false;
        int index = 0;
        while (true) {
            if (num < den) {
                if (!pointed) {
                    ans.append("0");
                    ans.append(".");
                    pointed = true;
                } else {
                    if (map.containsKey(num)) {
                        int length = index - map.get(num);
                        ans.insert(ans.length() - length, '(');
                        ans.append(")");
                        break;
                    } else {
                        ans.append("0");
                        map.put(num, index);
                    }
                }
                num *= 10;
            } else if (num % den == 0) {
                ans.append(num / den);
                break;
            } else {
                if (map.containsKey(num)) {
                    int length = index - map.get(num);
                    ans.insert(ans.length() - length, '(');
                    ans.append(")");
                    break;
                }
                ans.append(num / den);
                if (!pointed) {
                    ans.append(".");
                    pointed = true;
                } else {
                    map.put(num, index);
                }
                num %= den;
                num *= 10;
            }
            index++;
        }
        return ans.toString();
    }

    public String fractionToDecimal2(int numerator, int denominator) {
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
        System.out.println(fractionToDecimal.fractionToDecimal(22, 7).equals("3.(142857)"));
        System.out.println("0.5".equals(fractionToDecimal.fractionToDecimal(1, 2)));
        System.out.println(fractionToDecimal.fractionToDecimal(2, 1).equals("2"));
        System.out.println(fractionToDecimal.fractionToDecimal(4, 333).equals("0.(012)"));
        System.out.println(fractionToDecimal.fractionToDecimal(-2147483648, -1));
        System.out.println(fractionToDecimal.fractionToDecimal(-1, -2147483648));
        System.out.println(fractionToDecimal.fractionToDecimal(7, -12));
        System.out.println(fractionToDecimal.fractionToDecimal(-50, 8));
        System.out.println(fractionToDecimal.fractionToDecimal(1, 17));
        System.out.println(fractionToDecimal.fractionToDecimal(1, 6));
        System.out.println(fractionToDecimal.fractionToDecimal(2, 3));
    }
}
