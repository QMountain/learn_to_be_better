package algorithm.leetcode.medium.m;

public class MaximumBinaryString {

    public String maximumBinaryString(String binary) {
        char[] chars = binary.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left <= right && chars[left] == '1') {
            left++;
        }
        while (right >= left && chars[right] == '1') {
            right--;
        }
        if (left >= right) {
            return new String(chars);
        }
        // left < right
        int nextZero = left + 1;
        // 0 开头 0 结尾
        while (left < right && nextZero <= right) {
            // left 00
            if (chars[left+1] == '0') {
                chars[left++] = '1';
                chars[left] = '0';
                nextZero = left+1;
            } else {
                // left 01 right 0
                for (int i = nextZero; i <= right; i++) {
                    if (chars[i] == '0') {
                        chars[left++] = '1';
                        chars[left] = '0';
                        chars[i] = '1';
                        nextZero = i+1;
                        break;
                    }
                }
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        MaximumBinaryString maximumBinaryString = new MaximumBinaryString();
        System.out.println(maximumBinaryString.maximumBinaryString("00000").equals("11110"));
        System.out.println(maximumBinaryString.maximumBinaryString("1100").equals("1110"));
        System.out.println(maximumBinaryString.maximumBinaryString("01111001100000110010")
                .equals("11111111110111111111"));
        System.out.println(maximumBinaryString.maximumBinaryString("000110").equals("111011"));
    }
}
