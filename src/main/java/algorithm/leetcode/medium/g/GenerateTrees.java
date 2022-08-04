package algorithm.leetcode.medium.g;

import algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class GenerateTrees {

    public List<TreeNode> generateTrees(int n) {
        return generate(1,n);
    }

    public List<TreeNode> generate(int min, int max) {
        List<TreeNode> ansList = new ArrayList<>();
        if (min == max) {
            ansList.add(new TreeNode(min));
            return ansList;
        }
        for (int i = min; i <= max; i++) {
            if (min <= i-1 && i+1 <= max) {
                List<TreeNode> leftNodes = generate(min, i - 1);
                List<TreeNode> rightNodes = generate(i + 1, max);
                for (TreeNode leftNode : leftNodes) {
                    for (TreeNode rightNode : rightNodes) {
                        TreeNode root = new TreeNode(i);
                        root.left = leftNode;
                        root.right = rightNode;
                        ansList.add(root);
                    }
                }
            } else if (min <= i-1) {
                List<TreeNode> leftNodes = generate(min, i - 1);
                for (TreeNode leftNode : leftNodes) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = null;
                    ansList.add(root);
                }
            } else if (i+1 <= max) {
                List<TreeNode> rightNodes = generate(i + 1, max);
                for (TreeNode rightNode : rightNodes) {
                    TreeNode root = new TreeNode(i);
                    root.left = null;
                    root.right = rightNode;
                    ansList.add(root);
                }
            }
        }
        return ansList;
    }

    public static void main(String[] args) {
        GenerateTrees generateTrees = new GenerateTrees();
        List<TreeNode> treeNodes = generateTrees.generateTrees(3);
        System.out.println(treeNodes);
    }
}
