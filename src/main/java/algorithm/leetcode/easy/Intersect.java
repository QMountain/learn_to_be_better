package algorithm.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Intersect {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map1 = new HashMap<>(nums1.length);
        Map<Integer,Integer> map2 = new HashMap<>(nums2.length);
        for (int i : nums1) {
            map1.put(i,map1.getOrDefault(i,0)+1);
        }
        for (int i : nums2) {
            map2.put(i,map2.getOrDefault(i,0)+1);
        }
        Map<Integer,Integer> map = new HashMap<>(nums1.length);
        int arrLength = 0;
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            Integer key = entry.getKey();
            Integer v1 = entry.getValue();
            if (map2.containsKey(key)) {
                Integer v2 = map2.get(key);
                int min = Math.min(v1, v2);
                map.put(key, min);
                arrLength += min;
            }
        }
        int[] arr = new int[arrLength];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            for (int i = 0; i < value; i++) {
                arr[index] = key;
                index++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Intersect intersect = new Intersect();
        System.out.println(Arrays.toString(intersect.intersect(new int[]{1,2,2,1}, new int[]{2,2})));
    }
}
