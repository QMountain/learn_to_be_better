package algorithm.leetcode.medium.z;

import algorithm.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ansList = new ArrayList<>();
        if (root == null) {
            return ansList;
        }
        List<TreeNode> nodes = Collections.singletonList(root);
        boolean toward = true;
        while (!nodes.isEmpty()) {
            List<TreeNode> list = new ArrayList<>();
            List<Integer> values = new ArrayList<>();
            if (toward) {
                for (TreeNode node : nodes) {
                    values.add(node.val);
                    if (node.left != null) {
                        list.add(node.left);
                    }
                    if (node.right != null) {
                        list.add(node.right);
                    }
                }
            } else {
                int size = nodes.size();
                for (int i = size-1; i >= 0; i--) {
                    TreeNode node = nodes.get(i);
                    values.add(node.val);
                }
                for (TreeNode node : nodes) {
                    if (node.left != null) {
                        list.add(node.left);
                    }
                    if (node.right != null) {
                        list.add(node.right);
                    }
                }
            }
            ansList.add(values);
            toward = !toward;
            nodes = list;
        }
        return ansList;
    }

    public static void main(String[] args) {
        ZigzagLevelOrder zigzagLevelOrder = new ZigzagLevelOrder();
        System.out.println(zigzagLevelOrder.zigzagLevelOrder(new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
    }

}
