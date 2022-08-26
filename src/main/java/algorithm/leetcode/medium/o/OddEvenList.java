package algorithm.leetcode.medium.o;

import algorithm.ListNode;

public class OddEvenList {

    // odd 奇数
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode oddCurr = head;
        ListNode evenCurr = head.next;
        while (true) {
            if (oddCurr.next == null) {
                break;
            }
            if (evenCurr.next == null) {
                break;
            }
            oddCurr.next = evenCurr.next;
            oddCurr = oddCurr.next;
            if (oddCurr.next != null) {
                evenCurr.next = oddCurr.next;
                evenCurr = evenCurr.next;
            }
        }
        evenCurr.next = null;
        oddCurr.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        OddEvenList oddEvenList = new OddEvenList();
        ListNode node1 = oddEvenList.oddEvenList(new ListNode(2, new ListNode(1,
                new ListNode(3, new ListNode(5, new ListNode(6,
                        new ListNode(4, new ListNode(7))))))));
        System.out.println(node1);
        ListNode node = oddEvenList.oddEvenList(new ListNode(1, new ListNode(2,
                new ListNode(3, new ListNode(4, new ListNode(5))))));
        System.out.println(node);
    }
}
