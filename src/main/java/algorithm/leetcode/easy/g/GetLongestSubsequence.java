package algorithm.leetcode.easy.g;

import java.util.ArrayList;
import java.util.List;

public class GetLongestSubsequence {

    /**
     * 给你一个下标从 0 开始的字符串数组 words ，和一个下标从 0 开始的 二进制 数组 groups ，两个数组长度都是 n 。
     * 你需要从 words 中选出 最长子序列。
     * 如果对于序列中的任何两个连续串，二进制数组 groups 中它们的对应元素不同，则 words 的子序列是不同的。
     * 正式来说，你需要从下标 [0, 1, ..., n - 1] 中选出一个 最长子序列 ，
     * 将这个子序列记作长度为 k 的 [i0, i1, ..., ik - 1] ，
     * 对于所有满足 0 <= j < k - 1 的 j 都有 groups[ij] != groups[ij + 1] 。
     * 请你返回一个字符串数组，它是下标子序列 依次 对应 words 数组中的字符串连接形成的字符串数组。
     * 如果有多个答案，返回 任意 一个。
     * 注意：words 中的元素是不同的 。
     * 1 <= n == words.length == groups.length <= 100
     * 1 <= words[i].length <= 10
     * groups[i] 是 0 或 1。
     * words 中的字符串 互不相同 。
     * words[i] 只包含小写英文字母。
     */
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> ans = new ArrayList<>();
        ans.add(words[0]);
        int lastIndex = 0;
        for (int i = 1; i < words.length; i++) {
            if (groups[i] != groups[lastIndex]) {
                ans.add(words[i]);
                lastIndex = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        GetLongestSubsequence getLongestSubsequence = new GetLongestSubsequence();
        // ["e","b"]
        System.out.println(getLongestSubsequence.getLongestSubsequence(
                new String[]{"e","a","b"}, new int[]{0,0,1}));
        // "a","b","c"
        System.out.println(getLongestSubsequence.getLongestSubsequence(
                new String[]{"a","b","c","d"}, new int[]{1,0,1,1}));
    }

}
