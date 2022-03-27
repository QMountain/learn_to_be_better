package algorithm.leetcode.hard;

import algorithm.TreeNode;

public class MaxPathSum {

    public int maxPathSum(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }
        if (root.left == null) {
            int passRight = maxPathSum(root.right);
            int passRoot = passRight + root.val;
            return Math.max(root.val,Math.max(passRight,passRoot));
        }
        if (root.right == null) {
            int passLeft = maxPathSum(root.left);
            int passRoot = passLeft + root.val;
            return Math.max(root.val,Math.max(passLeft,passRoot));
        }
        int leftToRoot = getMaxSumToNode(root.left);
        int rightToRoot = getMaxSumToNode(root.right);
        leftToRoot = Math.max(leftToRoot,0);
        rightToRoot = Math.max(rightToRoot,0);
        int passRoot = leftToRoot + rightToRoot + root.val;
        int passLeft = maxPathSum(root.left);
        int passRight = maxPathSum(root.right);
        int max = Math.max(passLeft,passRight);
        return Math.max(max,passRoot);
    }

    public int getMaxSumToNode(TreeNode node) {
        if (node.left == null && node.right == null) {
            return Math.max(node.val,0);
        }
        if (node.left == null) {
            int passRight = getMaxSumToNode(node.right);
            if (passRight > 0) {
                return passRight +node.val;
            }
            return Math.max(node.val,0);
        }
        if (node.right == null) {
            int passLeft = getMaxSumToNode(node.left);
            if (passLeft > 0) {
                return passLeft +node.val;
            }
            return Math.max(node.val,0);
        }
        int passLeft = getMaxSumToNode(node.left);
        int passRight = getMaxSumToNode(node.right);
        int max = Math.max(passLeft,passRight);
        if (max > 0) {
            max += node.val;
        }
        return Math.max(max, 0);
    }

    public static void main(String[] args) {
        MaxPathSum maxPathSum = new MaxPathSum();
        System.out.println(4 == maxPathSum.maxPathSum(new TreeNode(1,
                new TreeNode(0,
                        new TreeNode(1, new TreeNode(0), new TreeNode(1)),
                        new TreeNode(2, new TreeNode(-1), new TreeNode(0))),
                new TreeNode(1,
                        new TreeNode(0, new TreeNode(-1), new TreeNode(0)),
                        new TreeNode(-1, new TreeNode(1), new TreeNode(0))))));
        System.out.println(3 == maxPathSum.maxPathSum(new TreeNode(1,
                new TreeNode(-2,new TreeNode(1,new TreeNode(-1),null),new TreeNode(3)),
                new TreeNode(-3,new TreeNode(-2),null))));
        System.out.println(maxPathSum.maxPathSum(new TreeNode(2, new TreeNode(-2), new TreeNode(-2))));
        System.out.println(maxPathSum.maxPathSum(new TreeNode(1, new TreeNode(-2), new TreeNode(3))));
        System.out.println(maxPathSum.maxPathSum(new TreeNode(-2, new TreeNode(1), null)));
        System.out.println(maxPathSum.maxPathSum(new TreeNode(2, new TreeNode(-1), null)));
        System.out.println(maxPathSum.maxPathSum(new TreeNode(1, new TreeNode(2), null)));
        System.out.println(maxPathSum.maxPathSum(new TreeNode(1,
                new TreeNode(2), new TreeNode(3))));
        System.out.println(maxPathSum.maxPathSum(new TreeNode(-10,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15), new TreeNode(7)))));
    }
}
