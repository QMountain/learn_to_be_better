package algorithm.leetcode.medium.c;

public class Connect {

    // 题号 117 medium 填充每个节点的下一个右侧节点指针 II
    public Node connect2(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            root.left = connect2(root.left);
        }
        if (root.right != null) {
            root.right = connect2(root.right);
        }
        if (root.left != null && root.right != null) {
            connectTwo2(root.left,root.right);
        }
        return root;
    }

    public boolean connectTwo2(Node left, Node right) {
        if (left.next == null) {
            left.next = right;
        }
        if (left.right != null) {
            if (right.left != null) {
                if (connectTwo2(left.right,right.left)) {
                    return true;
                }
            }
            if (right.right != null) {
                if (connectTwo2(left.right,right.right)) {
                    return true;
                }
            }
        }
        if (left.left != null) {
            if (right.left != null) {
                if (connectTwo2(left.left,right.left)) {
                    return true;
                }
            }
            if (right.right != null) {
                return connectTwo2(left.left, right.right);
            }
        }
        return false;
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            root.left = connect(root.left);
            root.right = connect(root.right);
            connectTwo(root.left,root.right);
        }
        return root;
    }

    public void connectTwo(Node left, Node right) {
        left.next = right;
        if (left.right != null) {
            connectTwo(left.right,right.left);
        }
    }

    public static void main(String[] args) {
        Connect connect = new Connect();
        Node node = connect.connect2(new Node(1,
                new Node(2,
                        new Node(4,
                                new Node(7),
                                null,
                                null),
                        new Node(5),
                        null),
                new Node(3,
                        null,
                        new Node(6,
                                null,
                                new Node(8),
                                null),
                        null),
                null));
        System.out.println(node);
        Node connect1 = connect.connect(new Node(1,
                new Node(2,
                        new Node(4),new Node(5),null),
                new Node(3,
                        new Node(6),new Node(7),null), null));
        System.out.println(connect1);
    }

}
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
