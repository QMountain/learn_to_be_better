package algorithm.leetcode.easy.a;

public class AreNumbersAscending {

    public boolean areNumbersAscending(String s) {
        int lastNum = -1;
        int lastIndex = 0;
        while (true) {
            int i = s.indexOf(" ",lastIndex);
            if (i == -1) {
                if (!Character.isDigit(s.charAt(lastIndex))) {
                    return true;
                }
                String substring = s.substring(lastIndex);
                int num = Integer.parseInt(substring);
                return num > lastNum;
            }
            if (Character.isDigit(s.charAt(lastIndex))) {
                String substring = s.substring(lastIndex, i);
                int num = Integer.parseInt(substring);
                if (num <= lastNum) {
                    return false;
                }
                lastNum = num;
            }
            lastIndex = i+1;
        }
    }

    public static void main(String[] args) {
        AreNumbersAscending areNumbersAscending = new AreNumbersAscending();
        System.out.println(areNumbersAscending.areNumbersAscending("4 5 11 26"));
        System.out.println(areNumbersAscending.areNumbersAscending("sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s"));
        System.out.println(areNumbersAscending.areNumbersAscending("hello world 5 x 5"));
        System.out.println(areNumbersAscending.areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles"));
    }
}
