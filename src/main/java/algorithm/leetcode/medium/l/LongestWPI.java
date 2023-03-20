package algorithm.leetcode.medium.l;

import java.util.*;

public class LongestWPI {

    // 1 <= hours.length <= 10^4
    public int longestWPI(int[] hours) {
        int ans = 0;
        // tiredDays - unTiredDays, firstIndex
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int tiredDays = 0;
        for (int i = 0; i < hours.length; i++) {
            if (hours[i] > 8) {
                tiredDays++;
            }
            int currLength = i + 1;
            int unTiredDays = currLength - tiredDays;
            if (tiredDays > unTiredDays) {
                ans = Math.max(ans, currLength);
            } else {
                int key = - (unTiredDays - tiredDays + 1);
                if (map.containsKey(key)) {
                    Integer leftIndex = map.get(key);
                    int len = i - leftIndex;
                    ans = Math.max(ans, len);
                }
            }
            int key = tiredDays - unTiredDays;
            if (!map.containsKey(key)) {
                map.put(key, i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestWPI longestWPI = new LongestWPI();
        System.out.println(/*29 == */longestWPI.longestWPI(new int[]{11,2,4,14,2,15,7,10,1,16,9,0,2,8,4,14,6,12,2,8,6,4,14,13,7,16,14,2,3,2,8,3,12,3,3,9,14,1,5,3,12,0,15,5,0,2,3,16,7,2,1,1,4,9,0,11,9,16,15,7,0,5,6,4,12,1,1,2,13,8,3,9,12,9,3,11,4,14,7,5,16,0,11,8,8,14,1,5,0,6,5,8,10,15,9,14,16,11,1,13}));
        System.out.println(0 == longestWPI.longestWPI(new int[]{6,6,6}));
        System.out.println(3 == longestWPI.longestWPI(new int[]{9, 9, 6, 0, 6, 6, 9}));
    }
}
