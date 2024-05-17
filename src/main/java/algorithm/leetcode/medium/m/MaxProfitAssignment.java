package algorithm.leetcode.medium.m;

import java.util.Arrays;
import java.util.Comparator;

public class MaxProfitAssignment {

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int length = difficulty.length;
        int[][] arr = new int[length][2];
        for (int i = 0; i < length; i++) {
            arr[i][0] = difficulty[i];
            arr[i][1] = profit[i];
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(worker);
        int ans = 0;
        int index = 0;
        int max = 0;
        for (int w : worker) {
            for (int i = index; i < length; i++) {
                index = i;
                if (arr[i][0] <= w) {
                    max = Math.max(max, arr[i][1]);
                } else {
                    break;
                }
            }
            ans += max;
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxProfitAssignment maxProfitAssignment = new MaxProfitAssignment();
        System.out.println(maxProfitAssignment.maxProfitAssignment(
                new int[]{2,4,6,8,10}, new int[]{10,20,30,40,50}, new int[]{4,5,6,7}));
    }
}
