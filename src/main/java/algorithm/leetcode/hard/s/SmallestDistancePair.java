package algorithm.leetcode.hard.s;

import java.util.PriorityQueue;

public class SmallestDistancePair {

    public int smallestDistancePair(int[] nums, int k) {
        int length = nums.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)-> b-a);
        for (int i = 0; i < length - 1; i++) {
            for (int j = i+1; j < length; j++) {
                queue.offer(Math.abs(nums[i]-nums[j]));
                if (queue.size() > k) {
                    queue.poll();
                }
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        SmallestDistancePair smallestDistancePair = new SmallestDistancePair();
        System.out.println(smallestDistancePair.smallestDistancePair(new int[]{1,3,1}, 1));

        System.out.println(smallestDistancePair.smallestDistancePair(new int[]{1,6,1}, 3));
        System.out.println(smallestDistancePair.smallestDistancePair(new int[]{1,1,1}, 2));
    }
}
