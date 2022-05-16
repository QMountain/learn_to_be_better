package algorithm.leetcode.medium.f;

import algorithm.TreeNode;

public class Flatten {

    public void flatten(TreeNode root) {
        if (root != null) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            if (left != null && (left.left != null || left.right != null)) {
                flatten(left);
            }

            if (right != null && (right.left != null || right.right != null)) {
                flatten(right);
            }
            root.left = null;
            root.right = left;
            TreeNode curNode = left;
            if (curNode != null) {
                while (curNode.right != null) {
                    curNode = curNode.right;
                }
                curNode.right = right;
            } else {
                root.right = right;
            }
        }
        System.out.println(root);
    }

    public static void main(String[] args) {
        Flatten flatten = new Flatten();
        flatten.flatten(new TreeNode(1,
                new TreeNode(2,new TreeNode(3),new TreeNode(4)),
                new TreeNode(5,null,new TreeNode(6))));
    }
}
