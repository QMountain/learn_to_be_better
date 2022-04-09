package algorithm.leetcode.easy;

public class ReverseVowels {

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int length = s.length();
        int left = 0;
        int right = length-1;
        while (left <= right) {
            if (!isVowel(chars[left])) {
                left++;
            }
            if (!isVowel(chars[right])) {
                right--;
                continue;
            }
            if (isVowel(chars[left]) && isVowel(chars[right])) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }

    public boolean isVowel(char c) {
        if (c == 'a' || c == 'A') {
            return true;
        }
        if (c == 'e' || c == 'E') {
            return true;
        }
        if (c == 'i' || c == 'I') {
            return true;
        }
        if (c == 'o' || c == 'O') {
            return true;
        }
        return c == 'u' || c == 'U';
    }

    public static void main(String[] args) {
        ReverseVowels reverseVowels = new ReverseVowels();
        System.out.println(reverseVowels.reverseVowels("hello"));
    }
}
