package algorithm.leetcode.easy.m;

public class MakeFancyString {

    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        char preChar = ' ';
        int count = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == preChar) {
                if (++count < 3) {
                    sb.append(c);
                }
            } else {
                count = 1;
                preChar = c;
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MakeFancyString makeFancyString = new MakeFancyString();
        System.out.println(makeFancyString.makeFancyString("leeetcode"));
    }

    public String makeFancyString2(String s) {
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
