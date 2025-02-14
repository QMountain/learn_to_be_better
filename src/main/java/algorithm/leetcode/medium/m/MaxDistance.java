package algorithm.leetcode.medium.m;

import java.util.Arrays;

public class MaxDistance {

    // n == position.length
    // 2 <= n <= 10^5
    // 1 <= position[i] <= 10^9
    // 所有 position 中的整数 互不相同 。
    // 2 <= m <= position.length
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int length = position.length;
        int totalSpan = position[length-1] - position[0];
        int spanCount = m - 1;
        int bestAveSpan = totalSpan / spanCount;
        int left = 0;
        int right = bestAveSpan;
        while (left < right) {
            int mid = (left + right) >> 1;
            int count = 1;
            int last = 0;
            for (int i = 1; i < length; i++) {
                if (position[i] - position[last] >= mid) {
                    count++;
                    last = i;
                    if (count >= m) {
                        break;
                    }
                }
            }
            if (count >= m) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        int count = 1;
        int last = 0;
        for (int i = 1; i < length; i++) {
            if (position[i] - position[last] >= right) {
                count++;
                last = i;
                if (count >= m) {
                    break;
                }
            }
        }
        return count >= m ? right : right - 1;
    }

    public static void main(String[] args) {
        MaxDistance maxDistance = new MaxDistance();
        System.out.println(5 == maxDistance.maxDistance(new int[]{79,74,57,22}, 4));
        System.out.println(3 == maxDistance.maxDistance(new int[]{5,4,3,2,1,1000000000}, 2));
        System.out.println(3 == maxDistance.maxDistance(new int[]{1,20,305,4199,7999}, 4));
        System.out.println(3 == maxDistance.maxDistance(new int[]{1,2,3,4,7}, 3));
    }
}
