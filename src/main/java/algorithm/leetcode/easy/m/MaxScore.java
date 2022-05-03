package algorithm.leetcode.easy.m;

public class MaxScore {

    public int maxScore(String s) {
        int length = s.length();
        int totalOne = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '1') {
                totalOne++;
            }
        }
        int[][] dp = new int[length-1][2];
        int maxScore;
        if (s.charAt(0) == '0') {
            maxScore = 1 + totalOne;
            dp[0][0] = 1;
            dp[0][1] = totalOne;
        } else {
            maxScore = totalOne-1;
            dp[0][0] = 0;
            dp[0][1] = totalOne-1;
        }
        for (int i = 1; i < length-1; i++) {
            if (s.charAt(i) == '0') {
                dp[i][0] = dp[i-1][0]+1;
                dp[i][1] = dp[i-1][1];
                maxScore = Math.max(maxScore,dp[i][0]+dp[i][1]);
            } else {
                dp[i][0] = dp[i-1][0];
                dp[i][1] = dp[i-1][1]-1;
                maxScore = Math.max(maxScore,dp[i][0]+dp[i][1]);
            }
        }
        return maxScore;
    }

}
