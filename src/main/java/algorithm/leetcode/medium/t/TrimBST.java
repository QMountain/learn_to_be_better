package algorithm.leetcode.medium.t;

import algorithm.TreeNode;

public class TrimBST {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root.val < low) {
            if (root.right != null) {
                return trimBST(root.right,low,high);
            }
            return null;
        }
        if (root.val > high) {
            if (root.left != null) {
                return trimBST(root.left,low,high);
            }
            return null;
        }
        if (root.left != null) {
            root.left = trimBST(root.left,low,high);
        }
        if (root.right != null) {
            root.right = trimBST(root.right,low,high);
        }
        return root;
    }

    public static void main(String[] args) {
        TrimBST trimBST = new TrimBST();
        TreeNode treeNode1 = trimBST.trimBST(new TreeNode(3,
                new TreeNode(0,null,new TreeNode(2,new TreeNode(1),null)),
                new TreeNode(4)), 1, 3);
        System.out.println(treeNode1);
        TreeNode treeNode = trimBST.trimBST(new TreeNode(1, new TreeNode(0), new TreeNode(2)), 1, 2);
        System.out.println(treeNode);
    }
}
