package algorithm.leetcode.medium.m;

import java.util.Arrays;

public class MaxArea {

    // 题号 1465 切割后面积最大的蛋糕
    // 1 <= horizontalCuts.length <= min(h - 1, 10^5)
    // 1 <= verticalCuts.length <= min(w - 1, 10^5)
    // 1 <= horizontalCuts[i] < h
    // 1 <= verticalCuts[i] < w
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int maxW = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length-1]);
        for (int i = 0; i < verticalCuts.length-1; i++) {
            maxW = Math.max(maxW, verticalCuts[i+1] - verticalCuts[i]);
        }
        int maxH = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length-1]);
        for (int i = 0; i < horizontalCuts.length-1; i++) {
            maxH = Math.max(horizontalCuts[i + 1] - horizontalCuts[i], maxH);
        }
        return (int)((long) maxH * maxW % 1000_000_007);
    }

    public int maxArea(int[] height) {
        int max = 0;
        int length = height.length;
        int[] sorted = new int[length];
        System.arraycopy(height,0,sorted,0,length);
        Arrays.sort(sorted);
        for (int i = length-2; i >= 0; i--) {
            int m = Math.min(sorted[i],sorted[i+1]);
            int left = 0;
            int right = length-1;
            while (height[left] < m || height[right] < m) {
                if (height[left] < m) {
                    left++;
                }
                if (height[right] < m) {
                    right--;
                }
            }
            max = Math.max(max,m*(right-left));
            if (i > 0) {
                if (max > sorted[i-1] * (length-1)) {
                    return max;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaxArea maxArea = new MaxArea();
        System.out.println(4 == maxArea.maxArea(5, 4,
                new int[]{1,2,4}, new int[]{1,3}));
        System.out.println(6 == maxArea.maxArea(5, 4,
                new int[]{3,1}, new int[]{1}));
        System.out.println(9 == maxArea.maxArea(5, 4,
                new int[]{3}, new int[]{3}));

        System.out.println(49 == maxArea.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(1 == maxArea.maxArea(new int[]{1,1}));
    }
}
