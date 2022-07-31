package algorithm.leetcode.medium.m;

import algorithm.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxLevelSum {

    public int maxLevelSum(TreeNode root) {
        int maxSum = root.val;
        int maxSumLevel = 1;
        int level = 1;
        List<TreeNode> nodes = Collections.singletonList(root);
        while (nodes.size() > 0) {
            level++;
            List<TreeNode> list = new ArrayList<>();
            int sum = 0;
            for (TreeNode node : nodes) {
                if (node.left != null) {
                    list.add(node.left);
                    sum += node.left.val;
                }
                if (node.right != null) {
                    list.add(node.right);
                    sum += node.right.val;
                }
            }
            if (list.size() > 0) {
                if (sum > maxSum) {
                    maxSum = sum;
                    maxSumLevel = level;
                }
            }
            nodes = list;
        }
        return maxSumLevel;
    }

    public static void main(String[] args) {
        MaxLevelSum maxLevelSum = new MaxLevelSum();
        System.out.println(maxLevelSum.maxLevelSum(new TreeNode(-100,
                new TreeNode(-200,
                new TreeNode(-20),new TreeNode(-5)),
                new TreeNode(-300,new TreeNode(-10),null))));
        System.out.println(maxLevelSum.maxLevelSum(new TreeNode(1, new TreeNode(7,
                new TreeNode(7),new TreeNode(-8)), new TreeNode(0))));
    }
}
