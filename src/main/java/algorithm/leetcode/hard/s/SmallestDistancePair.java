package algorithm.leetcode.hard.s;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class SmallestDistancePair {

    public int smallestDistancePair(int[] nums, int k) {
        TreeMap<Integer,Integer> numCountMap = new TreeMap<>();
        for (int num : nums) {
            numCountMap.put(num,numCountMap.getOrDefault(num,0)+1);
        }
        int count0 = 0;
        for (Map.Entry<Integer, Integer> entry : numCountMap.entrySet()) {
            Integer value = entry.getValue();
            count0 += (value-1)*value/2;
        }
        if (count0 >= k) {
            return 0;
        }
        k -= count0;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(
                numCountMap.entrySet());
        int size = entries.size();
        int totalCount = 0;
        for (int i = 0; i < size - 1; i++) {
            Map.Entry<Integer, Integer> currentEntry = entries.get(i);
            for (int j = i+1; j < size; j++) {
                Map.Entry<Integer, Integer> nextEntry = entries.get(j);
                int abs = Math.abs(currentEntry.getKey() - nextEntry.getKey());
                if (totalCount >= k && abs >= map.lastKey()) {
                    break;
                }
                int count = currentEntry.getValue() * nextEntry.getValue();
                map.put(abs,map.getOrDefault(abs,0)+count);
                totalCount += count;
                while (totalCount > k) {
                    Map.Entry<Integer, Integer> lastEntry = map.lastEntry();
                    Integer lastKey = lastEntry.getKey();
                    Integer lastValue = lastEntry.getValue();
                    if (totalCount - k >= lastValue) {
                        map.pollLastEntry();
                        totalCount -= lastValue;
                    } else {
                        map.put(lastKey,lastValue-(totalCount-k));
                        totalCount = k;
                        break;
                    }
                }
            }
        }
        return map.lastKey();
    }

    public static void main(String[] args) {
        SmallestDistancePair smallestDistancePair = new SmallestDistancePair();
        System.out.println(2 == smallestDistancePair.smallestDistancePair(new int[]{10,6,2,10,5,4,0,1,5,2,5,5,5,0,4,9,8,6,7,9,1,10,4,8,6,3,6,2,1,7,5,0,2,6,10,10,0,3,9,0,8,3,5,9,4,4,5,2,2,7}, 444));
        System.out.println(2 == smallestDistancePair.smallestDistancePair(new int[]{9,10,7,10,6,1,5,4,9,8}, 18));
        System.out.println(5 == smallestDistancePair.smallestDistancePair(new int[]{1,6,1}, 3));

        System.out.println(0 == smallestDistancePair.smallestDistancePair(new int[]{1,3,1}, 1));

        System.out.println(0 == smallestDistancePair.smallestDistancePair(new int[]{1,1,1}, 2));
    }
}
