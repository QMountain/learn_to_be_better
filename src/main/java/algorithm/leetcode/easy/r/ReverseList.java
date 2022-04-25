package algorithm.leetcode.easy.r;

import algorithm.ListNode;

public class ReverseList {

    public ListNode reverseList(ListNode head) {
        /*if (head == null) {
            return null;
        }
        ListNode node = new ListNode(head.val);
        while (head.next != null) {
            node = new ListNode(head.next.val,node);
            head = head.next;
        }
        return node;*/

        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;

    }

    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();
        System.out.println(reverseList.reverseList(new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))))));
    }
}
