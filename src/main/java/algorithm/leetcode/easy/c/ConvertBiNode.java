package algorithm.leetcode.easy.c;

import algorithm.TreeNode;

public class ConvertBiNode {

    TreeNode leftLastNode;

    public TreeNode convertBiNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            leftLastNode = root;
            return root;
        }
        if (root.left == null) {
            root.right = convertBiNode(root.right);
            return root;
        }
        TreeNode head = convertBiNode(root.left);
        root.left = null;
        leftLastNode.right = root;
        if (root.right != null) {
            root.right = convertBiNode(root.right);
        } else {
            leftLastNode = root;
        }
        return head;
    }

    public static void main(String[] args) {
        ConvertBiNode convertBiNode = new ConvertBiNode();
        TreeNode treeNode = convertBiNode.convertBiNode(new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1, new TreeNode(0), null),
                        new TreeNode(3)),
                new TreeNode(5, null, new TreeNode(6))));
        System.out.println(treeNode);
    }
}
