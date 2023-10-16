package algorithm.leetcode.medium.a;

import java.util.*;

public class AvoidFlood {

    // 1 <= rains.length <= 10^5
    // 0 <= rains[i] <= 10^9
    public int[] avoidFlood(int[] rains) {
        int length = rains.length;
        int[] ans = new int[length];
        // key lake value 充满的那天
        HashMap<Integer, Integer> fullLakeMap = new HashMap<>();
        TreeSet<Integer> pollDaySet = new TreeSet<>();
        for (int i = 0; i < length; i++) {
            // 第 i 天， 湖泊 rains[i]
            int lake = rains[i];
            // 第 i 天， 湖泊 rains[i] 下雨
            if (lake > 0) {
                // 下雨，无法排空任何湖泊
                ans[i] = -1;
                // 如果之前，湖泊lake 是空的，那这次填满即可
                if (!fullLakeMap.containsKey(lake)) {
                    fullLakeMap.put(lake, i);
                    continue;
                }
                Integer lastFullDay = fullLakeMap.get(lake);
                Integer pollDay = pollDaySet.higher(lastFullDay);
                if (pollDay == null) {
                    return new int[0];
                }
                pollDaySet.remove(pollDay);
                ans[pollDay] = lake;
                fullLakeMap.put(lake, i);
            } else {
                // 不下雨，排空一个湖泊
                ans[i] = 1;
                pollDaySet.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(3);
        Integer higher = set.higher(2);
        System.out.println(higher);
        AvoidFlood avoidFlood = new AvoidFlood();
        System.out.println(Arrays.toString(avoidFlood.avoidFlood(
                        new int[]{1, 0, 2, 0, 3, 0, 2, 0, 0, 0, 1, 2, 3}))
                .equals("[-1, 1, -1, 2, -1, 3, -1, 2, 1, 1, -1, -1, -1]"));
        System.out.println(Arrays.toString(avoidFlood.avoidFlood(
                new int[]{0,0,0,0,92500,92500,0,0,0,0}))
                .equals("[]"));

        System.out.println(Arrays.toString(avoidFlood.avoidFlood(
                new int[]{1,0,2,0,2,1})).equals("[-1, 1, -1, 2, -1, -1]"));
        System.out.println(Arrays.toString(avoidFlood.avoidFlood(
                new int[]{1,2,0,0,2,1})).equals("[-1, -1, 2, 1, -1, -1]"));
        System.out.println(Arrays.toString(avoidFlood.avoidFlood(
                new int[]{0,1,1})));
        System.out.println(Arrays.toString(avoidFlood.avoidFlood(
                new int[]{69,0,0,0,69})));
        System.out.println(Arrays.toString(avoidFlood.avoidFlood(
                new int[]{1,2,0,1,2})));

        System.out.println(Arrays.toString(avoidFlood.avoidFlood(
                new int[]{1, 2, 3, 4})).equals("[-1, -1, -1, -1]"));
    }
}
