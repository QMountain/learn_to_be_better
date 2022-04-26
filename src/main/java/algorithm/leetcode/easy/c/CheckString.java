package algorithm.leetcode.easy.c;

public class CheckString {

    public boolean checkString(String s) {
        int length = s.length();
        for (int i = length-1; i >= 0; i--) {
            if (s.charAt(i) == 'a') {
                for (int j = 0; j < i; j++) {
                    if (s.charAt(j) == 'b') {
                        return false;
                    }
                }
                return true;
            }
        }
        return true;
    }

}
