package algorithm.leetcode.medium.m;

import java.util.HashSet;
import java.util.Set;

public class MaximumDetonation {

    public int maximumDetonation(int[][] bombs) {
        int length = bombs.length;
        int ans = 1;
        for (int i = 0; i < length; i++) {
            // i 是起爆点
            // 记录已经爆炸了的炸弹
            boolean[] bombed = new boolean[length];
            bombed[i] = true;
            int count = 1;
            Set<Integer> lastBombed = new HashSet<>();
            lastBombed.add(i);
            while (!lastBombed.isEmpty()) {
                Set<Integer> curr = new HashSet<>();
                for (Integer last : lastBombed) {
                    for (int j = 0; j < length; j++) {
                        if (!bombed[j]) {
                            int x = Math.abs(bombs[last][0] - bombs[j][0]);
                            int y = Math.abs(bombs[last][1] - bombs[j][1]);
                            long dist = (long) x * x + ((long) y * y);
                            long rr = (long) bombs[last][2] * bombs[last][2];
                            if (dist <= rr) {
                                curr.add(j);
                                bombed[j] = true;
                                count++;
                            }
                        }
                    }
                    lastBombed = curr;
                }
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximumDetonation maximumDetonation = new MaximumDetonation();
        System.out.println(1 == maximumDetonation.maximumDetonation(
                new int[][]{{1,1,100000},{100000,100000,1}}));
        System.out.println(5 == maximumDetonation.maximumDetonation(
                new int[][]{{1,2,3},{2,3,1},{3,4,2},{4,5,3},{5,6,4}}));
        System.out.println(1 == maximumDetonation.maximumDetonation(
                new int[][]{{1,1,5},{10,10,5}}));
        System.out.println(2 == maximumDetonation.maximumDetonation(
                new int[][]{{2,1,3},{6,1,4}}));
    }
}
