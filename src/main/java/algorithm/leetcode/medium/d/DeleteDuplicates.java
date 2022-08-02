package algorithm.leetcode.medium.d;

import algorithm.ListNode;

public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        if (head.val == head.next.val) {
            ListNode nHead = head.next.next;
            while (nHead != null && nHead.val == head.val) {
                nHead = nHead.next;
            }
            return deleteDuplicates(nHead);
        }
        head.next = deleteDuplicates(head.next);
        return head;
    }

    public static void main(String[] args) {
        DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
        System.out.println(deleteDuplicates.deleteDuplicates(new ListNode(1, new ListNode(1))));
        ListNode node1 = deleteDuplicates.deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(1,
                new ListNode(2, new ListNode(3))))));
        System.out.println(node1);
        ListNode node = deleteDuplicates.deleteDuplicates(new ListNode(1, new ListNode(2,
                new ListNode(3, new ListNode(3, new ListNode(4,
                        new ListNode(4, new ListNode(5))))))));
        System.out.println(node);
    }
}
