package algorithm.leetcode.medium.n;

import java.util.HashSet;

public class NumOfMinutes {

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int[] time = new int[n];
        int max = 0;
        for (int i = 0; i < manager.length; i++) {
            int boss = manager[i];
            while (boss != -1) {
                if (time[boss] != 0) {
                    time[i] += time[boss] + informTime[boss];
                    break;
                }
                time[i] += informTime[boss];
                boss = manager[boss];
            }
            max = Math.max(max, time[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        NumOfMinutes numOfMinutes = new NumOfMinutes();
        System.out.println(3665 == numOfMinutes.numOfMinutes(10, 3,
                new int[]{8,9,8,-1,7,1,2,0,3,0},
                new int[]{224,943,160,909,0,0,0,643,867,722}));
        System.out.println(3 == numOfMinutes.numOfMinutes(15, 0,
                new int[]{-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6},
                new int[]{1,1,1,1,1,1,1,0,0,0,0,0,0,0,0}));
        System.out.println(21 == numOfMinutes.numOfMinutes(7, 6,
                new int[]{1,2,3,4,5,6,-1}, new int[]{0,6,5,4,3,2,1}));
        System.out.println(1 == numOfMinutes.numOfMinutes(6, 2,
                new int[]{2,2,-1,2,2,2}, new int[]{0,0,1,0,0,0}));
        System.out.println(0 == numOfMinutes.numOfMinutes(1, 0,
                new int[]{-1}, new int[]{0}));
    }
}
