package algorithm.leetcode.medium.i;

public class IsInterleave {

    String s1;
    String s2;
    String s3;

    // 题号97，medium 交错字符串；不合格，应该用dp，然后用滚动数组优化空间复杂度，才能达到要求
    public boolean isInterleave(String s1, String s2, String s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        if (s1.equals("")) {
            return s2.equals(s3);
        }
        if (s2.equals("")) {
            return s1.equals(s3);
        }
        if (s3.equals("")) {
            return false;
        }
        int s1l = s1.length();
        int s2l = s2.length();
        int s3l = s3.length();
        if (s1l + s2l != s3l) {
            return false;
        }
        char c1 = s1.charAt(s1.length()-1);
        char c2 = s2.charAt(s2.length()-1);
        char c3 = s3.charAt(s3.length()-1);
        if (c1 == c3 && c2 != c3) {
            return isInterleave(s1.substring(0,s1l-1),s2,s3.substring(0,s3l-1));
        }
        if (c1 != c3 && c2 == c3) {
            return isInterleave(s1,s2.substring(0,s2l-1),s3.substring(0,s3l-1));
        }
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        int[] arr3 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            arr1[s1.charAt(i)-'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            arr2[s2.charAt(i)-'a']++;
        }
        for (int i = 0; i < s3.length(); i++) {
            arr3[s3.charAt(i)-'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (arr1[i]+arr2[i] != arr3[i]) {
                return false;
            }
        }
        return combine(0,0,0);
    }

    public boolean combine(int p1, int p2, int p3) {
        char c1 = s1.charAt(p1);
        char c2 = s2.charAt(p2);
        char c3 = s3.charAt(p3);
        if (c2 != c3 && c3 == c1) {
            if (p1+1 == s1.length()) {
                return s2.substring(p2).equals(s3.substring(p3+1));
            }
            return combine(p1+1,p2,p3+1);
        } else if (c1 != c3 && c2 == c3) {
            if (p2+1 == s2.length()) {
                return s1.substring(p1).equals(s3.substring(p3+1));
            }
            return combine(p1,p2+1,p3+1);
        } else if (c1 == c3) {
            if (p1+1 == s1.length()) {
                if (s2.substring(p2).equals(s3.substring(p3+1))) {
                    return true;
                }
            } else if (combine(p1+1,p2,p3+1)) {
                return true;
            }
            if (p2+1 == s2.length()) {
                if (s1.substring(p1).equals(s3.substring(p3+1))) {
                    return true;
                }
            }
            return combine(p1,p2+1,p3+1);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        IsInterleave isInterleave = new IsInterleave();
        System.out.println(isInterleave.isInterleave("aabcc", "dbbca", "aadbcbbcac"));
        System.out.println(isInterleave.isInterleave("", "", ""));
        System.out.println(isInterleave.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println(isInterleave.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }
}
