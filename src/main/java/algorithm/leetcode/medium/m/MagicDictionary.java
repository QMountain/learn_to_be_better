package algorithm.leetcode.medium.m;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MagicDictionary {

    Map<Integer, Set<String>> map;

    public MagicDictionary() {
        map = new HashMap<>();
    }

    public void buildDict(String[] dictionary) {
        for (String s : dictionary) {
            int length = s.length();
            HashSet<String> set = new HashSet<>(map.getOrDefault(length, new HashSet<>()));
            set.add(s);
            map.put(length,set);
        }
    }

    public boolean search(String searchWord) {
        Set<String> set = map.getOrDefault(searchWord.length(), new HashSet<>());
        if (set.isEmpty()) {
            return false;
        }
        for (String s : set) {
            int length = s.length();
            int countDiff = 0;
            for (int i = 0; i < length; i++) {
                if (s.charAt(i) != searchWord.charAt(i)) {
                    countDiff++;
                }
                if (countDiff > 1) {
                    break;
                }
            }
            if (countDiff == 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        magicDictionary.buildDict(new String[]{"hello","hallo","leetcode","judge"});
        System.out.println(magicDictionary.search("juage"));
    }
}
