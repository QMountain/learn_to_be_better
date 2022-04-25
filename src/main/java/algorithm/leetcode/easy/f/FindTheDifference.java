package algorithm.leetcode.easy.f;

public class FindTheDifference {

    public char findTheDifference(String s, String t) {
        int sl = s.length();
        for (int i = 0; i < sl; i++) {
            char c = s.charAt(i);
            t = t.replaceFirst(c+"","");
        }
        return t.charAt(0);
    }

}
