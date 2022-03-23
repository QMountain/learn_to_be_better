package algorithm.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class DetectCycle {

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode node = head;
        while (node != null) {
            if (!set.add(node)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public static void main(String[] args) {
        DetectCycle detectCycle = new DetectCycle();
        ListNode node2 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        ListNode node3 = new ListNode(3);
        node3.next = node2;
        node2.next = node0;
        node0.next = node4;
        node4.next = node2;
        ListNode node = detectCycle.detectCycle(node3);
        System.out.println(node);
    }
}
