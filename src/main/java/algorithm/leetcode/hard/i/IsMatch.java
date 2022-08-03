package algorithm.leetcode.hard.i;

public class IsMatch {

    // hard 题号44. 通配符匹配
    public boolean isMatch(String s, String p) {
        while (p.contains("**")) {
            p = p.replaceAll("\\*\\*","*");
        }
        while (true) {
            if (p.length() > 1 && s.length() > 1
            && (p.charAt(p.length()-1) == '?' || p.charAt(p.length()-1) == s.charAt(s.length()-1))) {
                p = p.substring(0,p.length()-1);
                s = s.substring(0,s.length()-1);
            } else {
                break;
            }
        }
        if (p.startsWith("*")) {
            String[] split = p.split("\\*");
            int sIndex = 0;
            for (String s1 : split) {
                if (!s1.equals("")) {
                    int length = s1.length();
                    boolean find = false;
                    for (int i = sIndex; i <= s.length()-length; i++) {
                        if (compareCertain(s.substring(i,i+length),s1)) {
                            sIndex = i+length;
                            find = true;
                            break;
                        }
                    }
                    if (!find) {
                        return false;
                    }
                }
            }
            return sIndex == s.length() || p.endsWith("*");
        }
        int sl = s.length();
        int pl = p.length();
        int sIndex = 0;
        int pIndex = 0;
        while (sIndex < sl && pIndex < pl) {
            char sc = s.charAt(sIndex);
            char pc = p.charAt(pIndex);
            if (pc == '*') {
                return isMatch(s.substring(sIndex),p.substring(pIndex));
            }
            if (pc == '?' || sc == pc) {
                sIndex++;
                pIndex++;
            } else {
                return false;
            }
        }
        if (sIndex == sl) {
            if (pIndex == pl) {
                return true;
            }
            p = p.substring(pIndex).replaceAll("\\*","");
            return p.equals("");
        }
        return false;
    }

    public boolean compareCertain(String s, String p) {
        for (int i = 0; i < s.length(); i++) {
            char pc = p.charAt(i);
            if (pc != '?' && pc != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isMatch2(String s, String p) {
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
        System.out.println(isMatch.isMatch("aaaa", "***a"));
        System.out.println(isMatch.isMatch("ab", "*a"));
        System.out.println(isMatch.isMatch("mississippi", "m??*ss*?i*pi"));
        //System.out.println(isMatch.isMatch("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb", "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"));
        //System.out.println(isMatch.isMatch("aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba", "*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*"));
        //System.out.println(isMatch.isMatch("abcabczzzde", "*abc???de*"));
        System.out.println(!isMatch.isMatch("aa", "a"));
        System.out.println(isMatch.isMatch("aa", "*"));
        System.out.println(isMatch.isMatch("cb", "?a"));
        System.out.println(isMatch.isMatch("adceb", "*a*b"));
        System.out.println(isMatch.isMatch("acdcb", "a*c?b"));

        /*System.out.println(isMatch.isMatch("aa", "a*"));
        System.out.println(isMatch.isMatch("ab", ".*"));
        System.out.println(isMatch.isMatch("aab", "c*a*b"));
        System.out.println(!isMatch.isMatch("ab", ".*c"));*/
    }
}
