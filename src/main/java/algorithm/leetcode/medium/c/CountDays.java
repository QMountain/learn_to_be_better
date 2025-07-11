package algorithm.leetcode.medium.c;

import java.util.Arrays;

public class CountDays {

    /**
     * 1 <= days <= 10^9
     * 1 <= meetings.length <= 10^5
     * meetings[i].length == 2
     * 1 <= meetings[i][0] <= meetings[i][1] <= days
     */
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        int preEnd = meetings[0][1];
        int count = meetings[0][0] - 1;
        for (int i = 1; i < meetings.length; i++) {
            if (meetings[i][0] <= preEnd) {
                preEnd = Math.max(preEnd, meetings[i][1]);
            } else {
                count += meetings[i][0] - preEnd - 1;
                preEnd = meetings[i][1];
            }
        }
        return count + days - preEnd;
    }

    public static void main(String[] args) {
        CountDays countDays = new CountDays();
        System.out.println(0 == countDays.countDays(6, new int[][]{{1,6}}));
        System.out.println(1 == countDays.countDays(5, new int[][]{{2,4},{1,3}}));
        System.out.println(2 == countDays.countDays(10, new int[][]{{5,7},{1,3},{9,10}}));
    }
}
