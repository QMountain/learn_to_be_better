package algorithm.leetcode.easy;

import algorithm.TreeNode;

public class MaxDepth {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }

    public static void main(String[] args) {
        MaxDepth maxDepth = new MaxDepth();
        System.out.println(maxDepth.maxDepth(new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15),new TreeNode(7)))));
    }
}
