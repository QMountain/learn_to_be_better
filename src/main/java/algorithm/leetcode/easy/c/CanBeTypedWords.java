package algorithm.leetcode.easy.c;

public class CanBeTypedWords {

    /**
     * 1935. 可以输入的最大单词数
     * 键盘出现了一些故障，有些字母键无法正常工作。而键盘上所有其他键都能够正常工作。
     * 给你一个由若干单词组成的字符串 text ，单词间由单个空格组成（不含前导和尾随空格）；
     * 另有一个字符串 brokenLetters ，由所有已损坏的不同字母键组成，返回你可以使用此键盘完全输入的 text 中单词的数目。
     * 1 <= text.length <= 10^4
     * 0 <= brokenLetters.length <= 26
     * text 由若干用单个空格分隔的单词组成，且不含任何前导和尾随空格
     * 每个单词仅由小写英文字母组成
     * brokenLetters 由 互不相同 的小写英文字母组成
     */
    public int canBeTypedWords(String text, String brokenLetters) {
        boolean[] broken = new boolean[26];
        char[] brokenLettersCharArray = brokenLetters.toCharArray();
        for (char c : brokenLettersCharArray) {
            broken[c-'a'] = true;
        }
        int ans = 1;
        boolean flag = true;
        char[] charArray = text.toCharArray();
        for (char c : charArray) {
            if (c == ' ') {
                flag = true;
                ans++;
                continue;
            }
            if (broken[c - 'a']) {
                if (flag) {
                    ans--;
                }
                flag = false;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        CanBeTypedWords canBeTypedWords = new CanBeTypedWords();
        System.out.println(1 == canBeTypedWords.canBeTypedWords("leet code", "lt"));
        System.out.println(1 == canBeTypedWords.canBeTypedWords("hello world", "ad"));
    }
}
