package algorithm.leetcode.medium.w;

import algorithm.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WidthOfBinaryTree {

    public int widthOfBinaryTree(TreeNode root) {
        List<TreeNode> nodes = Collections.singletonList(root);
        int maxWidth = 1;
        while (nodes.size() > 0) {
            List<TreeNode> list = new ArrayList<>();
            int size = nodes.size();
            int start = -1;
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.get(i);
                if (node != null && (node.left != null || node.right != null)) {
                    start = i;
                    break;
                }
            }
            if (start == -1) {
                break;
            }
            int end = -1;
            for (int i = size-1; i >= 0; i--) {
                TreeNode node = nodes.get(i);
                if (node != null && (node.left != null || node.right != null)) {
                    end = i;
                    break;
                }
            }
            if (end == -1) {
                break;
            }
            if (nodes.get(start).left == null) {
                list.add(nodes.get(start).right);
            } else {
                list.add(nodes.get(start).left);
                if (nodes.get(start).right != null || start != end) {
                    list.add(nodes.get(start).right);
                }
            }
            for (int i = start+1; i < end; i++) {
                TreeNode node = nodes.get(i);
                if (node != null) {
                    list.add(node.left);
                    list.add(node.right);
                } else {
                    list.add(null);
                    list.add(null);
                }
            }
            if (start != end) {
                if (nodes.get(end).right == null) {
                    list.add(nodes.get(end).left);
                } else {
                    list.add(nodes.get(end).left);
                    list.add(nodes.get(end).right);
                }
            }
            maxWidth = Math.max(maxWidth,list.size());
            nodes = list;
        }
        return maxWidth;
    }

    public static void main(String[] args) {
        WidthOfBinaryTree widthOfBinaryTree = new WidthOfBinaryTree();
        System.out.println(widthOfBinaryTree.widthOfBinaryTree(new TreeNode(1,
                new TreeNode(3, new TreeNode(5),new TreeNode(3)),
                new TreeNode(2,null,new TreeNode(9)))));
        System.out.println(widthOfBinaryTree.widthOfBinaryTree(new TreeNode(1,
                new TreeNode(3,
                        new TreeNode(5,
                                new TreeNode(6), null),null),
                new TreeNode(2,
                        null, new TreeNode(9,new TreeNode(7),null)))));
        System.out.println(widthOfBinaryTree.widthOfBinaryTree(new TreeNode(1,
                new TreeNode(3,new TreeNode(5),null),
                new TreeNode(2))));
    }
}
