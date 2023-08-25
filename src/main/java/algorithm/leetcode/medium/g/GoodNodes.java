package algorithm.leetcode.medium.g;

import algorithm.TreeNode;

import java.util.HashSet;

public class GoodNodes {

    public int goodNodes(TreeNode root) {
        HashSet<TreeNode> set = new HashSet<>();
        set.add(root);
        if (root.left != null) {
            if (root.left.val >= root.val) {
                set.add(root.left);
            } else {
                root.left.val = root.val;
            }
            add(root.left, set);
        }
        if (root.right != null) {
            if (root.right.val >= root.val) {
                set.add(root.right);
            } else {
                root.right.val= root.val;
            }
            add(root.right, set);
        }
        return set.size();
    }

    public void add(TreeNode root, HashSet<TreeNode> set) {
        if (root.left != null) {
            if (root.left.val >= root.val) {
                set.add(root.left);
            } else {
                root.left.val = root.val;
            }
            add(root.left, set);
        }
        if (root.right != null) {
            if (root.right.val >= root.val) {
                set.add(root.right);
            } else {
                root.right.val= root.val;
            }
            add(root.right, set);
        }
    }

    public static void main(String[] args) {
        GoodNodes goodNodes = new GoodNodes();
        System.out.println(goodNodes.goodNodes(new TreeNode(2,
                null,
                new TreeNode(4,
                        new TreeNode(10), new TreeNode(8,
                        new TreeNode(4),null)))));
        System.out.println(3 == goodNodes.goodNodes(new TreeNode(3,
                new TreeNode(3,
                        new TreeNode(4), new TreeNode(2)), null)));
        System.out.println(4 == goodNodes.goodNodes(new TreeNode(3,
                new TreeNode(1, new TreeNode(3), null),
                new TreeNode(4, new TreeNode(1), new TreeNode(5)))));
    }
}
