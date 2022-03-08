package algorithm.leetcode.hard;

/**
 * @ClassName IsMatch
 * @Description
 * @Author qsf
 * Date   2022-02-19  16:52
 */
public class IsMatch {

    public boolean isMatch(String s, String p) {
        if (!p.contains("*")) {
            if (s.length() > p.length()) {
                return false;
            }
        }
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m+1][n+1];
        f[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j-1) == '*') {
                    f[i][j] = f[i][j-2];
                    if (matches(s,p,i,j-1)) {
                        f[i][j] = f[i][j] || f[i-1][j];
                    }
                } else {
                    if (matches(s,p,i,j)) {
                        f[i][j] = f[i-1][j-1];
                    }
                }
            }
        }

        return f[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j-1) == '.') {
            return true;
        }
        return s.charAt(i-1) == p.charAt(j-1);
    }

    public static void main(String[] args) {
        IsMatch isMatch = new IsMatch();
        System.out.println(!isMatch.isMatch("aa", "a"));
        System.out.println(isMatch.isMatch("aa", "a*"));
        System.out.println(isMatch.isMatch("ab", ".*"));
        System.out.println(isMatch.isMatch("aab", "c*a*b"));
        System.out.println(!isMatch.isMatch("ab", ".*c"));
    }
}
