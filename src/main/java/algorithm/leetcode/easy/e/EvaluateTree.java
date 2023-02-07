package algorithm.leetcode.easy.e;

import algorithm.TreeNode;

public class EvaluateTree {

    public boolean evaluateTree(TreeNode root) {
        if (root.val == 0) {
            return false;
        }
        if (root.val == 1) {
            return true;
        }
        boolean leftVal;
        if (root.left.val != 0 && root.left.val != 1) {
            leftVal = evaluateTree(root.left);
        } else {
            leftVal = root.left.val == 1;
        }
        boolean rightVal;
        if (root.right.val != 0 && root.right.val != 1) {
            rightVal = evaluateTree(root.right);
        } else {
            rightVal = root.right.val == 1;
        }
        if (root.val == 2) {
            return leftVal || rightVal;
        }
        return leftVal && rightVal;
    }

    public static void main(String[] args) {
        EvaluateTree evaluateTree = new EvaluateTree();
        System.out.println(evaluateTree.evaluateTree(new TreeNode(0)));
        System.out.println(evaluateTree.evaluateTree(new TreeNode(2,
                new TreeNode(1),
                new TreeNode(3,
                        new TreeNode(0), new TreeNode(1)))));
    }
}
