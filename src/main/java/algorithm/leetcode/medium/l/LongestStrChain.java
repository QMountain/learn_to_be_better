package algorithm.leetcode.medium.l;

import java.util.*;

public class LongestStrChain {

    public int longestStrChain(String[] words) {
        TreeMap<Integer, HashMap<String, Integer>> map = new TreeMap<>();
        for (String word : words) {
            HashMap<String, Integer> prefixMap = map.get(word.length());
            if (prefixMap == null) {
                prefixMap = new HashMap<>();
            }
            prefixMap.put(word, 1);
            map.put(word.length(), prefixMap);
        }
        ArrayList<Map.Entry<Integer, HashMap<String, Integer>>> entries = new ArrayList<>(map.entrySet());
        int max = 1;
        for (int i = 1; i < entries.size(); i++) {
            Map.Entry<Integer, HashMap<String, Integer>> lastEntry = entries.get(i - 1);
            Map.Entry<Integer, HashMap<String, Integer>> currEntry = entries.get(i);
            int lastLength = lastEntry.getKey();
            int currLength = currEntry.getKey();
            if (lastLength + 1 < currLength) {
                HashMap<String, Integer> value = lastEntry.getValue();
                for (Map.Entry<String, Integer> entry : value.entrySet()) {
                    Integer prefixLength = entry.getValue();
                    max = Math.max(max, prefixLength);
                }
                continue;
            }
            HashMap<String, Integer> lastValue = lastEntry.getValue();
            HashMap<String, Integer> currValue = currEntry.getValue();
            for (Map.Entry<String, Integer> cEntry : currValue.entrySet()) {
                for (Map.Entry<String, Integer> lEntry : lastValue.entrySet()) {
                    if (isPredecessor(lEntry.getKey(), cEntry.getKey())) {
                        Integer value = lEntry.getValue();
                        max = Math.max(max, value+1);
                        cEntry.setValue(Math.max(cEntry.getValue(), value+1));
                    }
                }
            }
        }
        return max;
    }

    public boolean isPredecessor(String predecessor, String curr) {
        int index = -1;
        for (int i = 0; i < predecessor.length(); i++) {
            if (predecessor.charAt(i) != curr.charAt(i)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return true;
        }
        String p = predecessor.substring(index);
        String c = curr.substring(index + 1);
        return p.equals(c);
    }

    public static void main(String[] args) {
        LongestStrChain longestStrChain = new LongestStrChain();
        System.out.println(longestStrChain.longestStrChain(new String[]{"ksqvsyq","ks","kss","czvh","zczpzvdhx","zczpzvh","zczpzvhx","zcpzvh","zczvh","gr","grukmj","ksqvsq","gruj","kssq","ksqsq","grukkmj","grukj","zczpzfvdhx","gru"}));
        System.out.println(longestStrChain.longestStrChain(new String[]{"abcd","dbqca"}));
        System.out.println(longestStrChain.longestStrChain(new String[]{"xbc","pcxbcf","xb","cxbc","pcxbc"}));
        System.out.println(longestStrChain.longestStrChain(new String[]{"a","b","ba","bca","bda","bdca"}));
    }
}
