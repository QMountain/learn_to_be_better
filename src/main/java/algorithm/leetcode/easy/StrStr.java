package algorithm.leetcode.easy;

import java.util.Objects;

public class StrStr {

    public int strStr(String haystack, String needle) {
        if (Objects.equals(needle, "")) {
            return 0;
        }
        int haystackLength = haystack.length();
        int needleLength = needle.length();
        for (int i = 0; i < haystackLength-needleLength+1; i++) {
            String substring = haystack.substring(i, i + needleLength);
            if (substring.equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        StrStr strStr = new StrStr();
        /*System.out.println(2 == strStr.strStr("hello", "ll"));
        System.out.println(-1 == strStr.strStr("aaaaa", "bba"));
        System.out.println(0 == strStr.strStr("", ""));*/
        System.out.println(0 == strStr.strStr("a", "a"));
    }
}
