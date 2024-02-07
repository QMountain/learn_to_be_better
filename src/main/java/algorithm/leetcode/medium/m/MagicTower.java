package algorithm.leetcode.medium.m;

import java.util.PriorityQueue;

public class MagicTower {

    // 1 <= nums.length <= 10^5
    // -10^5 <= nums[i] <= 10^5
    public int magicTower(int[] nums) {
        int ans = 0;
        int lastMonster = 0;
        long sum = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        long sumQueue = 0;
        for (int num : nums) {
            if (num >= 0) {
                sum += num;
                continue;
            }
            // 至此 num < 0
            queue.add(num);
            sumQueue += num;
            if (sum + sumQueue < 0) {
                ans++;
                Integer poll = queue.poll();
                lastMonster += poll;
                sumQueue -= poll;
            }
        }
        if (sum + sumQueue + lastMonster < 0) {
            return -1;
        }
        return ans;
    }

    public static void main(String[] args) {
        MagicTower magicTower = new MagicTower();
        System.out.println(-1 == magicTower.magicTower(new int[]{-200,-300,400,0}));
        System.out.println(1 == magicTower.magicTower(new int[]{100,100,100,-250,-60,-140,-50,-50,100,150}));
    }
}
