package algorithm.leetcode.medium.m;

import algorithm.ListNode;

public class MergeInBetween {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        // find a pre
        ListNode nodeAPre = list1;
        for (int i = 0; i < a-1; i++) {
            nodeAPre = nodeAPre.next;
        }
        // find b
        ListNode nodeB = nodeAPre.next;
        for (int i = 0; i < b - a; i++) {
            nodeB = nodeB.next;
        }
        // find list2 end
        ListNode l2End = list2;
        while (l2End.next != null) {
            l2End = l2End.next;
        }
        l2End.next = nodeB.next;
        nodeAPre.next = list2;
        return list1;
    }

    public static void main(String[] args) {
        MergeInBetween mergeInBetween = new MergeInBetween();
        ListNode node = mergeInBetween.mergeInBetween(new ListNode(0,
                        new ListNode(3, new ListNode(2,
                                new ListNode(1, new ListNode(4,
                                        new ListNode(5)))))),
                3, 4,
                new ListNode(10000,
                        new ListNode(10001,
                                new ListNode(10002))));
        System.out.println(node);
    }

}
