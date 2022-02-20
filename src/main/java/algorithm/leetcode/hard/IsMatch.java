package algorithm.leetcode.hard;

/**
 * @ClassName IsMatch
 * @Description
 * @Author qsf
 * Date   2022-02-19  16:52
 */
public class IsMatch {

    public boolean isMatch(String s, String p) {
        if (p.contains(".*")) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            if (i > p.length()-1) {
                return false;
            }
            if (p.charAt(i) == s.charAt(i) || p.charAt(i) == '.') {
                continue;
            } else if (p.charAt(i) == '*') {
                if (p.charAt(i-1) == s.charAt(i)) {
                    int j = i+1;
                    //while (s.contains())
                } else {
                    return false;
                }
            }
        }
        return true;
    }

}
