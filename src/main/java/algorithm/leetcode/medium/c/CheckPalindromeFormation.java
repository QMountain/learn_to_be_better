package algorithm.leetcode.medium.c;

import java.util.Arrays;

public class CheckPalindromeFormation {

    // 1 <= a.length, b.length <= 10^5
    // a.length == b.length
    public boolean checkPalindromeFormation(String a, String b) {
        int length = a.length();
        if (length == 1) {
            return true;
        }
        if (isPalindrome(a) || isPalindrome(b)) {
            return true;
        }
        int midIndex = (length+1)/2;
        // dp[i][0] 同上
        // dp[i][1] 同下
        // dp[i][2] 左上右下
        // dp[i][3] 左下右上
        int[][] dp = new int[midIndex][4];
        if (length % 2 != 0) {
            // 奇数长度
            dp[0][0] = 1;
            dp[0][1] = 1;
            dp[0][2] = 1;
            dp[0][3] = 1;
        } else {
            if (a.charAt(length/2-1) == a.charAt(length/2)) {
                dp[0][0] = 1;
                dp[0][2] = 1;
                dp[0][3] = 1;
            }
            if (b.charAt(length/2-1) == b.charAt(length/2)) {
                dp[0][1] = 1;
                dp[0][2] = 1;
                dp[0][3] = 1;
            }
            if (a.charAt(length/2-1) == b.charAt(length/2)) {
                dp[0][2] = 1;
            }
            if (b.charAt(length/2-1) == a.charAt(length/2)) {
                dp[0][3] = 1;
            }
        }
        for (int i = 1; i < midIndex; i++) {
            int left = midIndex - 1 - i;
            int right = length/2 + i;
            if (a.charAt(left) == a.charAt(right)) {
                if (dp[i-1][0] == 1) {
                    dp[i][0] = 1;
                }
            }
            if (b.charAt(left) == b.charAt(right)) {
                if (dp[i-1][1] == 1) {
                    dp[i][1] = 1;
                }
            }
            if (a.charAt(left) == b.charAt(right)) {
                if (dp[i-1][2] == 1 || dp[i-1][1] == 1 || dp[i-1][0] == 1) {
                    dp[i][2] = 1;
                }
            }
            if (b.charAt(left) == a.charAt(right)) {
                if (dp[i-1][3] == 1 || dp[i-1][1] == 1 || dp[i-1][0] == 1) {
                    dp[i][3] = 1;
                }
            }
        }
        return Arrays.stream(dp[midIndex - 1]).sum() > 0;
    }

    public boolean isPalindrome(String str) {
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length-1-i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckPalindromeFormation checkPalindromeFormation = new CheckPalindromeFormation();
        System.out.println(checkPalindromeFormation.checkPalindromeFormation("pvhmupgqeltozftlmfjjde", "yjgpzbezspnnpszebzmhvp"));
        System.out.println(checkPalindromeFormation.checkPalindromeFormation("ulacfd", "jizalu"));
        System.out.println(checkPalindromeFormation.checkPalindromeFormation("abdef", "fecab"));
        System.out.println(checkPalindromeFormation.checkPalindromeFormation("x", "y"));
    }
}
