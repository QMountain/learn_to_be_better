package algorithm.leetcode.medium.a;

import algorithm.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddOneRow {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode treeNode = new TreeNode(val);
            treeNode.left = root;
            return treeNode;
        }
        List<TreeNode> children = Collections.singletonList(root);
        while (depth > 2) {
            List<TreeNode> list = new ArrayList<>();
            for (TreeNode child : children) {
                if (child.left != null) {
                    list.add(child.left);
                }
                if (child.right != null) {
                    list.add(child.right);
                }
            }
            children = list;
            depth--;
        }
        for (TreeNode child : children) {
            TreeNode left = child.left;
            TreeNode right = child.right;
            TreeNode node1 = new TreeNode(val);
            TreeNode node2 = new TreeNode(val);
            node1.left = left;
            node2.right = right;
            child.left = node1;
            child.right = node2;
        }
        return root;
    }

    public static void main(String[] args) {
        AddOneRow addOneRow = new AddOneRow();
        TreeNode treeNode1 = addOneRow.addOneRow(new TreeNode(4, new TreeNode(2,
                new TreeNode(3), new TreeNode(1)), null), 1, 3);
        System.out.println(treeNode1);
        TreeNode treeNode = addOneRow.addOneRow(new TreeNode(4, new TreeNode(2,
                new TreeNode(3), new TreeNode(1)),
                new TreeNode(6, new TreeNode(5), null)), 1, 2);
        System.out.println(treeNode);
    }
}
