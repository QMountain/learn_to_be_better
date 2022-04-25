package algorithm.leetcode.easy.i;

import algorithm.TreeNode;

public class IsBalanced {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        }
        return false;
    }

    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getHeight(node.left),getHeight(node.right)) + 1;
    }

    public static void main(String[] args) {
        IsBalanced isBalanced = new IsBalanced();
        System.out.println(isBalanced.isBalanced(new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
        System.out.println(isBalanced.isBalanced(new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3,
                                new TreeNode(4), new TreeNode(4)), new TreeNode(3)),
                new TreeNode(2))));
        System.out.println(isBalanced.isBalanced(null));
    }
}
