package algorithm.leetcode.medium.c;

public class CanTransform {

    // 题号 777 在LR字符串中交换相邻字符
    // 官解是双指针，O(n) 即可
    public boolean canTransform(String start, String end) {
        int length = start.length();
        int index1 = -1;
        for (int i = 0; i < length; i++) {
            if (start.charAt(i) != 'X') {
                index1 = i;
                break;
            }
        }
        int index2 = -1;
        for (int i = 0; i < length; i++) {
            if (end.charAt(i) != 'X') {
                index2 = i;
                break;
            }
        }
        if (index1 == -1 && index2 == -1) {
            return true;
        }
        if (index1 == -1 || index2 == -1) {
            return false;
        }
        if (start.charAt(index1) != end.charAt(index2)) {
            return false;
        }
        if (start.charAt(index1) == 'L') {
            if (index1 < index2) {
                return false;
            }
            int cl = index2+1;
            start = start.substring(0,index1-cl+1) + start.substring(index1+1);
            end = end.substring(index2+1);
            return canTransform(start,end);
        }
        if (index1 > index2) {
            return false;
        }
        if (index1 == index2) {
            if (index1 == length-1) {
                return true;
            }
            start = start.substring(index1+1);
            end = end.substring(index2+1);
            return canTransform(start,end);
        }
        int needXCount = index2 - index1;
        int checkIndex = index1+1;
        while (needXCount > 0 && checkIndex < start.length()) {
            char c = start.charAt(checkIndex);
            if (c == 'L') {
                return false;
            }
            if (c == 'X') {
                start = start.substring(0,checkIndex) + start.substring(checkIndex+1);
                end = end.substring(1);
                needXCount--;
                continue;
            }
            checkIndex++;
        }
        if (needXCount != 0) {
            return false;
        }
        start = start.substring(index1+1);
        end = end.substring(index1+1);
        return canTransform(start,end);
    }

    public static void main(String[] args) {
        CanTransform canTransform = new CanTransform();
        System.out.println(canTransform.canTransform("XXXXRXLXXXLLXXRLXXLXLXRXLXXRRX", "XXXXRLLLXXXXXXRLLLXXXXXRLXXXRR"));
        System.out.println(canTransform.canTransform("RXR", "XXR"));
        System.out.println(canTransform.canTransform("XXRXXXXRXXXXXXRXXXXLXXXXLXLXXXXXXRXXXXLX", "XXXXXXXXXXXXRRRLLLXXXXXXXXXXXXXXXXXXRLXX"));
        System.out.println(canTransform.canTransform("XXRXXLXXLLRXXLXXLXLXRXXLXXRXRX", "XRXLXXXXLLXXXRLLLXRXXLRXXXXXRX"));
        System.out.println(canTransform.canTransform("XXRXLXRXXX", "XXRLXXXXXR"));
        System.out.println(canTransform.canTransform("XXXXXLXXXX", "LXXXXXXXXX"));
        System.out.println(canTransform.canTransform("XXXLXXXXXX", "XXXLXXXXXX"));
        System.out.println(!canTransform.canTransform("XLLR", "LXLX"));
        System.out.println(!canTransform.canTransform("LXXLXRLXXL", "XLLXRXLXLX"));
    }
}
