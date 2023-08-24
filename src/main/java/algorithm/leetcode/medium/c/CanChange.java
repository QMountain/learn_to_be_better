package algorithm.leetcode.medium.c;

import java.util.HashMap;
import java.util.LinkedList;

public class CanChange {

    // n == start.length == target.length
    // 1 <= n <= 10^5
    // start 和 target 由字符 'L'、'R' 和 '_' 组成
    public boolean canChange2(String start, String target) {
        int length = start.length();
        char[] chars = start.toCharArray();
        int cl = 0;
        int cr = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            char c = target.charAt(i);
            if (c == 'L') {
                cl++;
                map.put(cl+"L", i);
            } else if (c == 'R') {
                cr++;
                map.put(cr+"R", i);
            }
        }
        while (true) {
            boolean changed = false;
            cl = 0;
            cr = 0;
            for (int i = 0; i < length; i++) {
                if (chars[i] == 'L') {
                    cl++;
                    String key = cl + "L";
                    Integer standard = map.get(key);
                    if (standard == null) {
                        return false;
                    }
                    int index = i;
                    while (index > standard && index > 0 && chars[index-1] == '_') {
                        index--;
                    }
                    if (index != i) {
                        changed = true;
                        chars[index] = 'L';
                        chars[i] = '_';
                    }
                } else if (chars[i] == 'R') {
                    cr++;
                    String key = cr + "R";
                    Integer standard = map.get(key);
                    if (standard == null) {
                        return false;
                    }
                    int index = i;
                    while (index < standard && index < length-1 && chars[index+1] == '_') {
                        index++;
                    }
                    if (index != i) {
                        changed = true;
                        chars[index] = 'R';
                        chars[i] = '_';
                        i = index;
                    }
                }
            }
            if (!changed) {
                break;
            }
        }
        return new String(chars).equals(target);
    }

    public boolean canChange(String start, String target) {
        int n = start.length();
        int i = 0, j = 0;
        while (i < n && j < n) {
            while (i < n && start.charAt(i) == '_') {
                i++;
            }
            while (j < n && target.charAt(j) == '_') {
                j++;
            }
            if (i < n && j < n) {
                if (start.charAt(i) != target.charAt(j)) {
                    return false;
                }
                char c = start.charAt(i);
                if ((c == 'L' && i < j) || (c == 'R' && i > j)) {
                    return false;
                }
                i++;
                j++;
            }
        }
        while (i < n) {
            if (start.charAt(i) != '_') {
                return false;
            }
            i++;
        }
        while (j < n) {
            if (target.charAt(j) != '_') {
                return false;
            }
            j++;
        }
        return true;
    }

    public boolean canChange4(String start, String target) {
        int length = start.length();
        char[] chars = start.toCharArray();
        int index1 = 0;
        int index2 = 0;
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        for (int i = index2; i < length; i++) {
            char tc = target.charAt(i);
            if (tc == 'L') {
                if (list2.isEmpty()) {
                    boolean find = false;
                    for (int j = index1; j < length; j++) {
                        char sc = chars[j];
                        if (sc == 'L') {
                            if (j < i) {
                                return false;
                            }
                            chars[j] = '_';
                            chars[i] = 'L';
                            index1 = j+1;
                            find = true;
                            break;
                        } else if (sc == 'R') {
                            return false;
                        }
                    }
                    if (!find) {
                        return false;
                    }
                } else {
                    for (int j = index1; j < length; j++) {
                        index1 = j;
                        char sc = chars[j];
                        if (sc == 'L') {
                            list1.add(j);
                            break;
                        }
                        if (sc == 'R') {
                            list1.add(j);
                        }
                    }
                    if (list1.isEmpty()) {
                        return false;
                    }
                    if (!popTwoList(list1, list2, chars)) {
                        return false;
                    }
                    i--;
                }
            } else if (tc == 'R') {
                list2.addLast(i);
            }
        }
        for (int j = index1; j < length; j++) {
            index1 = j;
            char sc = chars[j];
            if (sc == 'L') {
                return false;
            }
            if (sc == 'R') {
                list1.add(j);
            }
        }
        if (list1.size() != list2.size()) {
            return false;
        }
        while (!list2.isEmpty()) {
            Integer p2 = list2.pollLast();
            Integer p1 = list1.pollLast();
            if (p1 > p2) {
                return false;
            }
        }
        return true;
    }

    public boolean popTwoList(LinkedList<Integer> list1, LinkedList<Integer> list2, char[] chars) {
        Integer last = list1.peekLast();
        if (last == null) {
            return list2.isEmpty();
        }
        if (chars[last] == 'L') {
            if (last - 1 < list2.peekLast()) {
                return false;
            }
            list1.pollLast();
        }
        if (list1.size() != list2.size()) {
            return false;
        }
        while (!list2.isEmpty()) {
            Integer p2 = list2.pollLast();
            Integer p1 = list1.pollLast();
            if (p1 > p2) {
                return false;
            }
        }
        return true;
    }

    public boolean canChange3(String start, String target) {
        LinkedList<LinkedList<String>> outList2 = convert(target);
        LinkedList<LinkedList<String>> outList1 = convert(start);
        if (outList1.size() != outList2.size()) {
            return false;
        }
        while (!outList2.isEmpty()) {
            LinkedList<String> inList1 = outList1.pollFirst();
            LinkedList<String> inList2 = outList2.pollFirst();
            if (inList1.size() != inList2.size()) {
                return false;
            }
            String s = inList2.peekFirst();
            if (s.contains("L")) {
                if (!inList1.peekFirst().contains("L")) {
                    return false;
                }
                while (!inList2.isEmpty()) {
                    String s1 = inList1.pollFirst();
                    String s2 = inList2.pollFirst();
                    String[] ls1 = s1.split(",");
                    String[] ls2 = s2.split(",");
                    int index1 = Integer.parseInt(ls1[1]);
                    int index2 = Integer.parseInt(ls2[1]);
                    if (index1 < index2) {
                        return false;
                    }
                }
            } else {
                if (!inList1.peekFirst().contains("R")) {
                    return false;
                }
                while (!inList2.isEmpty()) {
                    String s1 = inList1.pollLast();
                    String s2 = inList2.pollLast();
                    String[] ls1 = s1.split(",");
                    String[] ls2 = s2.split(",");
                    int index1 = Integer.parseInt(ls1[1]);
                    int index2 = Integer.parseInt(ls2[1]);
                    if (index1 > index2) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public LinkedList<LinkedList<String>> convert(String target) {
        int length = target.length();
        LinkedList<LinkedList<String>> outList = new LinkedList<>();
        Character c = null;
        int countL = 0;
        int countR = 0;
        for (int i = 0; i < length; i++) {
            if (target.charAt(i) == 'L') {
                countL++;
                LinkedList<String> inList;
                if (c == null || c == 'R') {
                    inList = new LinkedList<>();
                    inList.add(countL + "L,"+i);
                    outList.add(inList);
                    c = 'L';
                } else {
                    inList = outList.peekLast();
                    inList.add(countL + "L,"+i);
                }
            } else if (target.charAt(i) == 'R') {
                countR++;
                LinkedList<String> inList;
                if (c == null || c == 'L') {
                    inList = new LinkedList<>();
                    inList.add(countR + "R,"+i);
                    outList.add(inList);
                    c = 'R';
                } else {
                    inList = outList.peekLast();
                    inList.add(countR + "R,"+i);
                }
            }
        }
        return outList;
    }

    public static void main(String[] args) {
        CanChange canChange = new CanChange();
        System.out.println(canChange.canChange("_R_RL_", "_RR_L"));
        System.out.println(canChange.canChange("_RR", "_RR"));
        System.out.println(!canChange.canChange("_L__R__R_L", "L______RR_"));
        System.out.println(canChange.canChange("_R", "L_"));
        System.out.println(canChange.canChange("_R", "R_"));
        System.out.println(canChange.canChange("R_L_", "__LR"));
        System.out.println(canChange.canChange("_L__R__R_", "L______RR"));
    }
}
