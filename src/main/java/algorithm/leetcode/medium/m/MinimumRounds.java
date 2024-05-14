package algorithm.leetcode.medium.m;

import java.util.HashMap;
import java.util.Map;

public class MinimumRounds {

    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0)+1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() < 2) {
                return -1;
            }
            ans += entry.getValue() / 3;
            if (entry.getValue() % 3 != 0) {
                ans++;
            }
        }
        return ans;
    }

}
