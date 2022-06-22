package algorithm.leetcode.medium.s;

import algorithm.ListNode;

public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode nHead = head.next;
        ListNode node = head;
        ListNode next = head.next;
        while (node != null && next != null) {
            ListNode nextNode = next.next;
            node.next = nextNode;
            next.next = node;
            node = nextNode;
            if (node != null) {
                next = node.next;
            } else {
                next = null;
            }
        }
        nHead.next = head;
        return head;
    }

    public static void main(String[] args) {
        SwapPairs swapPairs = new SwapPairs();
        ListNode node = swapPairs.swapPairs(new ListNode(1, new ListNode(2,
                new ListNode(3, new ListNode(4)))));
        System.out.println(node);
    }
}
