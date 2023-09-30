package algorithm.leetcode.hard.e;

import java.util.Arrays;

public class EarliestFullBloom {

    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int sumPlantTime = 0;
        int minGrowTimeIndex = 0;
        int maxFlower = 0;
        int length = plantTime.length;
        for (int i = 0; i < length; i++) {
            sumPlantTime += plantTime[i];
            if (growTime[i] < growTime[minGrowTimeIndex]) {
                minGrowTimeIndex = i;
            }
            maxFlower = Math.max(maxFlower, plantTime[i] + growTime[i]);
        }
        int minGrowTime = growTime[minGrowTimeIndex];
        int ans = Math.max(maxFlower, sumPlantTime + minGrowTime);
        int[][] sortArr = new int[length-1][2];
        boolean meet = false;
        for (int i = 0; i < length; i++) {
            if (meet) {
                sortArr[i-1][0] = growTime[i];
                sortArr[i-1][1] = i;
            } else {
                if (i == minGrowTimeIndex) {
                    meet = true;
                } else {
                    sortArr[i][0] = growTime[i];
                    sortArr[i][1] = i;
                }
            }
        }
        Arrays.sort(sortArr, (a, b) -> b[0] - a[0]);
        int plantDayStart = 0;
        for (int i = 0; i < length-1; i++) {
            int index = sortArr[i][1];
            if (plantDayStart + plantTime[index] + growTime[index] > ans) {
                ans = plantDayStart + plantTime[index] + growTime[index];
            } else {
                plantDayStart += plantTime[index];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        EarliestFullBloom earliestFullBloom = new EarliestFullBloom();
        System.out.println(earliestFullBloom.earliestFullBloom(
                new int[]{27,5,24,17,27,4,23,16,6,26,13,17,21,3,9,10,28,26,4,10,28,2},
                new int[]{26,9,14,17,6,14,23,24,11,6,27,14,13,1,15,5,12,15,23,27,28,12}));
        System.out.println(earliestFullBloom.earliestFullBloom(
                new int[]{12,1,12,5,20,10,23,22,20,21,23,9},
                new int[]{22,3,29,1,15,12,26,11,8,7,16,15}));
        System.out.println(227 == earliestFullBloom.earliestFullBloom(
                new int[]{3,11,29,4,4,26,26,12,13,10,30,19,27,2,10},
                new int[]{10,13,22,17,18,15,21,11,24,14,18,23,1,30,6}));
    }
}
