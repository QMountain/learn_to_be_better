package algorithm.leetcode.easy.p;

public class PossibleStringCount {

    public int possibleStringCount(String word) {
        int ans = 1;
        char[] charArray = word.toCharArray();
        int length = word.length();
        for (int i = 1; i < length; i++) {
            if (charArray[i] == charArray[i-1]) {
                ans++;
            }
        }
        return ans;
    }

}
