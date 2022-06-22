package algorithm.sworddirectingoffer.medium;

import algorithm.Node;

public class SortedLoopList {

    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }
        Node node = head;
        while (true) {
            if (node.val <= insertVal && node.next.val >= insertVal) {
                Node nNode = new Node(insertVal);
                Node old = node.next;
                node.next = nNode;
                nNode.next = old;
                break;
            }
            if (insertVal >= node.val && node.val > node.next.val) {
                Node nNode = new Node(insertVal);
                Node old = node.next;
                node.next = nNode;
                nNode.next = old;
                break;
            }
            if (node.val > node.next.val && insertVal <= node.next.val) {
                Node nNode = new Node(insertVal);
                Node old = node.next;
                node.next = nNode;
                nNode.next = old;
                break;
            }
            if (node.next == head) {
                Node nNode = new Node(insertVal);
                Node old = node.next;
                node.next = nNode;
                nNode.next = old;
                break;
            }
            node = node.next;
        }
        return head;
    }

    public static void main(String[] args) {
        SortedLoopList sortedLoopList = new SortedLoopList();
        Node node1 = new Node(1);
        Node node3 = new Node(3);
        Node node5 = new Node(5);
        node1.next = node3;
        node3.next = node5;
        node5.next = node1;
        Node insert = sortedLoopList.insert(node3, 6);
        System.out.println(insert);

        /*node1.next = node1;
        Node insert = sortedLoopList.insert(node1, 2);
        System.out.println(insert);*/

        /*Node node31 = new Node(3);
        Node node32 = new Node(3);
        Node node33 = new Node(3);
        node31.next = node32;
        node32.next = node33;
        node33.next = node31;
        Node insert = sortedLoopList.insert(node31, 0);
        System.out.println(insert);*/
    }
}
