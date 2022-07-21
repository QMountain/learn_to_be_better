package algorithm.leetcode.medium.p;

import algorithm.TreeNode;

public class PruneTree {

    public TreeNode pruneTree(TreeNode root) {
        if (root.left != null) {
            root.left = pruneTree(root.left);
        }
        if (root.right != null) {
            root.right = pruneTree(root.right);
        }
        if (root.left == null && root.right == null && root.val == 0) {
            root = null;
        }
        return root;
    }

    public static void main(String[] args) {
        PruneTree pruneTree = new PruneTree();
        TreeNode treeNode = pruneTree.pruneTree(new TreeNode(1, null,
                new TreeNode(0, new TreeNode(0), new TreeNode(1))));
        System.out.println(treeNode);
    }
}
