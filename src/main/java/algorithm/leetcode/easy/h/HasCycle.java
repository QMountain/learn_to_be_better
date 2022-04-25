package algorithm.leetcode.easy.h;

import algorithm.ListNode;

import java.util.HashSet;
import java.util.Set;

public class HasCycle {

    public boolean hasCycle(ListNode head) {
        Set<ListNode> list = new HashSet<>();
        while (head != null) {
            if (!list.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {
        HasCycle hasCycle = new HasCycle();
        /*ListNode node1 = new ListNode(-4);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        node2.next = node1;
        node3.next = node2;
        node4.next = node3;
        node1.next = node3;
        System.out.println(hasCycle.hasCycle(node4));*/

        int[] arr = {-21,10,17,8,4,26,5,35,33,-7,-16,27,-12,6,29,-12,5,9,20,14,14,2,13,-24,21,23,-21,5};
        ListNode node = new ListNode(arr[0]);
        ListNode next = new ListNode(arr[1]);
        node.next = next;
        for (int i = 2; i < arr.length; i++) {
            next.next = new ListNode(arr[i]);
            next = next.next;
        }
        System.out.println(hasCycle.hasCycle(node));
    }
}

