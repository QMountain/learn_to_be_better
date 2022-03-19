package algorithm.leetcode.easy;

import algorithm.TreeNode;

public class IsSameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        boolean sameLeft = isSameTree(p.left, q.left);
        if (!sameLeft) {
            return false;
        }
        return isSameTree(p.right,q.right);
    }

    public static void main(String[] args) {
        IsSameTree isSameTree = new IsSameTree();
        System.out.println(isSameTree.isSameTree(
                new TreeNode(1, new TreeNode(2), new TreeNode(1)),
                new TreeNode(1, new TreeNode(2), new TreeNode(1))));
        System.out.println(isSameTree.isSameTree(
                new TreeNode(1, new TreeNode(2), null),
                new TreeNode(1, null, new TreeNode(2))));
    }
}
