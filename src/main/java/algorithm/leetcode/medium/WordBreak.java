package algorithm.leetcode.medium;

import java.util.*;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        if (Objects.equals(s, "")) {
            return true;
        }
        int length = s.length();
        Set<String> set = new HashSet<>(wordDict);
        if (length == 1) {
            return set.contains(s);
        }
        Set<Character> neededChar = new HashSet<>(length);
        for (int i = 0; i < length; i++) {
            neededChar.add(s.charAt(i));
        }
        Set<Character> hasChar = new HashSet<>(length*2);
        for (String word : set) {
            for (int i = 0; i < word.length(); i++) {
                hasChar.add(word.charAt(i));
            }
        }
        if (!hasChar.containsAll(neededChar)) {
            return false;
        }
        for (int i = length-1; i >= 0; i--) {
            String substring = s.substring(0, i+1);
            if (set.contains(substring)) {
                String sub2 = s.substring(i + 1);
                if (set.contains(sub2)) {
                    return true;
                }
                if (wordBreak(sub2,wordDict)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();

        List<String> wordDict6 = new ArrayList<>();
        wordDict6.add("a");
        wordDict6.add("aa");
        wordDict6.add("aaa");
        wordDict6.add("aaaa");
        wordDict6.add("aaaaa");
        wordDict6.add("aaaaaa");
        wordDict6.add("aaaaaaa");
        wordDict6.add("aaaaaaaa");
        wordDict6.add("aaaaaaaaa");
        System.out.println(wordBreak.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", wordDict6));

        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak.wordBreak("leetcode", wordDict));
        List<String> wordDict1 = new ArrayList<>();
        wordDict1.add("apple");
        wordDict1.add("pen");
        System.out.println(wordBreak.wordBreak("applepenapple", wordDict1));
        List<String> wordDict2 = new ArrayList<>();
        wordDict2.add("cats");
        wordDict2.add("dog");
        wordDict2.add("sand");
        wordDict2.add("and");
        wordDict2.add("cat");
        System.out.println(wordBreak.wordBreak("catsandog", wordDict2));
        List<String> wordDict3 = new ArrayList<>();
        wordDict3.add("bc");
        wordDict3.add("cb");
        System.out.println(wordBreak.wordBreak("ccbb", wordDict3));
        List<String> wordDict4 = new ArrayList<>();
        wordDict4.add("a");
        wordDict4.add("b");
        wordDict4.add("bbb");
        wordDict4.add("bbbb");
        System.out.println(wordBreak.wordBreak("bb", wordDict4));
        List<String> wordDict5 = new ArrayList<>();
        wordDict5.add("cc");
        wordDict5.add("ac");
        System.out.println(wordBreak.wordBreak("ccaccc", wordDict5));


    }
}
