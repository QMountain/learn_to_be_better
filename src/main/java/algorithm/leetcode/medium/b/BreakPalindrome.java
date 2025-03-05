package algorithm.leetcode.medium.b;

public class BreakPalindrome {

    // 1 <= palindrome.length <= 1000
    // palindrome 只包含小写英文字母。
    public String breakPalindrome(String palindrome) {
        int length = palindrome.length();
        char[] charArray = palindrome.toCharArray();
        int half = length >> 1;
        for (int i = 0; i < half; i++) {
            if (palindrome.charAt(i) != 'a') {
                charArray[i] = 'a';
                return new String(charArray);
            }
        }
        if (length > 1) {
            charArray[length-1] = 'b';
            return new String(charArray);
        }
        return "";
    }

}
