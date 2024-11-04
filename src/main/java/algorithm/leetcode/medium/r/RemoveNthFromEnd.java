package algorithm.leetcode.medium.r;

import algorithm.ListNode;

import java.util.ArrayList;
import java.util.List;

public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            return head.next;
        }
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        int size = 1;
        ListNode p = head;
        List<Integer> list = new ArrayList<>();
        while (p.next != null) {
            list.add(p.val);
            size++;
            p = p.next;
        }
        list.add(p.val);
        list.remove(size-n);
        ListNode node = null;
        for (int i = size-2; i >= 0; i--) {
            if (node == null) {
                node = new ListNode(list.get(i));
            } else {
                node = new ListNode(list.get(i),node);
            }
        }
        return node;
    }

    public static void main(String[] args) {
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        System.out.println(removeNthFromEnd.removeNthFromEnd(new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5))))), 2));
        System.out.println(removeNthFromEnd.removeNthFromEnd(new ListNode(1), 1));
        System.out.println(removeNthFromEnd.removeNthFromEnd(new ListNode(1,new ListNode(2)), 1));
    }
}
