package algorithm.leetcode.medium.c;

import java.util.Map;
import java.util.TreeMap;

public class CountWays {

    public int countWays(int[][] ranges) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] range : ranges) {
            addToMap(map, range);
        }
        TreeMap<Integer, Integer> rebuildMap = new TreeMap<>();
        while (!map.isEmpty()) {
            Map.Entry<Integer, Integer> entry = map.pollFirstEntry();
            if (rebuildMap.isEmpty()) {
                rebuildMap.put(entry.getKey(), entry.getValue());
            } else {
                if (rebuildMap.lastEntry().getValue() - entry.getKey() == 0) {
                    rebuildMap.put(rebuildMap.lastKey(), entry.getValue());
                } else {
                    rebuildMap.put(entry.getKey(), entry.getValue());
                }
            }
        }
        int size = rebuildMap.size();
        int ans = 1;
        for (int i = 0; i < size; i++) {
            ans <<= 1;
            ans %= 1000000007;
        }
        return ans;
    }

    public void addToMap(TreeMap<Integer, Integer> map, int[] range) {
        Map.Entry<Integer, Integer> higherEntry = map.higherEntry(range[0]);
        if (higherEntry != null) {
            if (range[1] > higherEntry.getKey()) {
                range[1] = higherEntry.getKey();
            }
            if (range[1] > higherEntry.getValue()) {
                addToMap(map, new int[]{higherEntry.getValue(), range[1]});
            }

        }
        Map.Entry<Integer, Integer> lowerEntry = map.lowerEntry(range[0]);
        if (lowerEntry != null) {
            if (lowerEntry.getValue() >= range[1]) {
                return;
            }
            if (lowerEntry.getValue() > range[0]) {
                addToMap(map, new int[]{lowerEntry.getValue(), range[1]});
                range[0] = lowerEntry.getValue();
                return;
            }
        }
        map.put(range[0], range[1]);
    }

    public static void main(String[] args) {
        /*int size = 522;

        int ans = 1;
        for (int i = 0; i < size; i++) {
            ans <<= 1;
            ans %= 1000000007;
            if (ans == 644101518) {
                System.out.println(i);
            }
        }*/

        CountWays countWays = new CountWays();
        System.out.println(2 == countWays.countWays(
                new int[][]{{34,56},{28,29},{12,16},{11,48},{28,54},{22,55},{28,41},{41,44}}));
        System.out.println(8 == countWays.countWays(
                new int[][]{{6,6},{20,37},{53,56},{60,62},{6,19},{32,37},{55,57},{70,71},{0,19}}));

        System.out.println(8 == countWays.countWays(new int[][]{{5,12},{16,28},{32,41},{7,15},{17,26},{41,46},{1,12}}));
        System.out.println(16 == countWays.countWays(new int[][]{{0,0},{8,9},{12,13},{1,3}}));
        System.out.println(2 == countWays.countWays(new int[][]{{0,2},{2,3}}));
        System.out.println(4 == countWays.countWays(new int[][]{{1,3},{10,20},{2,5},{4,8}}));
        System.out.println(countWays.countWays(new int[][]{{6,10},{5,15}}));
    }
}
