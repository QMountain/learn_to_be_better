package algorithm.leetcode.easy;

import algorithm.ListNode;

public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val != current.next.val) {
                current = current.next;
            } else {
                current = current.next.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
        System.out.println(deleteDuplicates.deleteDuplicates(new ListNode(1,
                new ListNode(1, new ListNode(2,
                        new ListNode(3, new ListNode(3)))))));
    }
}
