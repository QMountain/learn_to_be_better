package algorithm.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class IsIsomorphic {

    public boolean isIsomorphic(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        if (sl != tl) {
            return false;
        }
        Map<Character,Character> stMap = new HashMap<>(sl);
        Map<Character,Character> tsMap = new HashMap<>(sl);
        for (int i = 0; i < sl; i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if (stMap.containsKey(cs)) {
                Character c = stMap.get(cs);
                if (c != ct) {
                    return false;
                }
            } else {
                if (tsMap.containsKey(ct)) {
                    return false;
                }
                stMap.put(cs, ct);
                tsMap.put(ct,cs);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsIsomorphic isIsomorphic = new IsIsomorphic();
        System.out.println(isIsomorphic.isIsomorphic("badc", "baba"));
        System.out.println(isIsomorphic.isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic.isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic.isIsomorphic("paper", "title"));
    }
}
