package algorithm.leetcode.medium.c;

public class CheckStrings {

    /**
     * 2840. 判断通过操作能否让字符串相等 II
     * 给你两个字符串 s1 和 s2 ，两个字符串长度都为 n ，且只包含 小写 英文字母。
     * 你可以对两个字符串中的 任意一个 执行以下操作 任意 次：
     * 选择两个下标 i 和 j ，满足 i < j 且 j - i 是 偶数，然后 交换 这个字符串中两个下标对应的字符。
     * 如果你可以让字符串 s1 和 s2 相等，那么返回 true ，否则返回 false 。
     * n == s1.length == s2.length
     * 1 <= n <= 10^5
     * s1 和 s2 只包含小写英文字母。
     */
    public boolean checkStrings(String s1, String s2) {
        int[] even1 = new int[26];
        int[] even2 = new int[26];
        int[] odd1 = new int[26];
        int[] odd2 = new int[26];
        int length = s1.length();
        for (int i = 0; i < length; i++) {
            if (i % 2 == 0) {
                even1[s1.charAt(i) - 'a']++;
                even2[s2.charAt(i) - 'a']++;
                continue;
            }
            odd1[s1.charAt(i) - 'a']++;
            odd2[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (even1[i] != even2[i] || odd1[i] != odd2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckStrings checkStrings = new CheckStrings();
        System.out.println(checkStrings.checkStrings("abcdba", "cabdab"));
        System.out.println(checkStrings.checkStrings("abe", "bea"));
    }
}
