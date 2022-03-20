package algorithm.leetcode.easy;

import algorithm.TreeNode;

public class MinDepth {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null) {
            return minDepth(root.right)+1;
        }
        if (root.right == null) {
            return minDepth(root.left)+1;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        return Math.min(leftDepth,rightDepth)+1;
    }

    public static void main(String[] args) {
        MinDepth minDepth = new MinDepth();
        System.out.println(minDepth.minDepth(new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
        System.out.println(minDepth.minDepth(new TreeNode(2,
                null,
                new TreeNode(3, null,
                        new TreeNode(4,null,new TreeNode(5,null,new TreeNode(6)))))));
    }
}
