package algorithm.leetcode.easy.i;

import algorithm.TreeNode;

public class IsSubtree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        // check root equal
        if (check(root,subRoot)) {
            return true;
        }
        if (isSubtree(root.left,subRoot)) {
            return true;
        }
        return isSubtree(root.right,subRoot);
    }

    public boolean check(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return node1.val == node2.val
                && check(node1.left, node2.left)
                && check(node1.right, node2.right);
    }

    public static void main(String[] args) {
        IsSubtree isSubtree = new IsSubtree();
        System.out.println(isSubtree.isSubtree(new TreeNode(3,
                        new TreeNode(4,new TreeNode(1),new TreeNode(2,null,new TreeNode(0))),
                        new TreeNode(5)),
                new TreeNode(4, new TreeNode(1), new TreeNode(2))));
    }
}
