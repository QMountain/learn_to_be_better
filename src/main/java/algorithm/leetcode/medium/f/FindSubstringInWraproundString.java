package algorithm.leetcode.medium.f;

import java.util.HashSet;
import java.util.Set;

public class FindSubstringInWraproundString {

    public int findSubstringInWraproundString(String p) {
        String s = "abcdefghijklmnopqrstuvwxyz";
        s += s;
        int length = p.length();
        Set<String> set = new HashSet<>();
        for (int i = 1; i <= length; i++) {
            // i subStr length
            for (int j = 0; j <= length-i; j++) {
                String substring = p.substring(j, j+i);
                if (s.contains(substring)) {
                    set.add(substring);
                }

            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        FindSubstringInWraproundString findSubstringInWraproundString = new FindSubstringInWraproundString();
        System.out.println(findSubstringInWraproundString.findSubstringInWraproundString("zab"));
        System.out.println(findSubstringInWraproundString.findSubstringInWraproundString("a"));
        System.out.println(findSubstringInWraproundString.findSubstringInWraproundString("cac"));
    }
}
