package algorithm.leetcode.easy.t;

import algorithm.TreeNode;

public class Tree2str {

    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }
        String str = ""+root.val;
        if (root.left != null || root.right != null) {
            str += "(";
            str += tree2str(root.left);
            str += ")";
            if (root.right != null) {
                str += "(";
                str += tree2str(root.right);
                str += ")";
            }

        }
        return str;
    }

    public static void main(String[] args) {
        Tree2str tree2str = new Tree2str();
        System.out.println(tree2str.tree2str(new TreeNode(1,
                new TreeNode(2, new TreeNode(4), null),
                new TreeNode(3))));
        System.out.println(tree2str.tree2str(new TreeNode(1,
                new TreeNode(2, null, new TreeNode(4)),
                new TreeNode(3))));
    }
}
