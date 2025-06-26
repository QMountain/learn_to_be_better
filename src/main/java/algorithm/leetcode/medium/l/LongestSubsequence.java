package algorithm.leetcode.medium.l;

public class LongestSubsequence {

    /**
     * 2311. 小于等于 K 的最长二进制子序列
     * 给你一个二进制字符串 s 和一个正整数 k 。
     * 请你返回 s 的 最长 子序列的长度，且该子序列对应的 二进制 数字小于等于 k 。
     * 注意：
     * 子序列可以有 前导 0 。
     * 空字符串视为 0 。
     * 子序列 是指从一个字符串中删除零个或者多个字符后，不改变顺序得到的剩余字符序列。
     * 1 <= s.length <= 1000
     * s[i] 要么是 '0' ，要么是 '1' 。
     * 1 <= k <= 10^9
     */
    public int longestSubsequence(String s, int k) {
        int length = s.length();
        int maxRight = Integer.toBinaryString(k).length();
        char[] charArray = s.toCharArray();
        int ans = 0;
        int countZero = 0;
        for (int i = 0; i < length; i++) {
            if (charArray[i] == '0') {
                 countZero++;
                 ans = Math.max(ans, countZero);
            } else {
                int rightLength = 1;
                int num = 1;
                for (int j = i+1; j < length; j++) {
                    int n = charArray[j] - '0';
                    int cal = num << 1 | n;
                    if (cal <= k) {
                        num = cal;
                        rightLength++;
                    }
                    if (rightLength == maxRight) {
                        break;
                    }
                }
                ans = Math.max(ans, countZero + rightLength);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestSubsequence longestSubsequence = new LongestSubsequence();
        System.out.println(1 == longestSubsequence.longestSubsequence(
                "0", 583196182));
        System.out.println(6 == longestSubsequence.longestSubsequence(
                "00101001", 1));
        System.out.println(5 == longestSubsequence.longestSubsequence(
                "1001010", 5));
    }
}
