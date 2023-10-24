package algorithm.leetcode.medium.m;

import java.util.PriorityQueue;

public class MaxKelements {

    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)-> b-a);
        for (int num : nums) {
            queue.add(num);
        }
        long ans = 0L;
        for (int i = 0; i < k; i++) {
            Integer poll = queue.poll();
            int n = poll / 3;
            if (poll % 3 != 0) {
                n++;
            }
            queue.add(n);
            ans += poll;
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxKelements maxKelements = new MaxKelements();
        System.out.println(17 == maxKelements.maxKelements(new int[]{1,10,3,3,3}, 3));
        System.out.println(50 == maxKelements.maxKelements(new int[]{10,10,10,10,10}, 5));
    }
}
