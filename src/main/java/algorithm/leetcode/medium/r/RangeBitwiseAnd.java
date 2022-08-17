package algorithm.leetcode.medium.r;

public class RangeBitwiseAnd {

    public int rangeBitwiseAnd(int left, int right) {
        String maxStr = Integer.toBinaryString(right);
        int length = maxStr.length();
        char[] charsForChange = maxStr.toCharArray();
        char[] chars = maxStr.toCharArray();
        for (int i = 0; i < length; i++) {
            if (chars[i] == '1') {
                char[] copy = new char[length];
                System.arraycopy(chars,0,copy,0,i);
                copy[i] = '0';
                for (int j = i+1; j < length; j++) {
                    copy[j] = '1';
                }
                int value = Integer.valueOf(new String(copy), 2);
                if (left <= value && value <= right) {
                    charsForChange[i] = '0';
                    continue;
                }
                int zeroLength = length - i-1;
                if (left < 1 << zeroLength) {
                    charsForChange[i] = '0';
                }
            }
        }
        String s = new String(charsForChange);
        return Integer.valueOf(s, 2);
    }

    public static void main(String[] args) {
        RangeBitwiseAnd rangeBitwiseAnd = new RangeBitwiseAnd();
        System.out.println(rangeBitwiseAnd.rangeBitwiseAnd(5, 6));
        System.out.println(rangeBitwiseAnd.rangeBitwiseAnd(1, 2));
        System.out.println(rangeBitwiseAnd.rangeBitwiseAnd(1, 2147483647));
        System.out.println(rangeBitwiseAnd.rangeBitwiseAnd(0, 0));
        System.out.println(rangeBitwiseAnd.rangeBitwiseAnd(5, 7));
    }
}
