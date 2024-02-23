package algorithm.leetcode.hard.f;

import java.util.*;

public class FullBloomFlowers {

    TreeMap<Integer, int[]> map;

    // 1 <= flowers.length <= 5 * 10^4
    // 1 <= people.length <= 5 * 10^4
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int min = people[0];
        int max = people[0];
        for (int person : people) {
            min = Math.min(min, person);
            max = Math.max(max, person);
        }
        map = new TreeMap<>();
        for (int[] flower : flowers) {
            flower[0] = Math.max(min, flower[0]);
            flower[1] = Math.min(max, flower[1]);
            addToMap(flower);
        }
        int length = people.length;
        int[] ans = new int[length];
        for (int i = 0; i < length; i++) {
            if (map.containsKey(people[i])) {
                ans[i] = map.get(people[i])[1];
            } else {
                Map.Entry<Integer, int[]> lowerEntry = map.lowerEntry(people[i]);
                if (lowerEntry != null) {
                    int[] value = lowerEntry.getValue();
                    if (value[0] >= people[i]) {
                        ans[i] = value[1];
                    }
                }
            }
        }
        return ans;
    }

    public void addToMap(int[] flower) {
        if (map.containsKey(flower[0])) {
            int[] arr = map.get(flower[0]);
            if (arr[0] == flower[1]) {
                arr[1]++;
            } else if (arr[0] < flower[1]) {
                arr[1]++;
                addToMap(new int[]{arr[0] + 1, flower[1]});
            } else {
                map.put(flower[1]+1, new int[]{arr[0], arr[1]});
                arr[0] = flower[1];
                arr[1]++;
            }
            return;
        }
        Map.Entry<Integer, int[]> lowerEntry = map.lowerEntry(flower[0]);
        if (lowerEntry != null) {
            int[] lowerValue = lowerEntry.getValue();
            if (lowerValue[0] >= flower[0]) {
                map.put(flower[0], new int[]{lowerValue[0], lowerValue[1]});
                lowerValue[0] = flower[0] - 1;
                addToMap(flower);
                return;
            }
        }
        Map.Entry<Integer, int[]> higherEntry = map.higherEntry(flower[0]);
        if (higherEntry != null) {
            if (higherEntry.getKey() <= flower[1]) {
                map.put(flower[0], new int[]{higherEntry.getKey() - 1, 1});
                addToMap(new int[]{higherEntry.getKey(), flower[1]});
                return;
            }
        }
        map.put(flower[0], new int[]{flower[1], 1});
    }

    public static void main(String[] args) {
        FullBloomFlowers fullBloomFlowers = new FullBloomFlowers();
        System.out.println(Arrays.toString(fullBloomFlowers.fullBloomFlowers(
                new int[][]{{28,37},{23,33},{39,39},{49,50},{41,45},{14,47}},
                new int[]{19,44,28,41,40,12,48,17,34,30})));

        System.out.println(Arrays.toString(fullBloomFlowers.fullBloomFlowers(
                new int[][]{{19,37},{19,38},{19,35}}, new int[]{6,7,21,1,13,37,5,37,46,43})));

        System.out.println(Arrays.toString(fullBloomFlowers.fullBloomFlowers(
                new int[][]{{27,46},{48,48},{47,49},{14,48},{24,38},{43,43},{7,15},
                        {23,25},{18,42},{9,34},{32,33},{10,37},{41,44},{10,27},{6,10},
                        {49,50},{15,47},{48,49},{25,43},{27,28},{35,47},{5,13},{5,17},
                        {39,39},{3,3},{40,40},{8,39},{39,47},{33,46},{9,37},{3,29},
                        {45,47},{19,46},{18,50},{28,31},{6,38},{1,35},{38,40},
                        {37,50},{3,25},{6,10},{45,47},{29,34},{35,47},{36,45},
                        {25,34},{24,36},{18,32},{14,47},{36,40},{49,49},{45,45},
                        {4,20},{34,38},{14,46},{2,17},{47,48},{50,50},{42,47},{9,31},
                        {47,48},{42,48},{21,23},{38,38}}
                , new int[]{33,43,7,2,24,1,26,7,11,12,40,42,6,6,17,20,22,
                        13,18,31,28,46,50,47,12,26,16,45,21,2,32,30,43,12,49,49,
                        19,14,22,31,31,35,20})));

        System.out.println(Arrays.toString(fullBloomFlowers.fullBloomFlowers(
                new int[][]{{11,11},{24,46},{3,25},{44,46}},
                new int[]{1,8,26,7,43,26,1})).equals("[0, 1, 1, 1, 1, 1, 0]"));

        System.out.println(Arrays.toString(fullBloomFlowers.fullBloomFlowers(
                new int[][]{{1, 10}, {3, 3}}, new int[]{3, 3, 2})).equals("[2, 2, 1]"));

        System.out.println(Arrays.toString(fullBloomFlowers.fullBloomFlowers(
                new int[][]{{29,46},{8,32},{16,36},{49,49},{42,43}}, new int[]{31})));

        System.out.println(Arrays.toString(fullBloomFlowers.fullBloomFlowers(
                new int[][]{{2,8},{31,37}}, new int[]{33,47,45,12})).equals("[1, 0, 0, 0]"));


        System.out.println(Arrays.toString(fullBloomFlowers.fullBloomFlowers(
                new int[][]{{1,6},{3,7},{9,12},{4,13}},
                new int[]{2,3,7,11})).equals("[1, 2, 2, 2]"));
    }
}
