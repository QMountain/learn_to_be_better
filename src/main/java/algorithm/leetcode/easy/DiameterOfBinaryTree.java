package algorithm.leetcode.easy;

import algorithm.TreeNode;

public class DiameterOfBinaryTree {

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        if (root.left == null) {
            int rootToLeaf = getMaxLengthToLeafNode(root.right)+1;
            int fromRight = diameterOfBinaryTree(root.right);
            return Math.max(rootToLeaf,fromRight);
        }
        if (root.right == null) {
            int rootToLeaf = getMaxLengthToLeafNode(root.left)+1;
            int fromLeft = diameterOfBinaryTree(root.left);
            return Math.max(rootToLeaf,fromLeft);
        }
        int maxLeft = getMaxLengthToLeafNode(root.left);
        int maxRight = getMaxLengthToLeafNode(root.right);

        int rootMax = maxLeft+maxRight+ 2;
        int leftMax = diameterOfBinaryTree(root.left);
        int rightMax = diameterOfBinaryTree(root.right);
        return Math.max(Math.max(rightMax,leftMax),rootMax);
    }

    public int getMaxLengthToLeafNode(TreeNode treeNode) {
        if (treeNode == null || (treeNode.left == null && treeNode.right == null)) {
            return 0;
        }
        if (treeNode.left == null) {
            return getMaxLengthToLeafNode(treeNode.right)+1;
        }
        if (treeNode.right == null) {
            return getMaxLengthToLeafNode(treeNode.left)+1;
        }
        int maxLeft = getMaxLengthToLeafNode(treeNode.left);
        int maxRight = getMaxLengthToLeafNode(treeNode.right);

        return Math.max(maxLeft,maxRight)+1;
    }

    public static void main(String[] args) {
        DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();
        System.out.println(diameterOfBinaryTree.diameterOfBinaryTree(
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4),new TreeNode(5)),
                        new TreeNode(3))));
        System.out.println(diameterOfBinaryTree.diameterOfBinaryTree(new TreeNode(1,new TreeNode(2),null)));
        System.out.println(diameterOfBinaryTree.diameterOfBinaryTree(
                new TreeNode(2,
                        new TreeNode(3,new TreeNode(1),null),null)));
    }
}
