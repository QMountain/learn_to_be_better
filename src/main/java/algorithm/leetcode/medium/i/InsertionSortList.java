package algorithm.leetcode.medium.i;

import algorithm.ListNode;

public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode curr = head;
        ListNode next = head.next;
        while (next != null) {
            if (curr.val > next.val) {
                curr.next = next.next;
                head = insert(head,next);
                curr = head;
                next = head.next;
                continue;
            }
            curr = next;
            next = next.next;
        }
        return head;
    }

    public ListNode insert(ListNode head, ListNode node) {
        if (node.val < head.val) {
            node.next = head;
            return node;
        }
        if (head.next == null) {
            head.next = node;
            return head;
        }
        ListNode curr = head;
        ListNode next = head.next;
        while (next != null) {
            if (node.val < next.val) {
                node.next = next;
                curr.next = node;
                return head;
            }
            curr = next;
            next = next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        InsertionSortList insertionSortList = new InsertionSortList();
        ListNode node1 = insertionSortList.insertionSortList(new ListNode(-1,
                new ListNode(5, new ListNode(3, new ListNode(4,
                        new ListNode(0))))));
        System.out.println(node1);

        ListNode node = insertionSortList.insertionSortList(new ListNode(4,
                new ListNode(2, new ListNode(1, new ListNode(3)))));
        System.out.println(node);
    }
}
