package algorithm.leetcode.medium.f;

import java.util.*;

public class FindAndReplacePattern {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<>();
        int length = pattern.length();
        for (String word : words) {
            Map<Character,Character> map = new HashMap<>();
            Set<Character> showed = new HashSet<>();
            boolean match = true;
            for (int i = 0; i < length; i++) {
                char wc = word.charAt(i);
                char pc = pattern.charAt(i);
                if (!map.containsKey(pc) && !showed.contains(wc)) {
                    map.put(pc,wc);
                    showed.add(wc);
                } else {
                    if (!map.containsKey(pc) || map.get(pc) != wc) {
                        match = false;
                        break;
                    }
                }
            }
            if (match) {
                list.add(word);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        FindAndReplacePattern findAndReplacePattern = new FindAndReplacePattern();
        System.out.println(findAndReplacePattern.findAndReplacePattern(new String[]{"ef","fq","ao","at","lx"}, "ya"));

        System.out.println(findAndReplacePattern.findAndReplacePattern(new String[]{"abc","deq","mee","aqq","dkd","ccc"}, "abb"));

    }
}
