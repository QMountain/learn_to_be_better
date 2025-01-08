package algorithm.leetcode.easy.l;

public class LargestGoodInteger {

    // 3 <= num.length <= 1000
    // num 仅由数字（0 - 9）组成
    public String largestGoodInteger(String num) {
        int length = num.length();
        int max = -1;
        for (int i = 0; i < length - 2; i++) {
            if (num.charAt(i) == num.charAt(i+1) && num.charAt(i) == num.charAt(i+2)) {
                max = Math.max(max, num.charAt(i) - '0');
            }
        }
        if (max == -1) {
            return "";
        }
        return max + "" + max + max;
    }

}
