package algorithm.leetcode.medium.m;

import java.util.Arrays;

public class MaxArea {

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
        System.out.println(49 == maxArea.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(1 == maxArea.maxArea(new int[]{1,1}));
    }
}
