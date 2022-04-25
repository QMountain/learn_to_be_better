package algorithm.leetcode.easy.i;

import java.util.HashMap;
import java.util.Map;

public class IsAlienSorted {

    public boolean isAlienSorted(String[] words, String order) {
        int length = words.length;
        int ol = order.length();
        Map<Character,Integer> map = new HashMap<>(ol);
        for (int i = 0; i < length-1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];
            if (word1.equals(word2)) {
                continue;
            }
            int maxLength = Math.max(word1.length(),word2.length());
            for (int j = 0; j < maxLength; j++) {
                if (j >= word1.length()) {
                   break;
                }
                if (j >= word2.length()) {
                    return false;
                }
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                int order1;
                if (map.containsKey(c1)) {
                    order1 = map.get(c1);
                } else {
                    order1 = getIndex(c1,order,map,ol);
                }
                int order2;
                if (map.containsKey(c2)) {
                    order2 = map.get(c2);
                } else {
                    order2 = getIndex(c2,order,map,ol);
                }
                if (order1 < order2) {
                    break;
                }
                if (order1 == order2) {
                    continue;
                }
                return false;
            }


        }
        return true;
    }

    public int getIndex(char c, String order, Map<Character,Integer> map, int length) {
        for (int i = 0; i < length; i++) {
            if (order.charAt(i) == c) {
                map.put(c,i);
                return i;
            }
        }
        return 0;
    }
}
