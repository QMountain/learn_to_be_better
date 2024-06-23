package algorithm.leetcode.easy.d;

public class DetectCapitalUse {

    // 1 <= word.length <= 100
    // word 由小写和大写英文字母组成
    public boolean detectCapitalUse(String word) {
        boolean firstCharUpper = Character.isUpperCase(word.charAt(0));
        int countUpper = firstCharUpper ? 1 : 0;
        for (int i = 1; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                if (countUpper < i) {
                    return false;
                }
                countUpper++;
            } else {
                if (countUpper > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean detectCapitalUse2(String word) {
        int length = word.length();
        if (length == 1) {
            return true;
        }
        boolean allLowerCase = true;
        boolean allUpperCase = true;
        for (int i = 1; i < length; i++) {
            if (Character.isLowerCase(word.charAt(i))) {
                allUpperCase = false;
            } else {
                allLowerCase = false;
            }
        }
        if (Character.isUpperCase(word.charAt(0)) && allUpperCase) {
            return true;
        }
        return allLowerCase;
    }

    public static void main(String[] args) {
        DetectCapitalUse detectCapitalUse = new DetectCapitalUse();
        System.out.println(!detectCapitalUse.detectCapitalUse("aBc"));
        System.out.println(!detectCapitalUse.detectCapitalUse("FlaG"));
        System.out.println(detectCapitalUse.detectCapitalUse("USA"));
    }

}
