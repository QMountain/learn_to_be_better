package algorithm.leetcode.medium.r;

import algorithm.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReorderList {

    public void reorderList(ListNode head) {
        LinkedList<ListNode> list = new LinkedList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        if (list.size() == 1) {
            return;
        }
        ListNode p = head;
        while (p != list.peekLast()) {
            ListNode last = list.pollLast();
            ListNode oldNext = p.next;
            if (last == oldNext) {
                oldNext.next = null;
                return;
            }
            p.next = last;
            last.next = oldNext;
            p = oldNext;
        }
        p.next = null;
    }

    public void reorderList2(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        if (list.size() == 1) {
            return;
        }
        List<ListNode> reorder = new ArrayList<>();
        int left = 0;
        int right = list.size()-1;
        while (left < right) {
            reorder.add(list.get(left++));
            reorder.add(list.get(right--));
        }
        if (list.size() % 2 != 0) {
            reorder.add(list.get(left));
        }
        for (int i = 0; i < reorder.size()-1; i++) {
            reorder.get(i).next = reorder.get(i+1);
        }
        reorder.get(reorder.size()-1).next = null;
        head.next = reorder.get(1);
    }

    public static void main(String[] args) {
        ReorderList reorderList = new ReorderList();
        ListNode listNode1 = new ListNode(1, new ListNode(2,
                new ListNode(3, new ListNode(4,
                        new ListNode(5)))));
        reorderList.reorderList(listNode1);
        System.out.println(listNode1);
        ListNode listNode = new ListNode(1,
                new ListNode(2, new ListNode(3,
                        new ListNode(4))));
        reorderList.reorderList(listNode);
        System.out.println(listNode);
    }

}
