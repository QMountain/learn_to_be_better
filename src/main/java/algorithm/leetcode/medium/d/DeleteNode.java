package algorithm.leetcode.medium.d;

import algorithm.TreeNode;

public class DeleteNode {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.right == null) {
                return root.left;
            }
            if (root.right.left == null && root.right.right == null) {
                root.val = root.right.val;
                root.right = null;
            } else {
                root.val = getValue(root.right);
                root.right = deleteNode(root.right,root.val);
            }
            return root;
        }
        if (root.val > key) {
            if (root.left == null) {
                return root;
            }
            root.left = deleteNode(root.left,key);
            return root;
        }
        if (root.right == null) {
            return root;
        }
        root.right = deleteNode(root.right,key);
        return root;
    }

    public int getValue(TreeNode node) {
        if (node.left == null) {
            return node.val;
        }
        return getValue(node.left);
    }

    public static void main(String[] args) {
        DeleteNode deleteNode = new DeleteNode();
        TreeNode node4 = deleteNode.deleteNode(new TreeNode(50,
                new TreeNode(30,null,new TreeNode(40)),
                new TreeNode(70,new TreeNode(60),new TreeNode(80))), 50);
        TreeNode node3 = deleteNode.deleteNode(new TreeNode(5,
                new TreeNode(3,new TreeNode(2),new TreeNode(4)),
                new TreeNode(6,null,new TreeNode(7))), 7);
        TreeNode node2 = deleteNode.deleteNode(new TreeNode(5,
                new TreeNode(3,new TreeNode(2),new TreeNode(4)),
                new TreeNode(6,null,new TreeNode(7))), 5);
        TreeNode node1 = deleteNode.deleteNode(new TreeNode(5,
                new TreeNode(2,null,new TreeNode(4)),
                new TreeNode(6,null,new TreeNode(7))), 0);
        TreeNode node = deleteNode.deleteNode(new TreeNode(5,
                new TreeNode(3, new TreeNode(2),new TreeNode(4)),
                new TreeNode(6,null,new TreeNode(7))), 3);
        System.out.println(node);
    }
}
