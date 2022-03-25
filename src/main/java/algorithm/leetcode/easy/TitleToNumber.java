package algorithm.leetcode.easy;

public class TitleToNumber {

    public int titleToNumber(String columnTitle) {
        int res = 0;
        int length = columnTitle.length();
        int p = 1;
        for (int i = length-1; i >= 0; i--) {
            char c = columnTitle.charAt(i);
            res += Integer.parseInt((c - 64)+"")*p;
            p *= 26;
        }
        return res;
    }

    public static void main(String[] args) {
        TitleToNumber titleToNumber = new TitleToNumber();
        System.out.println(titleToNumber.titleToNumber("A"));
        System.out.println(titleToNumber.titleToNumber("B"));
        System.out.println(titleToNumber.titleToNumber("C"));
        System.out.println(titleToNumber.titleToNumber("Z"));
        System.out.println(titleToNumber.titleToNumber("AA"));
        System.out.println(titleToNumber.titleToNumber("AB"));
        System.out.println(titleToNumber.titleToNumber("ZY"));
    }
}
