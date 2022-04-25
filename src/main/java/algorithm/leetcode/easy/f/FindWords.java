package algorithm.leetcode.easy.f;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindWords {

    public String[] findWords(String[] words) {
        Set<Character> set1 = new HashSet<>(10);
        set1.add('q');
        set1.add('w');
        set1.add('e');
        set1.add('r');
        set1.add('t');
        set1.add('y');
        set1.add('u');
        set1.add('i');
        set1.add('o');
        set1.add('p');
        Set<Character> set2 = new HashSet<>(9);
        set2.add('a');
        set2.add('s');
        set2.add('d');
        set2.add('f');
        set2.add('g');
        set2.add('h');
        set2.add('j');
        set2.add('k');
        set2.add('l');
        Set<Character> set3 = new HashSet<>(8);
        set3.add('z');
        set3.add('x');
        set3.add('c');
        set3.add('v');
        set3.add('b');
        set3.add('n');
        set3.add('m');
        List<String> list = new ArrayList<>(words.length);
        for (String word : words) {
            char c = Character.toLowerCase(word.charAt(0));
            Set<Character> set;
            if (set1.contains(c)) {
                set = set1;
            } else if (set2.contains(c)) {
                set = set2;
            } else {
                set = set3;
            }
            boolean all = true;
            int length = word.length();
            for (int i = 0; i < length; i++) {
                char charAt = Character.toLowerCase(word.charAt(i));
                if (!set.contains(charAt)) {
                    all = false;
                    break;
                }
            }
            if (all) {
                list.add(word);
            }
        }
        String[] arr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

}
