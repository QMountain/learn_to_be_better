package algorithm.leetcode.easy.r;

import java.util.*;

public class RemoveAnagrams {

    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        int[] pre = new int[26];
        for (String word : words) {
            int[] count = new int[26];
            char[] charArray = word.toCharArray();
            for (char c : charArray) {
                count[c-'a']++;
            }
            boolean eq = true;
            for (int i = 0; i < 26; i++) {
                if (pre[i] != count[i]) {
                    eq = false;
                    break;
                }
            }
            if (!eq) {
                ans.add(word);
            }
            pre = count;
        }
        return ans;
    }

    public static void main(String[] args) {
        RemoveAnagrams removeAnagrams = new RemoveAnagrams();
        System.out.println(removeAnagrams.removeAnagrams(new String[]{}));
    }
}
