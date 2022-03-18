package algorithm.leetcode.easy;

public class ReverseString {

    public void reverseString(char[] s) {
        int length = s.length;
        for (int i = 0; i < length / 2; i++) {
            char c = s[i];
            s[i] = s[length-1-i];
            s[length-1-i] = c;
        }
        System.out.println(s);
    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        reverseString.reverseString(new char[]{'h','e','l','l','o'});
    }
}
