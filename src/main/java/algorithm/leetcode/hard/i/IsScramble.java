package algorithm.leetcode.hard.i;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsScramble {

    Map<String, Boolean> map = new HashMap<>();

    // s1.length == s2.length
    // 1 <= s1.length <= 30
    // s1 和 s2 由小写英文字母组成
    public boolean isScramble(String s1, String s2) {
        String key = s1 + "," + s2;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        // 完全相等，快速结束
        if (s1.equals(s2)) {
            map.put(key, true);
            return true;
        }
        // 分析构成
        int length = s1.length();
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        // 1 left 2 left
        for (int i = 0; i < length-1; i++) {
            count1[s1.charAt(i)-'a']++;
            count2[s2.charAt(i)-'a']++;

            if (Arrays.toString(count1).equals(Arrays.toString(count2))) {
                String s1Left = s1.substring(0, i+1);
                String s1Right = s1.substring(i+1);
                String s2Left = s2.substring(0, i+1);
                String s2Right = s2.substring(i+1);
                if (s1Left.length() < s1Right.length()) {
                    if (isScramble(s1Left, s2Left) && isScramble(s1Right, s2Right)) {
                        map.put(key, true);
                        return true;
                    }
                } else {
                    if (isScramble(s1Right, s2Right) && isScramble(s1Left, s2Left)) {
                        map.put(key, true);
                        return true;
                    }
                }
            }
        }
        count1[s1.charAt(s1.length()-1)-'a']++;
        count2[s2.charAt(s2.length()-1)-'a']++;
        // 构成不同，快速结束
        if (!Arrays.toString(count1).equals(Arrays.toString(count2))) {
            map.put(key, false);
            return false;
        }
        count1 = new int[26];
        count2 = new int[26];
        // 1 left 2 right
        for (int i = 0; i < length-1; i++) {
            count1[s1.charAt(i)-'a']++;
            count2[s2.charAt(length-1-i)-'a']++;

            if (Arrays.toString(count1).equals(Arrays.toString(count2))) {
                String s1Left = s1.substring(0, i+1);
                String s1Right = s1.substring(i+1);
                String s2Left = s2.substring(0, length-i-1);
                String s2Right = s2.substring(length-i-1);
                if (s1Left.length() < s1Right.length()) {
                    if (isScramble(s1Left, s2Right) && isScramble(s1Right, s2Left)) {
                        map.put(key, true);
                        return true;
                    }
                } else {
                    if (isScramble(s1Right, s2Left) && isScramble(s1Left, s2Right)) {
                        map.put(key, true);
                        return true;
                    }
                }
            }
        }
        map.put(key, false);
        return false;
    }

    public static void main(String[] args) {
        IsScramble isScramble = new IsScramble();
        System.out.println(isScramble.isScramble("ebaac", "aabec"));
        System.out.println(!isScramble.isScramble("eebaacbcbcadaaedceaaacadccd", "eadcaacabaddaceacbceaabeccd"));
        System.out.println(isScramble.isScramble("bccbccaaabab", "ccababcaabcb"));
        System.out.println(isScramble.isScramble("cbccbcbcacaaaaaa", "cabaabcaaacaccbc"));
        System.out.println(isScramble.isScramble("abcdbdacbdac", "bdacabcdbdac"));
        System.out.println(isScramble.isScramble("hobobyrqd", "hbyorqdbo"));

        System.out.println(isScramble.isScramble("abcd", "cabd"));
        System.out.println(!isScramble.isScramble("abcde", "caebd"));
        System.out.println(isScramble.isScramble("great", "rgeat"));
    }

}
