package algorithm.leetcode.easy.f;

import algorithm.TreeNode;

public class FlipTree {

    public TreeNode flipTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = flipTree(right);
        root.right = flipTree(left);
        return root;
    }

}
