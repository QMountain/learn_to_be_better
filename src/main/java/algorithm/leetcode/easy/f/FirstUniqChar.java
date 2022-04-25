package algorithm.leetcode.easy.f;

import java.util.*;

public class FirstUniqChar {

    public int firstUniqChar(String s) {
        int length = s.length();
        Map<Character,Integer> map = new HashMap<>(length);

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            Integer integer = map.get(c);
            if (integer == 1) {
                return i;
            }
        }
        return 0;
    }

}
