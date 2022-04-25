package algorithm.leetcode.easy.d;

import algorithm.ListNode;

public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        while (current.next != null) {
            if (current.val != current.next.val) {
                current = current.next;
            } else {
                current.next = current.next.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
        System.out.println(deleteDuplicates.deleteDuplicates(new ListNode(1,
                new ListNode(1, new ListNode(2)))));
        System.out.println(deleteDuplicates.deleteDuplicates(new ListNode(1,
                new ListNode(1, new ListNode(2,
                        new ListNode(3, new ListNode(3)))))));
    }
}
