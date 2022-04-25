package algorithm.leetcode.easy.l;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {

    public int longestPalindrome(String s) {
        int length = s.length();
        Map<Character,Integer> map = new HashMap<>(length /2);
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int maxLength = 0;
        int hasLeft = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value % 2 == 0) {
                maxLength += value;
            } else {
                hasLeft = 1;
                maxLength += value-1;
            }
        }
        return maxLength + hasLeft;
    }

}
