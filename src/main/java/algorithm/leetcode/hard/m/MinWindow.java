package algorithm.leetcode.hard.m;

import java.util.*;

public class MinWindow {

    public String minWindow(String s, String t) {
        if (s.equals(t)) {
            return s;
        }
        int tLength = t.length();
        int sLength = s.length();
        if (tLength > sLength) {
            return "";
        }
        Map<Character,Integer> tMap = new HashMap<>();
        for (int i = 0; i < tLength; i++) {
            char c = t.charAt(i);
            tMap.put(c,tMap.getOrDefault(c,0)+1);
        }

        List<Integer> indexList = new ArrayList<>();
        Map<Character,Integer> sMap = new HashMap<>();
        String ans = "";
        for (int i = 0; i < sLength; i++) {
            char c = s.charAt(i);
            if (tMap.containsKey(c)) {
                indexList.add(i);
                Integer oldCount = sMap.getOrDefault(c, 0);
                if (s.charAt(indexList.get(0)) == c && Objects.equals(oldCount, tMap.get(c))) {
                    indexList.remove(0);
                } else {
                    sMap.put(c,oldCount+1);
                }
                if (checkEquals(sMap,tMap)) {
                    int start = indexList.get(0);
                    int end = indexList.get(indexList.size()-1);
                    if (ans.equals("")) {
                        ans = s.substring(start,end+1);
                    } else if (end-start+1 < ans.length()) {
                        ans = s.substring(start,end+1);
                    }
                    char at = s.charAt(start);
                    sMap.put(at,sMap.get(at)-1);
                    indexList.remove(0);
                    while (indexList.size() > 0 && sMap.get(s.charAt(indexList.get(0))) > tMap.get(s.charAt(indexList.get(0)))) {
                        sMap.put(s.charAt(indexList.get(0)),sMap.get(s.charAt(indexList.get(0)))-1);
                        indexList.remove(0);
                    }
                    if (checkEquals(sMap,tMap)) {
                        int start1 = indexList.get(0);
                        int end1 = indexList.get(indexList.size()-1);
                        if (ans.equals("")) {
                            ans = s.substring(start1,end1+1);
                        } else if (end1-start1+1 < ans.length()) {
                            ans = s.substring(start1,end1+1);
                        }
                    }
                }
            }
        }

        return ans;
    }

    public boolean checkEquals(Map<Character,Integer> sMap, Map<Character,Integer> tMap) {
        Set<Character> set = tMap.keySet();
        for (Character key : set) {
            if (!sMap.containsKey(key)) {
                return false;
            }
            if (sMap.get(key) < tMap.get(key)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MinWindow minWindow = new MinWindow();
        System.out.println(minWindow.minWindow("adobecodebancbbcaa", "abc"));
        System.out.println(minWindow.minWindow("acbdbaab", "aabd"));
        System.out.println(minWindow.minWindow("ab", "a"));
        System.out.println(minWindow.minWindow("acbbaca", "aba"));
        System.out.println(minWindow.minWindow("a", "b"));
        System.out.println(minWindow.minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd"));
        System.out.println(minWindow.minWindow("a", "aa"));
        System.out.println(minWindow.minWindow("a", "a"));
        System.out.println(minWindow.minWindow("ADOBECODEBANC", "ABC"));
    }
}
