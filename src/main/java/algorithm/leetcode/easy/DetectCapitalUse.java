package algorithm.leetcode.easy;

public class DetectCapitalUse {

    public boolean detectCapitalUse(String word) {
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

}
