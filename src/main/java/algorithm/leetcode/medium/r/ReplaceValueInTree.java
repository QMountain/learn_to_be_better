package algorithm.leetcode.medium.r;

import algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ReplaceValueInTree {

    // 树中节点数目的范围是 [1, 10^5] 。
    // 1 <= Node.val <= 10^4
    public TreeNode replaceValueInTree(TreeNode root) {
        root.val = 0;
        List<TreeNode> currLevelList = new ArrayList<>();
        currLevelList.add(root);
        while (!currLevelList.isEmpty()) {
            List<TreeNode> nextLevelList = new ArrayList<>();
            int nextLevelSum = 0;
            for (TreeNode node : currLevelList) {
                if (node.left != null) {
                    nextLevelSum += node.left.val;
                    nextLevelList.add(node.left);
                }
                if (node.right != null) {
                    nextLevelSum += node.right.val;
                    nextLevelList.add(node.right);
                }
            }
            for (TreeNode node : currLevelList) {
                if (node.left == null && node.right == null) {
                    continue;
                }
                if (node.left == null) {
                    node.right.val = nextLevelSum - node.right.val;
                    continue;
                }
                if (node.right == null) {
                    node.left.val = nextLevelSum - node.left.val;
                    continue;
                }
                int currNodeChildrenSum = node.left.val + node.right.val;
                node.left.val = nextLevelSum - currNodeChildrenSum;
                node.right.val = nextLevelSum - currNodeChildrenSum;
            }
            currLevelList = nextLevelList;
        }
        return root;
    }

    public static void main(String[] args) {
        ReplaceValueInTree replaceValueInTree = new ReplaceValueInTree();
        TreeNode treeNode = replaceValueInTree.replaceValueInTree(new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(1), new TreeNode(10)),
                new TreeNode(9,
                        null, new TreeNode(7))));
        System.out.println(treeNode);
    }
}
