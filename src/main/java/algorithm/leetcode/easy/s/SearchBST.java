package algorithm.leetcode.easy.s;

import algorithm.TreeNode;

public class SearchBST {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        if (root.val < val) {
            return searchBST(root.right,val);
        }
        return searchBST(root.left,val);
    }

}
