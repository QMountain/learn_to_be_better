package algorithm.leetcode.medium.m;

import java.util.HashMap;
import java.util.Map;

public class MinNumberOfFrogs {

    // 5.6%
    public int minNumberOfFrogs(String croakOfFrogs) {
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            char c = croakOfFrogs.charAt(i);
            if (c == 'c') {
                if (!map.containsKey('k')) {
                    count++;

                } else {
                    Integer k = map.get('k');
                    if (k == 1) {
                        map.remove('k');
                    } else {
                        map.put('k', k-1);
                    }
                }
                map.put(c, map.getOrDefault(c, 0)+1);
                continue;
            }
            char before;
            if (c == 'r') {
                before = 'c';
            } else if (c == 'o') {
                before = 'r';
            } else if (c == 'a') {
                before = 'o';
            } else {
                before = 'a';
            }
            if (map.containsKey(before)) {
                Integer oldCount = map.get(before);
                if (oldCount == 1) {
                    map.remove(before);
                } else {
                    map.put(before, oldCount - 1);
                }
                map.put(c, map.getOrDefault(c,0)+1);
            } else {
                return -1;
            }

        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getKey() != 'k') {
                return -1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MinNumberOfFrogs minNumberOfFrogs = new MinNumberOfFrogs();
        System.out.println(1 == minNumberOfFrogs.minNumberOfFrogs("croakcroak"));
        System.out.println(2 == minNumberOfFrogs.minNumberOfFrogs("crcoakroak"));
        System.out.println(-1 == minNumberOfFrogs.minNumberOfFrogs("croakcrook"));
    }
}
