package algorithm.leetcode.easy.s;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortString {

    public String sortString(String s) {
        Set<Character> set = new TreeSet<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            set.add(s.charAt(i));
        }
        List<Character> list = new ArrayList<>(set);
        StringBuilder sb = new StringBuilder();
        for (Character character : list) {
            sb.append(character);
            s = s.replaceFirst(character+"","");
        }
        Set<Character> nSet = new TreeSet<>();
        int nl = s.length();
        for (int i = 0; i < nl; i++) {
            nSet.add(s.charAt(i));
        }
        List<Character> nList = new ArrayList<>(nSet);
        int ns = nList.size();
        for (int i = ns-1; i >= 0; i--) {
            Character character = nList.get(i);
            sb.append(character);
            s = s.replaceFirst(character+"","");
        }
        if (s.equals("")) {
            return sb.toString();
        }
        return sb.append(sortString(s)).toString();
    }

}
