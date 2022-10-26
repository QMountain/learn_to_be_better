package algorithm.leetcode.easy.m;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MaxSubsequence {

    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(a -> nums[a]));
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            queue.add(i);
        }
        int length = nums.length;
        for (int i = k; i < length; i++) {
            int num = nums[queue.peek()];
            if (nums[i] > num) {
                queue.poll();
                queue.add(i);
            }
        }
        int[] ans = new int[k];
        int putIndex = 0;
        for (Integer index : queue) {
            ans[putIndex++] = index;
        }
        Arrays.sort(ans);
        for (int i = 0; i < k; i++) {
            ans[i] = nums[ans[i]];
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxSubsequence maxSubsequence = new MaxSubsequence();
        System.out.println(Arrays.toString(maxSubsequence.maxSubsequence(new int[]{3,4,3,3}, 2)));
        System.out.println(Arrays.toString(maxSubsequence.maxSubsequence(new int[]{-1,-2,3,4}, 3)));
        System.out.println(Arrays.toString(maxSubsequence.maxSubsequence(new int[]{2, 1, 3, 3}, 2)));
    }
}
