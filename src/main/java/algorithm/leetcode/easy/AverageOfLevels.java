package algorithm.leetcode.easy;

import algorithm.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AverageOfLevels {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averages = new ArrayList<>();
        List<TreeNode> treeNodes = Collections.singletonList(root);
        while (true) {
            List<TreeNode> nodes = calAndGet(treeNodes, averages);
            if (nodes == null || nodes.size() == 0) {
                break;
            }
            treeNodes = nodes;
        }
        return averages;
    }

    public List<TreeNode> calAndGet(List<TreeNode> nodes, List<Double> averages) {
        double sum = 0;
        int count = 0;
        List<TreeNode> nextNodes = new ArrayList<>();
        for (TreeNode node : nodes) {
            sum += node.val;
            count++;
            if (node.left != null) {
                nextNodes.add(node.left);
            }
            if (node.right != null) {
                nextNodes.add(node.right);
            }
        }
        averages.add(sum/count);
        return nextNodes;
    }

    public static void main(String[] args) {
        AverageOfLevels averageOfLevels = new AverageOfLevels();
        System.out.println(averageOfLevels.averageOfLevels(
                new TreeNode(3,
                        new TreeNode(9),
                        new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
    }
}
