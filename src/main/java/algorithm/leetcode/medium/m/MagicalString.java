package algorithm.leetcode.medium.m;

public class MagicalString {

    // 1 <= n <= 105
    public int magicalString(int n) {
        int readIndex = 2;
        char lastChar = '2';
        StringBuilder sb = new StringBuilder("122");
        int count = 1;
        while (sb.length() < n) {
            int i = Integer.parseInt(sb.charAt(readIndex) + "");
            char nextChar;
            if (lastChar == '1') {
                nextChar = '2';
                for (int j = 0; j < i; j++) {
                    sb.append(nextChar);
                }
            } else {
                nextChar = '1';
                for (int j = 0; j < i; j++) {
                    if (sb.length() < n) {
                        sb.append(nextChar);
                        count++;
                    } else {
                        break;
                    }
                }
            }
            lastChar = nextChar;
            readIndex++;
        }
        return count;
    }

    public static void main(String[] args) {
        MagicalString magicalString = new MagicalString();
        System.out.println(2 == magicalString.magicalString(4));
        System.out.println(4 == magicalString.magicalString(9));
        System.out.println(3 == magicalString.magicalString(6));
        System.out.println(1 == magicalString.magicalString(1));
    }
}
