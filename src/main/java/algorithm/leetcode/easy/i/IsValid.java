package algorithm.leetcode.easy.i;

import java.util.Set;

public class IsValid {

    /**
     * 3136. 有效单词
     * 有效单词 需要满足以下几个条件：
     * 至少 包含 3 个字符。
     * 由数字 0-9 和英文大小写字母组成。（不必包含所有这类字符。）
     * 至少 包含一个 元音字母 。
     * 至少 包含一个 辅音字母 。
     * 给你一个字符串 word 。如果 word 是一个有效单词，则返回 true ，否则返回 false 。
     * 注意：
     * 'a'、'e'、'i'、'o'、'u' 及其大写形式都属于 元音字母 。
     * 英文中的 辅音字母 是指那些除元音字母之外的字母。
     */
    public boolean isValid(String word) {
        Set<Character> vowelSet = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        boolean containsVowel = false;
        boolean containsConsonant = false;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (vowelSet.contains(c)) {
                containsVowel = true;
            } else if (Character.isLetter(c)) {
                containsConsonant = true;
            } else if (!Character.isDigit(c)) {
                return false;
            }
        }
        return word.length() >= 3 && containsVowel && containsConsonant;
    }

    public static void main(String[] args) {
        IsValid isValid = new IsValid();
        System.out.println(!isValid.isValid("Ya$"));
        System.out.println(isValid.isValid("234Adas"));
    }
}
