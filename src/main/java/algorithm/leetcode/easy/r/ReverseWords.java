package algorithm.leetcode.easy.r;

public class ReverseWords {

    public String reverseWords(String s) {
        int leftIndex = 0;
        int rightIndex = 0;
        int length = s.length();
        for (int i = 0; i < length - 1; i++) {
            if (i == 0 && s.charAt(i) != ' ') {
                leftIndex = i;
            } else if (i > 0 && s.charAt(i-1) == ' ' && s.charAt(i) != ' ') {
                leftIndex = i;
            } else {
                continue;
            }
            for (int j = leftIndex; j < length; j++) {
                if (j == length-1 && s.charAt(j) != ' ') {
                    rightIndex = j;
                    break;
                }
                if (j < length-1 && s.charAt(j) != ' ' && s.charAt(j+1) == ' ') {
                    rightIndex = j;
                    break;
                }
            }
            String substring = s.substring(leftIndex, rightIndex + 1);
            char[] chars = substring.toCharArray();
            int cl = chars.length;
            for (int j = 0; j < cl/2; j++) {
                char c = chars[j];
                chars[j] = chars[cl-1-j];
                chars[cl-1-j] = c;
            }
            s = s.substring(0,leftIndex)+ new String(chars) + s.substring(rightIndex+1);
            i = rightIndex+1;
        }
        return s;
    }

    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();
        System.out.println("s'teL ekat edoCteeL tsetnoc".equals(
                reverseWords.reverseWords("Let's take LeetCode contest")));
        System.out.println("doG gniD".equals(
                reverseWords.reverseWords("God Ding")));
    }
}
