package algorithm.leetcode.medium;

import java.util.*;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        List<String> wordDict3 = new ArrayList<>();
        wordDict3.add("bc");
        wordDict3.add("cb");
        System.out.println(wordBreak.wordBreak("ccbb", wordDict3));

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
