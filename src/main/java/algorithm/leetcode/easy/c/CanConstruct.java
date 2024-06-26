package algorithm.leetcode.easy.c;

import java.util.HashMap;
import java.util.Map;

public class CanConstruct {

    // ransomNote 和 magazine 由小写英文字母组成
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            count[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int index = ransomNote.charAt(i) - 'a';
            if (count[index]-- == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean canConstruct2(String ransomNote, String magazine) {
        int rl = ransomNote.length();
        Map<Character,Integer> map1 = new HashMap<>(rl);
        for (int i = 0; i < rl; i++) {
            char c = ransomNote.charAt(i);
            map1.put(c,map1.getOrDefault(c,0)+1);
        }
        int ml = magazine.length();
        Map<Character,Integer> map2 = new HashMap<>(ml);
        for (int i = 0; i < ml; i++) {
            char c = magazine.charAt(i);
            map2.put(c,map2.getOrDefault(c,0)+1);
        }
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            Character key = entry.getKey();
            Integer v1 = entry.getValue();
            if (!map2.containsKey(key)) {
                return false;
            }
            Integer v2 = map2.get(key);
            if (v2 < v1) {
                return false;
            }
        }
        return true;
    }

}
