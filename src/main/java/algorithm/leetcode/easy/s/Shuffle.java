package algorithm.leetcode.easy.s;

import java.util.Arrays;

public class Shuffle {

    /**
     * 重新排列数组
     * 给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
     * 请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
     */
    public int[] shuffle(int[] nums, int n) {
        int length = nums.length;
        int[] ans = new int[length];
        int x = length >> 1;
        for (int i = 0; i < x; i++) {
            ans[i << 1] = nums[i];
        }
        for (int i = 0; i < x; i++) {
            ans[(i << 1) + 1] = nums[x+i];
        }
        return ans;
    }

    public int[] shuffle2(int[] nums, int n) {
        int[] arr = new int[2*n];
        int left = 0;
        int right = n;
        for (int i = 0; i < n * 2-1; i+=2) {
            arr[i] = nums[left];
            arr[i+1] = nums[right];
            left++;
            right++;
        }
        return arr;
    }

    public static void main(String[] args) {
        Shuffle shuffle = new Shuffle();
        System.out.println(Arrays.toString(shuffle.shuffle(new int[]{2,5,1,3,4,7}, 3)));
    }
}
