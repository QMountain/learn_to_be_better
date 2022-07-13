package algorithm.leetcode.medium.s;

import algorithm.ListNode;

public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode third = next.next;
        head.next = swapPairs(third);
        next.next = head;
        head = next;
        return head;
    }

    public static void main(String[] args) {
        SwapPairs swapPairs = new SwapPairs();
        ListNode node = swapPairs.swapPairs(new ListNode(1, new ListNode(2,
                new ListNode(3, new ListNode(4)))));
        System.out.println(node);
    }
}
