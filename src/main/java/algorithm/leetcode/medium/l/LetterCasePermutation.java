package algorithm.leetcode.medium.l;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    public List<String> letterCasePermutation(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (Character.isLetter(s.charAt(i))) {
                count++;
            }
        }
        int max = 1 << count;
        List<String> ansList = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            String bs = Integer.toBinaryString(i);
            StringBuilder sb = new StringBuilder(bs);
            for (int j = 0; j < count - bs.length(); j++) {
                sb.insert(0,"0");
            }
            int index = 0;
            for (int j = 0; j < length; j++) {
                char c = s.charAt(j);
                if (Character.isLetter(c)) {
                    if (sb.charAt(index++) == '0') {
                        chars[j] = Character.toLowerCase(c);
                    } else {
                        chars[j] = Character.toUpperCase(c);
                    }
                }
            }
            ansList.add(new String(chars));
        }
        return ansList;
    }

    public static void main(String[] args) {
        LetterCasePermutation letterCasePermutation = new LetterCasePermutation();
        System.out.println(letterCasePermutation.letterCasePermutation("3z4"));
        System.out.println(letterCasePermutation.letterCasePermutation("a1b2"));
    }
}
