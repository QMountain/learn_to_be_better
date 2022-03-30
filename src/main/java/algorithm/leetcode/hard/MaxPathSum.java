package algorithm.leetcode.hard;

import algorithm.TreeNode;

public class MaxPathSum {

    public int maxPathSum(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }
        int max = root.val;
        boolean leftCombined = root.left == null ||
                (root.left.left == null && root.left.right == null);
        if (!leftCombined) {
            max = combine(root.left,max);
        }
        boolean rightCombined = root.right == null ||
                (root.right.left == null && root.right.right == null);
        if (!rightCombined) {
            max = combine(root.right,max);
        }
        if (root.left == null) {
            max = Math.max(max,root.right.val);
            max = Math.max(max,root.val+root.right.val);
            return max;
        }
        if (root.right == null) {
            max = Math.max(max,root.left.val);
            max = Math.max(max,root.val+root.left.val);
            return max;
        }
        max = Math.max(max,root.left.val);
        max = Math.max(max,root.right.val);
        int bigger = Math.max(root.left.val, root.right.val);
        if (bigger > 0) {
            max = Math.max(max,root.val+bigger);
        }
        max = Math.max(max,root.val+root.left.val+root.right.val);
        return max;
    }

    public int combine(TreeNode node,int max) {
        max = Math.max(node.val,max);
        if (node.left == null && node.right == null) {
            return max;
        }
        if (node.left == null) {
            if (node.right.left != null || node.right.right != null) {
                if (node.right.left != null) {
                    max = combine(node.right,max);
                }
                if (node.right.right != null) {
                    max = combine(node.right,max);
                }
            }
            max = Math.max(max,node.right.val);
            max = Math.max(max,node.val+node.right.val);
            if (node.right.val > 0) {
                node.val += node.right.val;
            }
            node.right = null;
            return max;
        }
        if (node.right == null) {
            if (node.left.left != null || node.left.right != null) {
                max = combine(node.left,max);
            }
            max = Math.max(max,node.left.val);
            max = Math.max(max,node.val+node.left.val);
            if (node.left.val > 0) {
                node.val += node.left.val;
            }
            node.left = null;
            return max;
        }
        max = combine(node.left,max);
        max = combine(node.right,max);
        max = Math.max(max,node.left.val);
        max = Math.max(max,node.right.val);
        max = Math.max(max,node.val+node.left.val+node.right.val);
        int bigger = Math.max(node.left.val, node.right.val);
        if (bigger > 0) {
            max = Math.max(max,node.val+bigger);
            node.val += bigger;
        }
        node.left = null;
        node.right = null;
        return max;
    }

    public static void main(String[] args) {
        MaxPathSum maxPathSum = new MaxPathSum();
        System.out.println(15 == maxPathSum.maxPathSum(new TreeNode(1, null,
                new TreeNode(2, null,
                        new TreeNode(3, null,
                                new TreeNode(4, null, new TreeNode(5)))))));
        System.out.println(15 == maxPathSum.maxPathSum(new TreeNode(1,
                new TreeNode(2,new TreeNode(3,
                        new TreeNode(4,new TreeNode(5),null),null),null), null)));
        System.out.println(6 == maxPathSum.maxPathSum(new TreeNode(1, new TreeNode(2), new TreeNode(3))));
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
