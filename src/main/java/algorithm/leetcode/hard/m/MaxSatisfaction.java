package algorithm.leetcode.hard.m;

import java.util.Arrays;

public class MaxSatisfaction {

    // n == satisfaction.length
    // 1 <= n <= 500
    // -1000 <= satisfaction[i] <= 1000
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int length = satisfaction.length;
        if (satisfaction[length-1] <= 0) {
            return 0;
        }
        int startIndex = 0;
        int sum = satisfaction[length-1];
        for (int i = length-2; i >= 0; i--) {
            sum += satisfaction[i];
            if (sum < 0) {
                startIndex = i+1;
                break;
            }
        }
        int ans = 0;
        int time = 1;
        for (int i = startIndex; i < length; i++) {
            ans += satisfaction[i] * time++;
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxSatisfaction maxSatisfaction = new MaxSatisfaction();
        System.out.println(0 == maxSatisfaction.maxSatisfaction(new int[]{-1,-4,-5}));
        System.out.println(20 == maxSatisfaction.maxSatisfaction(new int[]{4,3,2}));
        System.out.println(14 == maxSatisfaction.maxSatisfaction(new int[]{-1,-8,0,5,-9}));
    }
}
