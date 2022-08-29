package algorithm.leetcode.medium.i;

import java.util.LinkedList;

public class IsValidSerialization {

    public boolean isValidSerialization(String preorder) {
        if (preorder.equals("#")) {
            return true;
        }
        if (!preorder.endsWith(",#,#")) {
            return false;
        }
        preorder = preorder.substring(0,preorder.length()-4);
        String[] split = preorder.split(",");
        int countNum = 0;
        int countNull = 0;
        for (String s : split) {
            if (s.equals("#")) {
                countNull++;
            } else {
                countNum++;
            }
            if (countNull > countNum) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidSerialization2(String preorder) {
        if (preorder.equals("#")) {
            return true;
        }
        if (!preorder.endsWith(",#,#")) {
            return false;
        }
        preorder = preorder.substring(0,preorder.length()-4);
        String[] split = preorder.split(",");
        LinkedList<String> list = new LinkedList<>();
        for (String s : split) {
            if (!s.equals("#")) {
                list.add(s);
                continue;
            }
            if (list.isEmpty()) {
                return false;
            }
            list.pollLast();
        }
        return true;
    }

}
