package algorithm.leetcode.medium.p;

import algorithm.ListNode;

public class Partition {

    public ListNode partition(ListNode head, int x) {
        ListNode smaller = null;
        ListNode smallerCurr = null;
        ListNode biggerOrEqual = null;
        ListNode biggerOrEqualCurr = null;
        ListNode node = head;
        while (node != null) {
            if (node.val < x) {
                if (smaller == null) {
                    smaller = node;
                } else {
                    smallerCurr.next = node;
                }
                smallerCurr = node;
            } else {
                if (biggerOrEqual == null) {
                    biggerOrEqual = node;
                } else {
                    biggerOrEqualCurr.next = node;
                }
                biggerOrEqualCurr = node;
            }
            node = node.next;
        }
        if (biggerOrEqualCurr != null) {
            biggerOrEqualCurr.next = null;
        }
        if (smallerCurr == null) {
            return biggerOrEqual;
        }
        smallerCurr.next = biggerOrEqual;
        return smaller;
    }

    public static void main(String[] args) {
        Partition partition = new Partition();
        ListNode partition2 = partition.partition(null, 0);
        System.out.println(partition2);
        ListNode partition1 = partition.partition(new ListNode(1, new ListNode(4, new ListNode(3,
                new ListNode(2, new ListNode(5, new ListNode(2)))))), 3);
        System.out.println(partition1);
    }
}
