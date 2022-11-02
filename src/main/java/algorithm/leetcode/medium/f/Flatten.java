package algorithm.leetcode.medium.f;

import algorithm.TreeNode;

public class Flatten {

    // 题号 430 扁平化多级双向链表
    public Node flatten(Node head) {
        Node curr = head;
        while (curr != null) {
            if (curr.child != null) {
                flatten(curr.child);
                Node oldNext = curr.next;
                curr.next = curr.child;
                curr.child = null;
                curr.next.prev = curr;
                Node last = curr.next;
                while (last.next != null) {
                    last = last.next;
                }
                last.next = oldNext;
                if (oldNext != null) {
                    oldNext.prev = last;
                }
                curr = oldNext;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int val) {
            this.val = val;
        }
    }

    public void flatten(TreeNode root) {
        if (root != null) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            if (left != null && (left.left != null || left.right != null)) {
                flatten(left);
            }

            if (right != null && (right.left != null || right.right != null)) {
                flatten(right);
            }
            root.left = null;
            root.right = left;
            TreeNode curNode = left;
            if (curNode != null) {
                while (curNode.right != null) {
                    curNode = curNode.right;
                }
                curNode.right = right;
            } else {
                root.right = right;
            }
        }
        System.out.println(root);
    }

    public static void main(String[] args) {
        Flatten flatten = new Flatten();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node11 = new Node(11);
        Node node12 = new Node(12);
        node1.child = node2;
        node2.child = node3;
        /*node1.next = node2;
        node2.prev = node1;
        node2.next = node3;
        node3.prev = node2;
        node3.next = node4;
        node4.prev = node3;
        node4.next = node5;
        node5.prev = node4;
        node5.next = node6;
        node6.prev = node5;
        node7.next = node8;
        node8.prev = node7;
        node8.next = node9;
        node9.prev = node8;
        node9.next = node10;
        node10.prev = node9;
        node3.child = node7;
        node8.child = node11;
        node11.next = node12;
        node12.prev = node11;*/
        Node flatten1 = flatten.flatten(node1);
        System.out.println(flatten1);

        flatten.flatten(new TreeNode(1,
                new TreeNode(2,new TreeNode(3),new TreeNode(4)),
                new TreeNode(5,null,new TreeNode(6))));
    }
}
