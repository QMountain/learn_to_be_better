package algorithm.leetcode.medium.k;

import algorithm.TreeNode;

import java.util.*;

public class KthLargestLevelSum {

    public long kthLargestLevelSum(TreeNode root, int k) {
        TreeMap<Long, Integer> map = new TreeMap<>();
        List<TreeNode> nodeList = Collections.singletonList(root);
        while (!nodeList.isEmpty()) {
            List<TreeNode> children = new ArrayList<>();
            long levelSum = 0;
            for (TreeNode node : nodeList) {
                levelSum += node.val;
                if (node.left != null) {
                    children.add(node.left);
                }
                if (node.right != null) {
                    children.add(node.right);
                }
            }
            map.put(levelSum, map.getOrDefault(levelSum, 0) + 1);
            nodeList = children;
        }
        while (k > 0 && !map.isEmpty()) {
            Map.Entry<Long, Integer> lastEntry = map.pollLastEntry();
            if (lastEntry.getValue() >= k) {
                return lastEntry.getKey();
            }
            k -= lastEntry.getValue();
        }
        return -1;
    }

}
