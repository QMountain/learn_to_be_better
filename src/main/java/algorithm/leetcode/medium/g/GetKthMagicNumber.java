package algorithm.leetcode.medium.g;

public class GetKthMagicNumber {

    public int getKthMagicNumber(int k) {
        int[] dp = new int[k+1];
        dp[1] = 1;
        int p3 = 1;
        int p5 = 1;
        int p7 = 1;
        for (int i = 2; i <= k; i++) {
            int num3 = dp[p3]*3;
            int num5 = dp[p5]*5;
            int num7 = dp[p7]*7;
            int min = Math.min(num3,Math.min(num5,num7));
            dp[i] = min;
            if (min == num3) {
                p3++;
            }
            if (min == num5) {
                p5++;
            }
            if (min == num7) {
                p7++;
            }
        }
        return dp[k];
    }

    public static void main(String[] args) {
        GetKthMagicNumber getKthMagicNumber = new GetKthMagicNumber();
        System.out.println(getKthMagicNumber.getKthMagicNumber(251));
        System.out.println(getKthMagicNumber.getKthMagicNumber(5));
    }
}
