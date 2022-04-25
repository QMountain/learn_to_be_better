package algorithm.leetcode.easy.s;

import algorithm.TreeNode;

public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        int res = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                res += root.left.val;
            } else {
                res += sumOfLeftLeaves(root.left);
            }
        }
        if (root.right != null) {
            res += sumOfLeftLeaves(root.right);
        }
        return res;
    }

    public static void main(String[] args) {
        SumOfLeftLeaves sumOfLeftLeaves = new SumOfLeftLeaves();
        System.out.println(sumOfLeftLeaves.sumOfLeftLeaves(new TreeNode(1,
                new TreeNode(2,new TreeNode(4),new TreeNode(5)),
                new TreeNode(3))));
    }
}
