package algorithm.leetcode.medium.c;

import algorithm.TreeNode;

public class ConvertBST {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

    public static void main(String[] args) {
        ConvertBST convertBST = new ConvertBST();
        TreeNode node4 = convertBST.convertBST(new TreeNode(4,
                new TreeNode(-3,
                        null,new TreeNode(0,
                        new TreeNode(-1),new TreeNode(2))),
                null));
        TreeNode node3 = convertBST.convertBST(new TreeNode(3,
                new TreeNode(2,new TreeNode(1),null),
                new TreeNode(4)));
        TreeNode node2 = convertBST.convertBST(new TreeNode(1, new TreeNode(0), new TreeNode(2)));
        TreeNode node1 = convertBST.convertBST(new TreeNode(0, null, new TreeNode(1)));
        TreeNode node = convertBST.convertBST(new TreeNode(4,
                new TreeNode(1,
                        new TreeNode(0),
                        new TreeNode(2,null,new TreeNode(3))),
                new TreeNode(6,
                        new TreeNode(5),
                        new TreeNode(7,null,new TreeNode(8)))));
        System.out.println(node);
    }
}
