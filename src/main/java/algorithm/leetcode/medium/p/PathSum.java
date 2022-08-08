package algorithm.leetcode.medium.p;

import algorithm.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathSum {

    // 题号113 medium 路径总和II
    public List<List<Integer>> pathSum2(TreeNode root, int targetSum) {
        List<List<Integer>> ansList = new ArrayList<>();
        if (root == null) {
            return ansList;
        }
        if (root.left == null && root.right == null) {
            if (root.val == targetSum) {
                ansList.add(Collections.singletonList(root.val));
            }
            return ansList;
        }
        if (root.left != null) {
            List<List<Integer>> lists = pathSum2(root.left, targetSum - root.val);
            for (List<Integer> list : lists) {
                ArrayList<Integer> nl = new ArrayList<>(list);
                nl.add(0,root.val);
                ansList.add(nl);
            }
        }
        if (root.right != null) {
            List<List<Integer>> lists = pathSum2(root.right, targetSum - root.val);
            for (List<Integer> list : lists) {
                ArrayList<Integer> nl = new ArrayList<>(list);
                nl.add(0,root.val);
                ansList.add(nl);
            }
        }
        return ansList;
    }

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.val == targetSum) {
            res += 1;
        }
        int passRootSumLeft = find(root.left, targetSum - root.val);
        int passRootSumRight = find(root.right, targetSum - root.val);
        int sumLeft = pathSum(root.left, targetSum);
        int sumRight = pathSum(root.right, targetSum);
        return res + passRootSumLeft+passRootSumRight+sumLeft+sumRight;
    }

    public int find(TreeNode node, int targetSum) {
        if (node == null) {
            return 0;
        }
        int res = 0;
        if (node.val == targetSum) {
            res += 1;
        }
        int findFromLeft = 0;
        if (node.left != null) {
            findFromLeft = find(node.left, targetSum - node.val);
        }
        int findFromRight = 0;
        if (node.right != null) {
            findFromRight = find(node.right, targetSum - node.val);
        }
        return res + findFromLeft+findFromRight;
    }

    public static void main(String[] args) {
        PathSum pathSum = new PathSum();
        System.out.println(pathSum.pathSum(new TreeNode(1,
                new TreeNode(-2,new TreeNode(1,null,new TreeNode(-1)),new TreeNode(3)),
                new TreeNode(-3,new TreeNode(-2),null)), -2));
        System.out.println(pathSum.pathSum(new TreeNode(1,
                new TreeNode(-2,new TreeNode(1,null,new TreeNode(-1)),new TreeNode(3)),
                new TreeNode(-3,new TreeNode(-2),null)), -1));
        System.out.println(pathSum.pathSum(new TreeNode(-2, null, new TreeNode(-3)), -5));
        System.out.println(pathSum.pathSum(new TreeNode(10,
                new TreeNode(5,
                        new TreeNode(3,
                                new TreeNode(3),new TreeNode(-2)),
                        new TreeNode(2,
                                null,new TreeNode(1))),
                new TreeNode(-3,
                        null, new TreeNode(11))), 8));
    }
}
