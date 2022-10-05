package algorithm.leetcode.medium.m;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendarTwo {

    TreeMap<Integer,Integer> baseMap;
    TreeMap<Integer,Integer> coverMap;
    Integer start;
    Integer end;

    public MyCalendarTwo() {
        baseMap = new TreeMap<>();
        coverMap = new TreeMap<>();
        start = null;
        end = null;
    }

    public boolean book(int start, int end) {
        for (Map.Entry<Integer, Integer> entry : coverMap.entrySet()) {
            Integer left = entry.getKey();
            if (end <= left) {
                continue;
            }
            Integer right = entry.getValue();
            if (right <= start) {
                continue;
            }
            return false;
        }
        while (baseMap.containsKey(start)) {
            Integer value = baseMap.get(start);
            if (end <= value) {
                coverMap.put(start,end);
                return true;
            } else {
                coverMap.put(start,value);
                start = value;
            }
        }
        TreeMap<Integer,Integer> tempMap = new TreeMap<>();
        for (Map.Entry<Integer, Integer> entry : baseMap.entrySet()) {
            Integer right = entry.getValue();
            if (right <= start) {
                continue;
            }
            Integer left = entry.getKey();
            if (start < left) {
                if (end <= left) {
                    break;
                } else if (end <= right) {
                    coverMap.put(left,end);
                    end = left;
                    break;
                } else {
                    tempMap.put(start,left);
                    coverMap.put(left,right);
                    start = right;
                }
            } else {
                if (end <= right) {
                    coverMap.put(start,end);
                    break;
                } else {
                    coverMap.put(start,right);
                    start = right;
                }
            }
        }
        baseMap.put(start,end);
        baseMap.putAll(tempMap);
        return true;
    }

}
