package algorithm.leetcode.medium.c;

import java.util.HashMap;
import java.util.Map;

public class CanReorderDoubled {

    public boolean canReorderDoubled(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>(arr.length);
        for (int i : arr) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        if (map.containsKey(0)) {
            Integer countZero = map.get(0);
            if (countZero % 2 != 0) {
                return false;
            } else {
                map.remove(0);
            }
        }
        for (Integer key : map.keySet()) {
            if (key % 2 != 0) {
                while (map.get(key) > 0 && map.getOrDefault(key*2,0) > 0) {
                    map.put(key,map.get(key)-1);
                    map.put(key*2,map.get(key*2)-1);
                }
                if (map.get(key) > 0) {
                    return false;
                }
            }
        }
        boolean allZero = true;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (value <= 0) {
                continue;
            }
            allZero = false;
            while (map.getOrDefault(key*2,0) > 0 &&
                    map.getOrDefault(key/2,0) == 0 && map.get(key) > 0) {
                map.put(key,map.get(key)-1);
                map.put(key*2,map.get(key*2)-1);
            }
            while (map.getOrDefault(key*2,0) == 0 &&
                    map.getOrDefault(key/2,0) > 0 && map.get(key) > 0) {
                map.put(key,map.get(key)-1);
                map.put(key/2,map.get(key/2)-1);
            }
        }
        if (allZero) {
            return true;
        }
        allZero = true;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (value <= 0) {
                continue;
            }
            allZero = false;
            while (map.getOrDefault(key*2,0) > 0 && map.get(key) > 0) {
                map.put(key,map.get(key)-1);
                map.put(key*2,map.get(key*2)-1);
            }
            while (map.getOrDefault(key/2,0) > 0 && map.get(key) > 0) {
                map.put(key,map.get(key)-1);
                map.put(key/2,map.get(key/2)-1);
            }
        }
        if (allZero) {
            return true;
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CanReorderDoubled canReorderDoubled = new CanReorderDoubled();
        System.out.println(canReorderDoubled.canReorderDoubled(new int[]{-62,86,96,-18,43,-24,-76,13,-31,-26,-88,-13,96,-44,9,-20,-42,100,-44,-24,-36,28,-32,58,-72,20,48,-36,-45,14,24,-64,-90,-44,-16,86,-33,48,26,29,-84,10,46,50,-66,-8,-38,92,-19,43,48,-38,-22,18,-32,-48,-64,-10,-22,-48}));
        System.out.println(canReorderDoubled.canReorderDoubled(new int[]{-2,-2,1,-2,-1,2}));
        System.out.println(canReorderDoubled.canReorderDoubled(new int[]{2,1,2,1,1,1,2,2}));
        System.out.println(canReorderDoubled.canReorderDoubled(new int[]{0,0,0,0,0,0}));
        System.out.println(canReorderDoubled.canReorderDoubled(new int[]{4, -2, 2, -4}));
    }
}
