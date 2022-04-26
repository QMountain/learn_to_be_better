package algorithm.leetcode.medium.r;

import algorithm.ListNode;

import java.util.ArrayList;
import java.util.List;

public class RotateRight {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int size = list.size();
        k = k % size;
        ListNode newHead = null;
        ListNode newTail = null;
        ListNode oldTail;
        int frontSize = size-k;

        for (int i = 0; i < size; i++) {
            if (i == frontSize-1) {
                oldTail = head;
                oldTail.next = null;
                newHead = head.next;
            }
            if (i == size-1) {
                newTail = head;
            }
            head = head.next;
        }

        newTail.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        RotateRight rotateRight = new RotateRight();
        System.out.println(rotateRight.rotateRight(new ListNode(1,
                new ListNode(2, new ListNode(3,
                        new ListNode(4, new ListNode(5))))), 2));
    }
}
