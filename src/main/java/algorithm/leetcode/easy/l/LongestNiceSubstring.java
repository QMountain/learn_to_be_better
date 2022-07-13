package algorithm.leetcode.easy.l;

import java.util.HashSet;
import java.util.Set;

public class LongestNiceSubstring {

    public String longestNiceSubstring(String s) {
        int length = s.length();
        if (length == 1) {
            return "";
        }
        int[] lower = new int[26];
        int[] upper = new int[26];
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                lower[c-'a'] = 1;
            } else {
                upper[c-'A'] = 1;
            }
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            if (lower[i] == 1 && upper[i] == 0) {
                set.add((char)(i+'a'));
            }
            if (upper[i] == 1 && lower[i] == 0) {
                set.add((char)(i+'A'));
            }
        }
        if (set.isEmpty()) {
            return s;
        }
        String ans = "";
        int lastIndex = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                if (i > lastIndex+1 && i-lastIndex > ans.length()) {
                    String substring = s.substring(lastIndex, i);
                    String s1 = longestNiceSubstring(substring);
                    if (s1.length() > ans.length()) {
                        ans = s1;
                    }
                }
                lastIndex = i;
            }
        }
        if (length-1-lastIndex <= ans.length()) {
            return ans;
        }
        String s1 = longestNiceSubstring(s.substring(lastIndex + 1));
        return s1.length() > ans.length() ? s1 : ans;
    }

    public static void main(String[] args) {
        LongestNiceSubstring longestNiceSubstring = new LongestNiceSubstring();
        System.out.println(longestNiceSubstring.longestNiceSubstring("wWOExoVhvXebB"));
        System.out.println(longestNiceSubstring.longestNiceSubstring("dDzeE"));
        System.out.println(longestNiceSubstring.longestNiceSubstring("c"));
        System.out.println(longestNiceSubstring.longestNiceSubstring("Bb"));
        System.out.println(longestNiceSubstring.longestNiceSubstring("YazaAay"));
    }
}
