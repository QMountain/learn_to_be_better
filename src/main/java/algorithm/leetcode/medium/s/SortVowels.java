package algorithm.leetcode.medium.s;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class SortVowels {

    public String sortVowels(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        TreeMap<Character, Integer> count = new TreeMap<>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (vowels.contains(charArray[i])) {
                count.put(charArray[i], count.getOrDefault(charArray[i], 0) + 1);
                charArray[i] = ' ';
            }
        }
        if (count.isEmpty()) {
            return s;
        }
        Map.Entry<Character, Integer> entry = count.pollFirstEntry();
        Character c = entry.getKey();
        Integer num = entry.getValue();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == ' ') {
                charArray[i] = c;
                if (--num == 0) {
                    entry = count.pollFirstEntry();
                    if (entry != null) {
                        c = entry.getKey();
                        num = entry.getValue();
                    }
                }
            }
        }
        return new String(charArray);
    }

    public static void main(String[] args) {
        SortVowels sortVowels = new SortVowels();
        System.out.println("lYmpH".equals(sortVowels.sortVowels("lYmpH")));
        System.out.println("lEOtcede".equals(sortVowels.sortVowels("lEetcOde")));
    }
}
