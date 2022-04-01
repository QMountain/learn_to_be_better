package algorithm.leetcode.easy;

import java.util.*;

public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        int sl = s.length();
        Map<Character,Integer> mapS = new HashMap<>(sl);
        int tl = t.length();
        Map<Character,Integer> mapT = new HashMap<>(tl);
        for (int i = 0; i < sl; i++) {
            char c = s.charAt(i);
            mapS.put(c,mapS.getOrDefault(c,0)+1);
        }
        for (int i = 0; i < tl; i++) {
            char c = t.charAt(i);
            mapT.put(c,mapT.getOrDefault(c,0)+1);
        }
        Set<Character> set1 = mapS.keySet();
        Set<Character> set2 = mapT.keySet();
        if (set1.size() != set2.size()) {
            return false;
        }
        if (!set1.containsAll(set2)) {
            return false;
        }
        for (Map.Entry<Character, Integer> entry : mapS.entrySet()) {
            Character key = entry.getKey();
            Integer v1 = entry.getValue();
            Integer v2 = mapT.get(key);
            if (!Objects.equals(v1, v2)) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram2(String s, String t) {
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        String s2 = new String(arr1);
        String t2 = new String(arr2);
        return Objects.equals(s2, t2);
    }

    public boolean isAnagram3(String s, String t) {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        int sl = s.length();
        int tl = t.length();
        for (int i = 0; i < sl; i++) {
            char c = s.charAt(i);
            arr1[c-97] += 1;
        }
        for (int i = 0; i < tl; i++) {
            char c = t.charAt(i);
            arr2[c-97] += 1;
        }
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println('a'-97);
    }
}
