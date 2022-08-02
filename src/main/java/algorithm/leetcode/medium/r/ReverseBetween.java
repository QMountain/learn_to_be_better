package algorithm.leetcode.medium.r;

import algorithm.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ReverseBetween {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        ListNode[] arr = new ListNode[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        for (int i = left-1; i <= (right+left-2)/2; i++) {
            ListNode temp = arr[i];
            arr[i] = arr[right-1-(i-left+1)];
            arr[right-1-(i-left+1)] = temp;
        }
        for (int i = 0; i < list.size()-1; i++) {
            arr[i].next = arr[i+1];
        }
        arr[arr.length-1].next = null;
        return arr[0];
    }

    public static void main(String[] args) {
        ReverseBetween reverseBetween = new ReverseBetween();
        ListNode node2 = reverseBetween.reverseBetween(new ListNode(1, new ListNode(2,
                new ListNode(3))), 2, 3);
        System.out.println(node2);
        ListNode node1 = reverseBetween.reverseBetween(new ListNode(3, new ListNode(5)), 1,2);
        System.out.println(node1);
        ListNode node = reverseBetween.reverseBetween(new ListNode(1, new ListNode(2,
                new ListNode(3, new ListNode(4,
                        new ListNode(5))))), 2, 4);
        System.out.println(node);
    }
}
