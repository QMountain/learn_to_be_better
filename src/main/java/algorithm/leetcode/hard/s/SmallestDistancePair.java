package algorithm.leetcode.hard.s;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class SmallestDistancePair {

    public int smallestDistancePair(int[] nums, int k) {
        Map<Integer,Integer> numCountMap = new TreeMap<>();
        for (int num : nums) {
            numCountMap.put(num,numCountMap.getOrDefault(num,0)+1);
        }
        ArrayList<Integer> list = new ArrayList<>(numCountMap.keySet());
        int size = list.size();
        Map<Integer,Integer> map = new TreeMap<>();
        for (Integer num : list) {
            Integer count = numCountMap.get(num);
            map.put(0, map.getOrDefault(0, 0) + (count - 1) * count / 2);
        }
        Integer count0 = map.get(0);
        if (count0 >= k) {
            return 0;
        }
        k -= count0;
        int count = 0;
        int lastKey = 0;
        int lastAddCount = 0;
        for (int i = 0; i < size-1; i++) {
            for (int j = i+1; j < size; j++) {
                Integer num1 = list.get(i);
                Integer count1 = numCountMap.get(num1);
                Integer num2 = list.get(j);
                Integer count2 = numCountMap.get(num2);
                int abs = Math.abs(num1 - num2);
                int cnt = count1*count2;
                if (count >= k && abs >= lastKey) {
                    continue;
                }
                count += cnt;
                lastAddCount = cnt;
                lastKey = Math.max(lastKey,abs);
                while (count > k && count - lastAddCount > k)
                if (count > k) {
                    while (true) {
                        ArrayList<Integer> keys = new ArrayList<>(map.keySet());
                        Integer maxKey = keys.get(keys.size() - 1);
                        Integer cn = map.get(maxKey);
                        if (cn > count - k) {
                            break;
                        }
                        map.remove(maxKey);
                        count -= cn;
                    }
                }
            }
        }
        ArrayList<Integer> keys = new ArrayList<>(map.keySet());
        return keys.get(keys.size() - 1);
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
