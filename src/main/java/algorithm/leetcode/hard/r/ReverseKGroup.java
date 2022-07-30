package algorithm.leetcode.hard.r;

import algorithm.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        List<ListNode> list = new ArrayList<>(k);
        ListNode node = head;
        while (node != null && count < k) {
            list.add(node);
            node = node.next;
            count++;
        }
        if (count < k) {
            return head;
        }
        ListNode next = reverseKGroup(node,k);
        for (int i = k-1; i > 0; i--) {
            list.get(i).next = list.get(i-1);
        }
        list.get(0).next = next;
        return list.get(k-1);
    }

    public static void main(String[] args) {
        ReverseKGroup reverseKGroup = new ReverseKGroup();
        ListNode node = reverseKGroup.reverseKGroup(new ListNode(1,new ListNode(2,
                new ListNode(3, new ListNode(4, new ListNode(5))))), 3);
        System.out.println(node);
    }
}
