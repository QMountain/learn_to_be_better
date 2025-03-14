package algorithm.leetcode.easy.i;

import algorithm.TreeNode;

public class IsBalanced {

    /**
     * 给你一个仅由数字 0 - 9 组成的字符串 num。
     * 如果偶数下标处的数字之和等于奇数下标处的数字之和，则认为该数字字符串是一个 平衡字符串。
     * 如果 num 是一个 平衡字符串，则返回 true；否则，返回 false。
     */
    public boolean isBalanced(String num) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < num.length(); i++) {
            if (i % 2 == 0) {
                a += num.charAt(i) - '0';
            } else {
                b += num.charAt(i) - '0';
            }
        }
        return a == b;
    }

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
        System.out.println(isBalanced.isBalanced((TreeNode) null));
    }
}
