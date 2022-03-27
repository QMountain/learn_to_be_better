package algorithm.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WordPattern {

    public boolean wordPattern(String pattern, String s) {
        String[] split = s.split(" ");
        int length = pattern.length();
        if (length != split.length) {
            return false;
        }
        Map<Character,String> map = new HashMap<>(length);
        Map<String,Character> scMap = new HashMap<>(length);
        for (int i = 0; i < length; i++) {
            char c = pattern.charAt(i);
            String sp = split[i];
            if (map.containsKey(c)) {
                String s1 = map.get(c);
                if (!Objects.equals(s1, sp)) {
                    return false;
                }
            } else {
                if (scMap.containsKey(sp)) {
                    return false;
                }
                map.put(c, sp);
                scMap.put(sp,c);
            }
        }
        return true;
    }

}
