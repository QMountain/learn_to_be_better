package algorithm.leetcode.medium.c;

import java.util.Map;
import java.util.TreeMap;

public class CarPooling {

    public boolean carPooling(int[][] trips, int capacity) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] trip : trips) {
            int num = trip[0];
            int from = trip[1];
            int to = trip[2];
            map.put(from, map.getOrDefault(from, 0) + num);
            map.put(to, map.getOrDefault(to, 0) - num);
        }
        int seats = capacity;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value > 0 && seats < value) {
                return false;
            }
            seats -= value;
        }
        return true;
    }

    public static void main(String[] args) {
        CarPooling carPooling = new CarPooling();
        System.out.println(carPooling.carPooling(new int[][]{{2,1,5},{3,3,7}}, 5));
        System.out.println(!carPooling.carPooling(new int[][]{{2,1,5},{3,3,7}}, 4));
    }
}
