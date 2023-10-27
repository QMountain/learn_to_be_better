package algorithm.leetcode.easy.p;

import java.util.PriorityQueue;

public class PickGifts {

    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
        for (int gift : gifts) {
            queue.add(gift);
        }
        for (int i = 0; i < k; i++) {
            Integer poll = queue.poll();
            queue.add((int)Math.sqrt(poll));
        }
        long ans = 0L;
        for (Integer i : queue) {
            ans += i;
        }
        return ans;
    }

    public static void main(String[] args) {
        PickGifts pickGifts = new PickGifts();
        System.out.println(4 == pickGifts.pickGifts(new int[]{1,1,1,1}, 4));
        System.out.println(29 == pickGifts.pickGifts(new int[]{25,64,9,4,100}, 4));
    }
}
