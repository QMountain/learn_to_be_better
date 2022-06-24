package algorithm.leetcode.medium.l;

import algorithm.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LargestValues {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ansList = new ArrayList<>();
        if (root == null) {
            return ansList;
        }
        ansList.add(root.val);
        List<TreeNode> nodes = Collections.singletonList(root);
        while (nodes.size() > 0) {
            List<TreeNode> nNodes = new ArrayList<>();
            int max = Integer.MIN_VALUE;
            for (TreeNode node : nodes) {
                if (node.left != null) {
                    nNodes.add(node.left);
                    max = Math.max(max,node.left.val);
                }
                if (node.right != null) {
                    nNodes.add(node.right);
                    max = Math.max(max,node.right.val);
                }
            }
            if (nNodes.size() > 0) {
                ansList.add(max);
            }
            nodes = nNodes;
        }
        return ansList;
    }

}
