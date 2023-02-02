package algorithm.leetcode.easy.c;

public class CountAsterisks {

    public int countAsterisks(String s) {
        int count = 0;
        boolean needCount = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                if (needCount) {
                    count++;
                }
            } else if (s.charAt(i) == '|') {
                needCount = !needCount;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountAsterisks countAsterisks = new CountAsterisks();
        System.out.println(5 == countAsterisks.countAsterisks("yo|uar|e**|b|e***au|tifu|l"));
        System.out.println(0 == countAsterisks.countAsterisks("iamprogrammer"));
        System.out.println(2 == countAsterisks.countAsterisks("l|*e*et|c**o|*de|"));
    }

}
