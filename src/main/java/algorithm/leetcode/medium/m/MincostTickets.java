package algorithm.leetcode.medium.m;

public class MincostTickets {

    public int mincostTickets(int[] days, int[] costs) {
        int length = days.length;
        int[] dp = new int[length];
        dp[0] = Math.min(Math.min(costs[0], costs[1]), costs[2]);
        int sevenDaySpanIndex = 0;
        int thirtyDaySpanIndex = 0;
        for (int i = 1; i < length; i++) {
            int currDay = days[i];
            // 买一张一天的
            int m1 = dp[i-1] + costs[0];
            // 买一张七天的
            int m2;
            while (currDay - days[sevenDaySpanIndex] >= 7) {
                sevenDaySpanIndex++;
            }
            if (sevenDaySpanIndex == 0) {
                m2 = costs[1];
            } else {
                m2 = dp[sevenDaySpanIndex-1] + costs[1];
            }
            // 买一张三十天的
            int m3;
            while (currDay - days[thirtyDaySpanIndex] >= 30) {
                thirtyDaySpanIndex++;
            }
            if (thirtyDaySpanIndex == 0) {
                m3 = costs[2];
            } else {
                m3 = dp[thirtyDaySpanIndex-1] + costs[2];
            }

            dp[i] = Math.min(Math.min(m1, m2), m3);
        }
        return dp[length-1];
    }

    public static void main(String[] args) {
        MincostTickets mincostTickets = new MincostTickets();
        System.out.println(6 == mincostTickets.mincostTickets(
                new int[]{1,4,6,7,8,20}, new int[]{7,2,15}));
        System.out.println(17 == mincostTickets.mincostTickets(
                new int[]{1,2,3,4,5,6,7,8,9,10,30,31}, new int[]{2,7,15}));
        System.out.println(11 == mincostTickets.mincostTickets(
                new int[]{1,4,6,7,8,20}, new int[]{2,7,15}));
    }
}
