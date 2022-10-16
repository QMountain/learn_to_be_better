package algorithm.leetcode.easy.c;

public class CountTime {

    public int countTime(String time) {
        int base = 1;
        char c1 = time.charAt(0);
        char c2 = time.charAt(1);
        if (c1 == '?' && c2 == '?') {
            base *= 24;
        } else if (c1 == '?') {
            int n2 = Integer.parseInt(c2 + "");
            if (n2 > 3) {
                base *= 2;
            } else {
                base *= 3;
            }
        } else if (c2 == '?') {
            int n1 = Integer.parseInt(c1 + "");
            if (n1 == 2) {
                base *= 4;
            } else {
                base *= 10;
            }
        }
        char c3 = time.charAt(3);
        char c4 = time.charAt(4);
        if (c3 == '?' && c4 == '?') {
            base *= 60;
        } else if (c3 == '?') {
            base *= 6;
        } else if (c4 == '?') {
            base *= 10;
        }
        return base;
    }

    public static void main(String[] args) {
        CountTime countTime = new CountTime();
        System.out.println(1440 == countTime.countTime("??:??"));
        System.out.println(100 == countTime.countTime("0?:0?"));
        System.out.println(2 == countTime.countTime("?5:00"));
    }
}
