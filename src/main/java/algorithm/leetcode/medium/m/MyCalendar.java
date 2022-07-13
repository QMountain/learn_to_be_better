package algorithm.leetcode.medium.m;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class MyCalendar {

    TreeMap<Integer,Integer> map;
    Integer start;
    Integer end;

    public MyCalendar() {
        map = new TreeMap<>();
        start = null;
        end = null;
    }

    public boolean book(int start, int end) {
        if (this.start == null) {
            map.put(start,end);
            this.start = start;
            this.end = end;
            return true;
        }
        if (end <= this.start) {
            map.put(start,end);
            this.start = start;
            return true;
        }
        if (start >= this.end) {
            map.put(start,end);
            this.end = end;
            return true;
        }
        if (map.containsKey(start)) {
            return false;
        }
        ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        int size = entries.size();
        int left = 0;
        int right = size-1;
        while (left < right) {
            int mid = (left+right) / 2;
            if (entries.get(mid).getKey() > start) {
                right = mid;
                continue;
            }
            left = mid;
            if (mid == size-1) {
                break;
            }
            if (entries.get(mid+1).getKey() > start) {
                break;
            }
            if (left + 1 == right) {
                break;
            }
        }
        Integer prevEnd = entries.get(left).getValue();
        if (start < prevEnd) {
            return false;
        }
        Integer nextStart = entries.get(left + 1).getKey();
        if (end > nextStart) {
            return false;
        }
        map.put(start,end);
        return true;
    }

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(20, 29));
        System.out.println(myCalendar.book(13, 22));
        System.out.println(myCalendar.book(44, 50));
        System.out.println(myCalendar.book(1, 7));
        System.out.println(myCalendar.book(2, 10));
        System.out.println(myCalendar.book(14, 20));
        System.out.println(myCalendar.book(19, 25));
        System.out.println(myCalendar.book(36, 42));
        System.out.println(myCalendar.book(45, 50));
        System.out.println(myCalendar.book(47, 50));
        System.out.println(myCalendar.book(39, 45));
    }

}
