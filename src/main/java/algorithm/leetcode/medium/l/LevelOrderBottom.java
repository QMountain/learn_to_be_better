package algorithm.leetcode.medium.l;

import algorithm.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderBottom {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ansList = new LinkedList<>();
        if (root == null) {
            return ansList;
        }
        List<TreeNode> nodes = Collections.singletonList(root);
        while (!nodes.isEmpty()) {
            List<TreeNode> list = new ArrayList<>();
            List<Integer> values = new ArrayList<>();
            for (TreeNode node : nodes) {
                values.add(node.val);
                if (node.left != null) {
                    list.add(node.left);
                }
                if (node.right != null) {
                    list.add(node.right);
                }
            }
            nodes = list;
            ansList.add(0, values);
        }
        return ansList;
    }

}
