package algorithm.leetcode.medium.n;

public class NumDecodings {

    public int numDecodings(String s) {
        int length = s.length();
        int[][] dp = new int[length][2];
        dp[0][1] = 0;
        if (s.charAt(0) >= '1' && s.charAt(0) <= '9') {
            dp[0][0] = 1;
        }
        for (int i = 1; i < length; i++) {
            char c = s.charAt(i);
            if (c == '0') {
                if (s.charAt(i-1) == '1' || s.charAt(i-1) == '2') {
                    dp[i][0] = 0;
                    dp[i][1] = dp[i-1][0];
                } else {
                    return 0;
                }
            } else {
                dp[i][0] = dp[i-1][0] + dp[i-1][1];
                if (((c >= '7' && c <= '9') && s.charAt(i-1) != '1') || (s.charAt(i-1) == '0' || (s.charAt(i-1) > '2' && s.charAt(i-1) <= '9'))) {
                    dp[i][1] = 0;
                } else {
                    dp[i][1] = dp[i-1][0];
                }
            }
        }
        return dp[length-1][0] + dp[length-1][1];
    }

    public static void main(String[] args) {
        NumDecodings numDecodings = new NumDecodings();
        System.out.println(0 == numDecodings.numDecodings("230"));
        System.out.println(4 == numDecodings.numDecodings("2611055971756562"));
        System.out.println(3 == numDecodings.numDecodings("1201234"));
        System.out.println(1 == numDecodings.numDecodings("27"));
        System.out.println(0 == numDecodings.numDecodings("0"));
        System.out.println(3 == numDecodings.numDecodings("226"));
        System.out.println(2 == numDecodings.numDecodings("12"));
    }
}
