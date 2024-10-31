package algorithm.leetcode.easy.g;

public class GetSmallestString {

    public String getSmallestString(String s) {
        int length = s.length();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < length-1; i++) {
            int n1 = charArray[i] - '0';
            int n2 = charArray[i+1] - '0';
            if (n1 > n2 && n1 % 2 == n2 % 2) {
                char c = charArray[i];
                charArray[i] = charArray[i+1];
                charArray[i+1] = c;
                break;
            }
        }
        return new String(charArray);
    }

}
