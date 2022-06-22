package algorithm.leetcode.medium.f;

import algorithm.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindBottomLeftValue {

    public int findBottomLeftValue(TreeNode root) {
        return find(Collections.singletonList(root));
    }

    public int find(List<TreeNode> nodes) {
        List<TreeNode> list = new ArrayList<>();
        for (TreeNode node : nodes) {
            if (node.left != null) {
                list.add(node.left);
            }
            if (node.right != null) {
                list.add(node.right);
            }
        }
        if (list.size() == 0) {
            return nodes.get(0).val;
        }
        return find(list);
    }

}
