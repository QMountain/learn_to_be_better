package algorithm.leetcode.medium.m;

import java.util.Arrays;

/**
 * 给你一个字符串数组 words 和一个字符串 target。
 * 如果字符串 x 是 words 中 任意 字符串的 前缀，则认为 x 是一个 有效 字符串。
 * 现计划通过 连接 有效字符串形成 target ，请你计算并返回需要连接的 最少 字符串数量。
 * 如果无法通过这种方式形成 target，则返回 -1。
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 5 * 10^3
 * 输入确保 sum(words[i].length) <= 10^5。
 * words[i] 只包含小写英文字母。
 * 1 <= target.length <= 5 * 10^3
 * target 只包含小写英文字母。
 */
public class MinValidStrings {

    public int minValidStrings(String[] words, String target) {
        Node[] root = new Node[26];
        for (String word : words) {
            Node[] copy = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (copy[c-'a'] == null) {
                    copy[c-'a'] = new Node(c-'a', new Node[26]);
                }
                copy = copy[c-'a'].children;
            }
        }
        int length = target.length();
        int[] dp = new int[length+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < length; i++) {
            int pre = dp[i];
            Node[] copy = root;
            for (int j = i; j < length; j++) {
                char c = target.charAt(j);
                if (copy[c-'a'] == null) {
                    if (j == i && dp[j+1] == -1) {
                        return -1;
                    }
                    break;
                } else {
                    copy = copy[c-'a'].children;
                    if (dp[j+1] == -1) {
                        dp[j+1] = pre + 1;
                    } else {
                        dp[j+1] = Math.min(dp[j+1], pre + 1);
                    }
                }
            }
        }
        return dp[length];
    }

    public static class Node {
        int val;
        Node[] children;

        public Node(int val, Node[] children) {
            this.val = val;
            this.children = children;
        }
    }

    public static void main(String[] args) {
        MinValidStrings minValidStrings = new MinValidStrings();
        System.out.println(-1 == minValidStrings.minValidStrings(
                new String[]{"b","abacaacabbb"}, "abcca"));
        System.out.println(3 == minValidStrings.minValidStrings(
                new String[]{"ea","a"}, "eaeaa"));
        System.out.println(-1 == minValidStrings.minValidStrings(
                new String[]{"abcdef"}, "xyz"));
        System.out.println(2 == minValidStrings.minValidStrings(
                new String[]{"abababab","ab"}, "ababaababa"));
        System.out.println(3 == minValidStrings.minValidStrings(
                new String[]{"abc","aaaaa","bcdef"}, "aabcdabc"));
    }
}

