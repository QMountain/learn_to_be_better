package algorithm.leetcode.easy;

public class ReverseOnlyLetters {

    public String reverseOnlyLetters(String s) {
        int length = s.length();
        char[] chars = s.toCharArray();
        boolean isEvenNumber = length % 2 == 0;

        int left = 0;
        int right = length-1;
        while (isEvenNumber ? left+1 <= right : left < right) {
            if (isALetter(chars[left]) && isALetter(chars[right])) {
                char c = chars[left];
                chars[left] = chars[right];
                chars[right] = c;
                left++;
                right--;
                continue;
            }
            if (!isALetter(chars[left])) {
                left++;
                continue;
            }
            if (!isALetter(chars[right])) {
                right--;
            }
        }
        return new String(chars);
    }

    public boolean isALetter(char c) {
        return (c >= 65 && c <= 90) || (c >= 97 && c <= 122);
    }

    public static void main(String[] args) {
        ReverseOnlyLetters reverseOnlyLetters = new ReverseOnlyLetters();
        System.out.println("dc-ba".equals(reverseOnlyLetters.reverseOnlyLetters("ab-cd")));
        System.out.println("j-Ih-gfE-dCba".equals(reverseOnlyLetters.reverseOnlyLetters("a-bC-dEf-ghIj")));
        System.out.println("Qedo1ct-eeLg=ntse-T!".equals(reverseOnlyLetters.reverseOnlyLetters("Test1ng-Leet=code-Q!")));
    }
}
