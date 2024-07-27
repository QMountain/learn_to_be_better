package algorithm.leetcode.medium.g;

public class GetSmallestString {

    // 1 <= s.length <= 100
    // 0 <= k <= 2000
    // s 只包含小写英文字母
    public String getSmallestString(String s, int k) {
        if (k == 0) {
            return s;
        }
        char[] charArray = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char c = charArray[i];
            char forwardMinChar;
            int forwardMinCharNeedSteps;
            int forward = c - 'a';
            if (k >= forward) {
                forwardMinChar = 'a';
                forwardMinCharNeedSteps = forward;
            } else {
                forwardMinChar = (char) (c - k);
                forwardMinCharNeedSteps = k;
            }
            char backMinChar;
            int backMinCharNeedSteps;
            int back = 'z' - c + 1;
            if (k >= back) {
                backMinChar = 'a';
                backMinCharNeedSteps = back;
            } else {
                backMinChar = 'z';
                backMinCharNeedSteps = Integer.MAX_VALUE;
            }
            if (forwardMinChar < backMinChar) {
                charArray[i] = forwardMinChar;
                k -= forwardMinCharNeedSteps;
            } else if (forwardMinChar == backMinChar
                    && forwardMinCharNeedSteps < backMinCharNeedSteps) {
                charArray[i] = forwardMinChar;
                k -= forwardMinCharNeedSteps;
            } else if (backMinChar < forwardMinChar) {
                charArray[i] = backMinChar;
                k -= backMinCharNeedSteps;
            } else if (backMinCharNeedSteps < forwardMinCharNeedSteps) {
                charArray[i] = backMinChar;
                k -= backMinCharNeedSteps;
            } else {
                charArray[i] = forwardMinChar;
                k -= forwardMinCharNeedSteps;
            }
            if (k == 0) {
                break;
            }
        }
        return new String(charArray);
    }

    public static void main(String[] args) {
        GetSmallestString getSmallestString = new GetSmallestString();
        System.out.println("a".equals(getSmallestString
                .getSmallestString("t", 25)));
        System.out.println("lol".equals(getSmallestString
                .getSmallestString("lol", 0)));
        System.out.println("aawcd".equals(getSmallestString
                .getSmallestString("xaxcd", 4)));
        System.out.println("aaaz".equals(getSmallestString
                .getSmallestString("zbbz", 3)));
    }
}
