package algorithm.leetcode.medium.p;

import algorithm.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Partition {

    // 题号 131 medium 分割回文串
    // 动态规划存储算过的子串，减少重复计算
    public List<List<String>> partition(String s) {
        List<List<String>> ansList = new ArrayList<>();
        int length = s.length();
        if (check(s)) {
            ansList.add(Collections.singletonList(s));
        }
        for (int i = 1; i < length; i++) {
            String substring = s.substring(0, i);
            if (check(substring)) {
                List<List<String>> partition = partition(s.substring(i));
                for (List<String> list : partition) {
                    ArrayList<String> strings = new ArrayList<>(list);
                    strings.add(0,substring);
                    ansList.add(strings);
                }
            }
        }
        return ansList;
    }

    public boolean check(String s) {
        int length = s.length();
        for (int i = 0; i < length / 2; i++) {
            if (s.charAt(i) != s.charAt(length-1-i)) {
                return false;
            }
        }
        return true;
    }

    public ListNode partition(ListNode head, int x) {
        ListNode smaller = null;
        ListNode smallerCurr = null;
        ListNode biggerOrEqual = null;
        ListNode biggerOrEqualCurr = null;
        ListNode node = head;
        while (node != null) {
            if (node.val < x) {
                if (smaller == null) {
                    smaller = node;
                } else {
                    smallerCurr.next = node;
                }
                smallerCurr = node;
            } else {
                if (biggerOrEqual == null) {
                    biggerOrEqual = node;
                } else {
                    biggerOrEqualCurr.next = node;
                }
                biggerOrEqualCurr = node;
            }
            node = node.next;
        }
        if (biggerOrEqualCurr != null) {
            biggerOrEqualCurr.next = null;
        }
        if (smallerCurr == null) {
            return biggerOrEqual;
        }
        smallerCurr.next = biggerOrEqual;
        return smaller;
    }

    public static void main(String[] args) {
        Partition partition = new Partition();
        System.out.println(partition.partition("bb"));
        System.out.println(partition.partition("aab"));
        /*ListNode partition2 = partition.partition(null, 0);
        System.out.println(partition2);
        ListNode partition1 = partition.partition(new ListNode(1, new ListNode(4, new ListNode(3,
                new ListNode(2, new ListNode(5, new ListNode(2)))))), 3);
        System.out.println(partition1);*/
    }
}
