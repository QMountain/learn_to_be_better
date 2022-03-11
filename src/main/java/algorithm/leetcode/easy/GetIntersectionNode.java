package algorithm.leetcode.easy;

import algorithm.ListNode;

import java.util.HashSet;
import java.util.Set;

public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode temp = headA;
        while (temp != null) {
            visited.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (visited.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public static void main(String[] args) {
        GetIntersectionNode getIntersectionNode = new GetIntersectionNode();
        /*ListNode node8 = new ListNode(8);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node8.next = node4;
        node4.next = node5;
        ListNode node4A = new ListNode(4);
        ListNode node1A = new ListNode(1);
        ListNode node5B = new ListNode(5);
        ListNode node6B = new ListNode(6);
        ListNode node1B = new ListNode(1);
        node4A.next = node1A;
        node1A.next = node8;
        node5B.next = node6B;
        node6B.next = node1B;
        node1B.next = node8;
        System.out.println(getIntersectionNode.getIntersectionNode(node4A, node5B));
*/
        /*ListNode node2 = new ListNode(2);
        ListNode node6 = new ListNode(6);
        ListNode node4 = new ListNode(4);
        ListNode node1 = new ListNode(1);
        ListNode node5 = new ListNode(5);
        node2.next = node6;
        node6.next = node4;
        node1.next = node5;
        System.out.println(getIntersectionNode.getIntersectionNode(node2,node1));*/

        ListNode node1 = new ListNode(1);
        ListNode node30 = new ListNode(30);
        ListNode node31 = new ListNode(31);

        node1.next = node30;
        node30.next = node31;
        System.out.println(getIntersectionNode.getIntersectionNode(node1,node30));
    }
}
