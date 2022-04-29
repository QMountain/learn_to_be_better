package algorithm.leetcode.easy.s;

import java.util.Arrays;

public class Shuffle {

    public int[] shuffle(int[] nums, int n) {
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
