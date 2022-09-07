package algorithm.leetcode.medium.w;

import java.util.*;

public class WordDictionary {

    Map<Integer, Set<String>> map;

    public WordDictionary() {
        map = new HashMap<>(25);
        for (int i = 1; i < 26; i++) {
            map.put(i,new HashSet<>());
        }
    }

    public void addWord(String word) {
        int length = word.length();
        map.get(length).add(word);
    }

    public boolean search(String word) {
        int length = word.length();
        Set<String> set = map.get(length);
        if (set.isEmpty()) {
            return false;
        }
        if (!word.contains(".")) {
            return set.contains(word);
        }
        if (countPoint(word) < set.size()) {
            for (char i = 'a'; i <= 'z'; i++) {
                if (search(word.replaceFirst("\\.",i+""))) {
                    return true;
                }
            }
            return false;
        }
        for (String s : set) {
            boolean eq = true;
            for (int i = 0; i < length; i++) {
                if (word.charAt(i) != '.' && word.charAt(i) != s.charAt(i)) {
                    eq = false;
                    break;
                }
            }
            if (eq) {
                return true;
            }
        }
        return false;
    }

    public int countPoint(String word) {
        int count = 1;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == '.') {
                count *= 26;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));
    }

}
