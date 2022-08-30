package algorithm.leetcode.medium.i;

import algorithm.TreeNode;

public class InsertIntoMaxTree {

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root.val < val) {
            return new TreeNode(val,root,null);
        }
        if (root.left != null && root.right != null) {
            root.right = insertIntoMaxTree(root.right,val);
            return root;
        }
        if (root.left == null && root.right != null) {
            root.right = insertIntoMaxTree(root.right,val);
            return root;
        }
        root.right = new TreeNode(val);
        return root;
    }

}
