package algorithm.leetcode.medium.m;

import java.util.Arrays;

public class MinimumRemoval {

    // 1 <= beans.length <= 10^5
    // 1 <= beans[i] <= 10^5
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        int length = beans.length;
        long[] preSum = new long[length];
        for (int i = 1; i < length; i++) {
            preSum[i] = preSum[i-1] + beans[i-1];
        }
        long totalSum = preSum[length-1] + beans[length-1];
        long ans = totalSum;
        for (int i = 0; i < length; i++) {
            long clearSum = preSum[i];
            long rightSum = totalSum - clearSum - beans[i];
            long rightLength = length - i - 1;
            long multi = rightLength * beans[i];
            long clearRight = rightSum - multi;
            ans = Math.min(ans, clearSum + clearRight);
        }
        return ans;
    }

    public static void main(String[] args) {
        MinimumRemoval minimumRemoval = new MinimumRemoval();
        System.out.println(4 == minimumRemoval.minimumRemoval(new int[]{4,1,6,5}));
        System.out.println(7 == minimumRemoval.minimumRemoval(new int[]{2,10,3,2}));
    }
}
