package algorithm.leetcode.easy;

public class ValidPalindrome {

    public boolean validPalindrome(String s) {
        int length = s.length();
        int diff = -1;
        for (int i = 0; i < length / 2; i++) {
            if (s.charAt(i) != s.charAt(length-1-i)) {
                diff = i;
                break;
            }
        }
        if (diff == -1) {
            return true;
        }
        boolean eq = true;
        for (int i = diff+1; i < (length+1)/2; i++) {
            if (s.charAt(i) != s.charAt(length-i)) {
                eq = false;
                break;
            }
        }
        if (eq) {
            return true;
        }
        for (int i = diff; i < (length-1)/2; i++) {
            if (s.charAt(i) != s.charAt(length-2-i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.validPalindrome("abc"));
        System.out.println(validPalindrome.validPalindrome("abca"));
        System.out.println(validPalindrome.validPalindrome("aba"));
    }
}
