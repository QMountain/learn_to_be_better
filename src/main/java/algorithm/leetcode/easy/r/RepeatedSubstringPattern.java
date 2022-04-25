package algorithm.leetcode.easy.r;

import java.util.HashMap;
import java.util.Map;

public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {
        int length = s.length();
        Map<Character,Integer> map = new HashMap<>(length);
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int minCount = length;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value == 1) {
                return false;
            }
            if (value < minCount) {
                minCount = value;
            }
        }
        for (int i = 1; i < minCount; i++) {
            if (minCount % i == 0) {
                int times = minCount / i;
                if (length % times == 0) {
                    int subLength = length / times;
                    String substring = s.substring(0, subLength);
                    boolean allEqual= true;
                    for (int j = 1; j < times; j++) {
                        String s2 = s.substring((j) * subLength, (j + 1) * subLength);
                        if (!substring.equals(s2)) {
                            allEqual = false;
                            break;
                        }
                    }
                    if (allEqual) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        RepeatedSubstringPattern repeatedSubstringPattern = new RepeatedSubstringPattern();
        System.out.println(repeatedSubstringPattern.repeatedSubstringPattern("abaababaab"));
        System.out.println(repeatedSubstringPattern.repeatedSubstringPattern("ababba"));
        System.out.println(repeatedSubstringPattern.repeatedSubstringPattern("abcabcabcabc"));
        System.out.println(repeatedSubstringPattern.repeatedSubstringPattern("aba"));
        System.out.println(repeatedSubstringPattern.repeatedSubstringPattern("abab"));
    }
}
