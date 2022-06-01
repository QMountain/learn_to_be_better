package algorithm.leetcode.medium.d;

public class DecodeString {

    public String decodeString(String s) {
        int length = s.length();
        int letterEnd = length;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c < 'a' || c > 'z') {
                letterEnd = i;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s, 0, letterEnd);
        s = s.substring(letterEnd);
        if (s.equals("")) {
            return sb.toString();
        }
        int numEnd = 0;
        for (int i = 0; i < length - letterEnd; i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') {
                numEnd = i;
                break;
            }
        }
        int num = Integer.parseInt(s.substring(0, numEnd));
        s = s.substring(numEnd);
        int countLeft = 1;
        int countRight = 0;
        int rightEnd = 0;
        for (int i = 1; i < length - letterEnd - numEnd; i++) {
            if (s.charAt(i) == '[') {
                countLeft++;
            } else if (s.charAt(i) == ']') {
                countRight++;
            }
            if (countLeft == countRight) {
                rightEnd = i;
                break;
            }
        }
        String string = decodeString(s.substring(1,rightEnd));
        for (int i = 0; i < num; i++) {
            sb.append(string);
        }
        s = s.substring(rightEnd+1);
        if (!s.equals("")) {
            sb.append(decodeString(s));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();
        System.out.println(decodeString.decodeString("abc3[cd]xyz"));
        System.out.println(decodeString.decodeString("2[abc]3[cd]ef"));
        System.out.println(decodeString.decodeString("3[a2[c]]"));
        System.out.println(decodeString.decodeString("3[a]2[bc]"));
    }
}
