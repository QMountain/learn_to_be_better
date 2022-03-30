package algorithm.leetcode.easy;

import java.util.*;

public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        int length = t.length();
        Map<Character, List<Integer>> map = new HashMap<>(length);
        for (int i = 0; i < length; i++) {
            char c = t.charAt(i);
            if (map.containsKey(c)) {
                List<Integer> list = new ArrayList<>(map.get(c));
                list.add(i);
                map.put(c,list);
            } else {
                map.put(c, Collections.singletonList(i));
            }
        }
        int index = 0;
        int sLen = s.length();
        for (int i = 0; i < sLen; i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                return false;
            }
            List<Integer> list = map.get(c);
            int minIndex = -1;
            for (Integer p : list) {
                if (p >= index) {
                    minIndex = p;
                    break;
                }
            }
            if (minIndex == -1) {
                return false;
            }
            index = minIndex+1;
        }
        return true;
    }

    public static void main(String[] args) {
        IsSubsequence isSubsequence = new IsSubsequence();
        System.out.println(isSubsequence.isSubsequence("aaaaaa", "bbaaaa"));
        System.out.println(isSubsequence.isSubsequence("abc", "ahbgdc"));
    }
}
