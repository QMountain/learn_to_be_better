package algorithm.leetcode.medium.c;

public class CountSubstrings {

    public int countSubstrings(String s) {
        int length = s.length();
        int count = length;
        for (int i = 1; i < length-1; i++) {
            int maxLength = Math.min(i,length-i-1);
            for (int j = 1; j <= maxLength; j++) {
                if (s.charAt(i-j) == s.charAt(i+j)) {
                    count++;
                } else {
                    break;
                }
            }
        }
        for (int i = 0; i < length-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                count++;
                int maxLength = Math.min(i,length-i-2);
                for (int j = 1; j <= maxLength; j++) {
                    if (s.charAt(i-j) == s.charAt(i+1+j)) {
                        count++;
                    } else {
                        break;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountSubstrings countSubstrings = new CountSubstrings();
        System.out.println(countSubstrings.countSubstrings("aaaaa"));
        System.out.println(6 == countSubstrings.countSubstrings("aaa"));
        System.out.println(3 == countSubstrings.countSubstrings("abc"));
    }
}
