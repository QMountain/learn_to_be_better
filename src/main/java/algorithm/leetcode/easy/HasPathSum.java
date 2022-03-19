package algorithm.leetcode.easy;

import algorithm.TreeNode;

public class HasPathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        if (root.left != null) {
            if (hasPathSum(root.left,targetSum-root.val)) {
                return true;
            }
        }
        return hasPathSum(root.right,targetSum-root.val);
    }

    public static void main(String[] args) {
        HasPathSum hasPathSum = new HasPathSum();
        System.out.println(hasPathSum.hasPathSum(new TreeNode(1, new TreeNode(2), new TreeNode(3)), 5));
    }

}
