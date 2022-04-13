package algorithm.leetcode.easy;

import algorithm.Node;
import algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MaxDepth {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }

    // 559. N 叉树的最大深度
    public int maxDepth(Node root) {
        if (root == null || root.children == null) {
            return 0;
        }
        List<Node> children = root.children;
        int max = 0;
        for (Node child : children) {
            max = Math.max(max,maxDepth(child));
        }
        return max+1;
    }

    public static void main(String[] args) {
        MaxDepth maxDepth = new MaxDepth();
        /*System.out.println(maxDepth.maxDepth(new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15),new TreeNode(7)))));*/
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        List<Node> n3 = new ArrayList<>();
        n3.add(node5);
        n3.add(node6);
        Node node3 = new Node(3,n3);
        Node node2 = new Node(2);
        Node node4 = new Node(4);
        List<Node> n1 = new ArrayList<>();
        n1.add(node3);
        n1.add(node2);
        n1.add(node4);
        System.out.println(maxDepth.maxDepth(new Node(1, n1)));
    }
}
