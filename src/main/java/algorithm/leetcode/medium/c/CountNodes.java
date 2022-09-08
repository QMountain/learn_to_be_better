package algorithm.leetcode.medium.c;

import algorithm.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountNodes {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxDepth = 0;
        TreeNode node = root;
        while (node != null) {
            maxDepth++;
            node = node.left;
        }
        if (checkFull(root,maxDepth)) {
            return (1<<maxDepth)-1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public boolean checkFull(TreeNode node, int depth) {
        int curDepth = 0;
        while (node != null) {
            curDepth++;
            node = node.right;
        }
        return curDepth == depth;
    }

    // O(n) 不满足进阶要求
    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        List<TreeNode> nodes = Collections.singletonList(root);
        while (nodes.size() > 0) {
            count += nodes.size();
            List<TreeNode> list = new ArrayList<>();
            for (TreeNode node : nodes) {
                if (node.left != null && node.right != null) {
                    list.add(node.left);
                    list.add(node.right);
                } else if (node.left != null) {
                    list.add(node.left);
                    break;
                } else {
                    break;
                }
            }
            nodes = list;
        }
        return count;
    }

    public static void main(String[] args) {
        CountNodes countNodes = new CountNodes();
        System.out.println(countNodes.countNodes(new TreeNode(1,
                new TreeNode(2,new TreeNode(4),null),
                new TreeNode(3))));
        System.out.println(countNodes.countNodes(new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3,
                        new TreeNode(6),
                        null))));
    }
}
