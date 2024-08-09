package algorithm.leetcode.medium.c;

import java.util.*;

public class Change {

    // 1 <= coins.length <= 300
    public int change(int amount, int[] coins) {
        // key sum value count
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int coin : coins) {

            ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
            for (Map.Entry<Integer, Integer> entry : entries) {

            }
        }
        return 0;
    }

    public int change2(int amount, int[] coins) {
        Arrays.sort(coins);
        Map<String, Integer> map = new HashMap<>();
        return changeBySortedCoinsAndIndex(amount, coins, coins.length-1, map);
    }

    public int changeBySortedCoinsAndIndex(int amount, int[] coins, int index, Map<String, Integer> map) {
        if (index == 0) {
            return amount % coins[0] == 0 ? 1 : 0;
        }
        String key = amount + "," + index;
        if (map.containsKey(key)) {
            System.out.println("kkk");
            return map.get(key);
        }
        int count = amount / coins[index];
        int res = 0;
        for (int i = count; i >= 0; i--) {
            res += changeBySortedCoinsAndIndex(amount - (i * coins[index]), coins, index-1, map);
        }
        map.put(key, res);
        return res;
    }

    public static void main(String[] args) {
        Change change = new Change();
        System.out.println(1 == change.change(1000, new int[]{3,5,7,8,9,10,11}));
        System.out.println(1 == change.change(10, new int[]{10}));
        System.out.println(0 == change.change(3, new int[]{2}));
        System.out.println(4 == change.change(5, new int[]{1, 2, 5}));
    }
}
