package algorithm.leetcode.easy;

import algorithm.TreeNode;

public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return compareTwoNode(root.left,root.right);
    }

    public boolean compareTwoNode(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return compareTwoNode(left.left, right.right) && compareTwoNode(left.right,right.left);
    }

    public static void main(String[] args) {
        IsSymmetric isSymmetric = new IsSymmetric();
        System.out.println(isSymmetric.isSymmetric(new TreeNode(1,
                new TreeNode(2,new TreeNode(3),new TreeNode(4)),
                new TreeNode(2,new TreeNode(4),new TreeNode(3)))));
        System.out.println(isSymmetric.isSymmetric(new TreeNode(1,
                new TreeNode(2, null, new TreeNode(3)),
                new TreeNode(2, null, new TreeNode(3)))));
    }
}

