package algorithm.leetcode.medium.l;

import algorithm.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LevelOrderBottom {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ansList = new ArrayList<>();
        if (root == null) {
            return ansList;
        }
        List<TreeNode> nodes = Collections.singletonList(root);
        while (nodes.size() > 0) {
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
            ansList.add(values);
        }
        int size = ansList.size();
        List<List<Integer>> resList = new ArrayList<>();
        for (int i = size-1; i >= 0; i--) {
            resList.add(ansList.get(i));
        }
        return resList;
    }

}
