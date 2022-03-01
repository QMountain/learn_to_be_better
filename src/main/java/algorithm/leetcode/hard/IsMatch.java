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
        if (!p.contains("*")) {
            if (s.length() > p.length()) {
                return false;
            }
        }
        int pLength = p.length();
        int sLength = s.length();
        int sPointer = 0;
        int pPointer = 0;
        boolean canContinue = true;
        while (canContinue) {
            if (p.charAt(pPointer) != s.charAt(sPointer)) {
                if (p.charAt(pPointer) == '.') {
                    pPointer++;
                    sPointer++;
                } else if (p.charAt(pPointer) == '*') {
                    if (p.charAt(pPointer-1) == s.charAt(sPointer)) {
                        sPointer++;
                    } else {
                        pPointer++;
                    }
                }else {
                    pPointer++;
                }
            } else {
                pPointer++;
                sPointer++;
            }
            if (sPointer >= sLength || pPointer >= pLength) {
                canContinue = false;
            }
        }
        return sPointer == sLength;
    }

    public static void main(String[] args) {
        IsMatch isMatch = new IsMatch();
        System.out.println(!isMatch.isMatch("aa", "a"));
        System.out.println(isMatch.isMatch("aa", "a*"));
        System.out.println(isMatch.isMatch("ab", ".*"));
        System.out.println(isMatch.isMatch("aab", "c*a*b"));
        System.out.println(isMatch.isMatch("ab", ".*c"));
    }
}
