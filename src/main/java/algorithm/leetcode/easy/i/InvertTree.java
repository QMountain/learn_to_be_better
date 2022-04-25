package algorithm.leetcode.easy.i;

import algorithm.TreeNode;

public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        return root;
    }

    public static void main(String[] args) {
        InvertTree invertTree = new InvertTree();
        System.out.println(invertTree.invertTree(new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9)))));
    }
}
