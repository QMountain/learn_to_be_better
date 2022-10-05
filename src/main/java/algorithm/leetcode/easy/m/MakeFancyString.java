package algorithm.leetcode.easy.m;

public class MakeFancyString {

    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (sb.length() < 2) {
                sb.append(c);
                continue;
            }
            if (c != sb.charAt(sb.length()-1) || c != sb.charAt(sb.length()-2)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
