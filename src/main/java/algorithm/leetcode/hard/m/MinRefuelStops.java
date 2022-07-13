package algorithm.leetcode.hard.m;

import java.util.Map;
import java.util.TreeMap;

public class MinRefuelStops {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int length = stations.length;
        if (length == 0) {
            return startFuel >= target ? 0 : -1;
        }
        // addTimes  maxFuel
        Map<Integer,Integer> map = new TreeMap<>();
        map.put(0,startFuel);
        int currentPosition = 0;
        int minAddTimes = 0;
        int maxAddTimes = 0;
        for (int[] station : stations) {
            int nextStepNeedFuel = station[0] - currentPosition;
            currentPosition = station[0];
            if (map.get(maxAddTimes) < nextStepNeedFuel) {
                return -1;
            }
            for (int j = minAddTimes; j <= maxAddTimes; j++) {
                if (map.get(j) < nextStepNeedFuel) {
                    minAddTimes++;
                    continue;
                }
                // 不加
                for (int k = minAddTimes; k <= maxAddTimes; k++) {
                    map.put(k, map.get(k) - nextStepNeedFuel);
                    int key = k + 1;
                    int nv = map.get(k) + station[1];
                    map.put(key, Math.max(nv, map.getOrDefault(key, 0)));
                }

                /*// 这次加 j+1 - max+1
                map.put(maxAddTimes+1, map.get(maxAddTimes)+stations[i][1]-nextStepNeedFuel);
                // 这次不加 j-max
                map.put(j,map.get(j)-nextStepNeedFuel);
                for (int k = j; k <= maxAddTimes; k++) {
                    int noAdd = map.get(k);
                    int add = map.get(k-1) + stations[i][1];
                    map.put(k,Math.max(noAdd,add)-nextStepNeedFuel);
                }*/
                maxAddTimes++;
                break;
            }
        }
        int leftTarget = target - stations[length-1][0];
        for (int i = minAddTimes; i <= maxAddTimes; i++) {
            if (map.get(i) >= leftTarget) {
                return i;
            }
        }
        return minAddTimes;
    }

    public static void main(String[] args) {
        MinRefuelStops minRefuelStops = new MinRefuelStops();
        System.out.println(minRefuelStops.minRefuelStops(100, 50, new int[][]{{25,25},{50,50}}));
        System.out.println(minRefuelStops.minRefuelStops(1, 1, new int[][]{}));
        System.out.println(minRefuelStops.minRefuelStops(100, 10, new int[][]{{10,60},{20,30},{30,30},{60,40}}));
    }
}
