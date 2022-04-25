package algorithm.leetcode.easy.r;

import algorithm.ListNode;

public class RemoveElements {

    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }
        ListNode node = head;
        while (true) {
            if (node.next == null) {
                break;
            }
            if (node.next.val == val) {
                if (node.next.next != null) {
                    node.next.val = node.next.next.val;
                    node.next = node.next.next;
                } else {
                    node.next = null;
                }
            } else {
                node = node.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        RemoveElements removeElements = new RemoveElements();
        System.out.println(removeElements.removeElements(new ListNode(1,
                new ListNode(2, new ListNode(2, new ListNode(1)))), 2));
        System.out.println(removeElements.removeElements(new ListNode(1,
                new ListNode(2, new ListNode(6,
                        new ListNode(3, new ListNode(4,
                                new ListNode(5, new ListNode(6))))))), 6));
        System.out.println(removeElements.removeElements(null, 1));
        System.out.println(removeElements.removeElements(new ListNode(7,
                new ListNode(7,new ListNode(7,
                        new ListNode(7)))), 7));
    }
}
