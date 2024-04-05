package algorithm.leetcode.medium.m;

import algorithm.TreeNode;

public class MaxAncestorDiff {

    // 树中的节点数在 2 到 5000 之间。
    // 0 <= Node.val <= 10^5
    public int maxAncestorDiff(TreeNode root) {
        return search(root)[2];
    }

    // 0 min 1 max 2 maxDiff
    public int[] search(TreeNode root) {
        int min = root.val;
        int max = root.val;
        int maxDiff = 0;
        if (root.left != null) {
            int[] search = search(root.left);
            min = Math.min(min, search[0]);
            max = Math.max(max, search[1]);
            int m1 = Math.abs(root.val - search[0]);
            int m2 = Math.abs(root.val - search[1]);
            int m = Math.max(m1, m2);
            m = Math.max(m, search[2]);
            maxDiff = Math.max(m, maxDiff);
        }
        if (root.right != null) {
            int[] search = search(root.right);
            min = Math.min(min, search[0]);
            max = Math.max(max, search[1]);
            int m1 = Math.abs(root.val - search[0]);
            int m2 = Math.abs(root.val - search[1]);
            int m = Math.max(m1, m2);
            m = Math.max(m, search[2]);
            maxDiff = Math.max(m, maxDiff);
        }
        return new int[]{min, max, maxDiff};
    }

    public static void main(String[] args) {
        MaxAncestorDiff maxAncestorDiff = new MaxAncestorDiff();
        System.out.println(7 == maxAncestorDiff.maxAncestorDiff(new TreeNode(8,
                new TreeNode(3,
                        new TreeNode(1),
                        new TreeNode(6,
                                new TreeNode(4),
                                new TreeNode(7))),
                new TreeNode(10, null,
                        new TreeNode(14, new TreeNode(13), null)))));
    }
}
