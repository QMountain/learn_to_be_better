package algorithm.leetcode.medium.d;

import algorithm.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeepestLeavesSum {

    public int deepestLeavesSum(TreeNode root) {
        List<TreeNode> nodes = Collections.singletonList(root);
        while (true) {
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
                break;
            }
            nodes = list;
        }
        int ans = 0;
        for (TreeNode node : nodes) {
            ans += node.val;
        }
        return ans;
    }

}
