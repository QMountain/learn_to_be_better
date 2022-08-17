package algorithm.leetcode.medium.r;

import algorithm.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ansList = new ArrayList<>();
        if (root == null) {
            return ansList;
        }
        List<TreeNode> nodes = Collections.singletonList(root);
        while (nodes.size() > 0) {
            ansList.add(nodes.get(nodes.size()-1).val);
            List<TreeNode> list = new ArrayList<>();
            for (TreeNode node : nodes) {
                if (node.left != null) {
                    list.add(node.left);
                }
                if (node.right != null) {
                    list.add(node.right);
                }
            }
            nodes = list;
        }
        return ansList;
    }

}
