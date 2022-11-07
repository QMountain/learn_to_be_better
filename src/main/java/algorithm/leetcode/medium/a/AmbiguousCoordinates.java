package algorithm.leetcode.medium.a;

import java.util.ArrayList;
import java.util.List;

public class AmbiguousCoordinates {

    public List<String> ambiguousCoordinates(String s) {
        int length = s.length();
        List<String> ansList = new ArrayList<>();
        for (int i = 2; i < length-1; i++) {
            String left = s.substring(1,i);
            List<String> leftList = calOne(left);
            if (!leftList.isEmpty()) {
                String right = s.substring(i,length-1);
                List<String> rightList = calOne(right);
                if (!rightList.isEmpty()) {
                    for (String s1 : leftList) {
                        for (String s2 : rightList) {
                            ansList.add("("+s1+", "+s2+")");
                        }
                    }
                }
            }
        }
        return ansList;
    }

    public List<String> calOne(String s) {
        List<String> resList = new ArrayList<>();
        int length = s.length();
        if (length == 1) {
            resList.add(s);
            return resList;
        }
        if (s.charAt(0) == '0') {
            if (!s.endsWith("0")) {
                resList.add("0."+s.substring(1));
            }
            return resList;
        }
        resList.add(s);
        if (s.endsWith("0")) {
            return resList;
        }
        for (int i = 1; i < length; i++) {
            String left = s.substring(0,i);
            String right = s.substring(i);
            resList.add(left+"."+right);
        }
        return resList;
    }

    public static void main(String[] args) {
        AmbiguousCoordinates ambiguousCoordinates = new AmbiguousCoordinates();
        System.out.println(ambiguousCoordinates.ambiguousCoordinates("(0110)"));
        System.out.println(ambiguousCoordinates.ambiguousCoordinates("(100)"));
        System.out.println(ambiguousCoordinates.ambiguousCoordinates("(0123)"));
        System.out.println(ambiguousCoordinates.ambiguousCoordinates("(00011)"));
        System.out.println(ambiguousCoordinates.ambiguousCoordinates("(123)"));
    }
}
