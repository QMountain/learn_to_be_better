package algorithm.leetcode.medium.i;

import algorithm.TreeNode;

public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        if (root.left != null) {
            int[] ints = checkAndGet(root.left);
            if (ints[0] == 0) {
                return false;
            }
            if (root.val <= ints[2]) {
                return false;
            }
        }
        if (root.right != null) {
            int[] ints = checkAndGet(root.right);
            if (ints[0] == 0) {
                return false;
            }
            return root.val < ints[1];
        }
        return true;
    }

    public int[] checkAndGet(TreeNode node) {
        // is min max
        int[] arr = new int[3];
        arr[1] = node.val;
        arr[2] = node.val;
        if (node.left != null) {
            int[] ints = checkAndGet(node.left);
            if (ints[0] == 0) {
                return arr;
            }
            if (node.val <= ints[2]) {
                return arr;
            }
            arr[1] = getMin(node.left);
        }
        if (node.right != null) {
            int[] ints = checkAndGet(node.right);
            if (ints[0] == 0) {
                return arr;
            }
            if (node.val >= ints[1]) {
                return arr;
            }
            arr[2] = getMax(node.right);
        }
        arr[0] = 1;
        return arr;
    }

    public int getMax(TreeNode node) {
        if (node.right != null) {
            return getMax(node.right);
        }
        return node.val;
    }

    public int getMin(TreeNode node) {
        if (node.left != null) {
            return getMax(node.left);
        }
        return node.val;
    }

    public static void main(String[] args) {
        IsValidBST isValidBST = new IsValidBST();
        System.out.println(isValidBST.isValidBST(new TreeNode(24,
                new TreeNode(-60,new TreeNode(-60),new TreeNode(-6)), null)));
        System.out.println(isValidBST.isValidBST(new TreeNode(2, new TreeNode(1), new TreeNode(3))));
    }
}
