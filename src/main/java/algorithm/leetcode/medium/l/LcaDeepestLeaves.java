package algorithm.leetcode.medium.l;

import algorithm.TreeNode;
import javafx.util.Pair;

import java.util.*;

public class LcaDeepestLeaves {

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root;
        }
        if (root.left == null) {
            return lcaDeepestLeaves(root.right);
        }
        if (root.right == null) {
            return lcaDeepestLeaves(root.left);
        }
        HashMap<TreeNode, Integer> depthMap = new HashMap<>();
        dfs(root, depthMap);
        return compare(root, depthMap);
    }

    public TreeNode compare(TreeNode root, HashMap<TreeNode, Integer> depthMap) {
        if (root.left == null && root.right == null) {
            return root;
        }
        if (root.left == null) {
            return compare(root.right, depthMap);
        }
        if (root.right == null) {
            return compare(root.left, depthMap);
        }
        Integer leftDepth = depthMap.get(root.left);
        Integer rightDepth = depthMap.get(root.right);
        if (Objects.equals(leftDepth, rightDepth)) {
            return root;
        }
        if (leftDepth > rightDepth) {
            return compare(root.left, depthMap);
        }
        return compare(root.right, depthMap);
    }

    public void dfs(TreeNode node, HashMap<TreeNode, Integer> depthMap) {
        if (node.left == null && node.right == null) {
            depthMap.put(node, 0);
            return;
        }
        int max = 0;
        if (node.left != null) {
            dfs(node.left, depthMap);
            max = Math.max(max, depthMap.get(node.left));
        }
        if (node.right != null) {
            dfs(node.right, depthMap);
            max = Math.max(max, depthMap.get(node.right));
        }
        depthMap.put(node, max + 1);
    }

    // 树中的节点数将在 [1, 1000] 的范围内。
    // 0 <= Node.val <= 1000
    // 每个节点的值都是 独一无二 的
    public TreeNode lcaDeepestLeaves2(TreeNode root) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        while (true) {
            List<TreeNode> newList = new ArrayList<>();
            for (TreeNode node : list) {
                if (node.left != null) {
                    newList.add(node.left);
                    parentMap.put(node.left, node);
                }
                if (node.right != null) {
                    newList.add(node.right);
                    parentMap.put(node.right, node);
                }
            }
            if (newList.isEmpty()) {
                break;
            }
            list = newList;
        }
        Set<TreeNode> set = new HashSet<>(list);
        while (set.size() > 1) {
            Set<TreeNode> next = new HashSet<>();
            for (TreeNode node : set) {
                next.add(parentMap.get(node));
            }
            set = next;
        }
        return set.iterator().next();
    }

    public TreeNode lcaDeepestLeaves3(TreeNode root) {
        return f(root).getKey();
    }

    private Pair<TreeNode, Integer> f(TreeNode root) {
        if (root == null) {
            return new Pair<>(null, 0);
        }

        Pair<TreeNode, Integer> left = f(root.left);
        Pair<TreeNode, Integer> right = f(root.right);

        if (left.getValue() > right.getValue()) {
            return new Pair<>(left.getKey(), left.getValue() + 1);
        }
        if (left.getValue() < right.getValue()) {
            return new Pair<>(right.getKey(), right.getValue() + 1);
        }
        return new Pair<>(root, left.getValue() + 1);
    }


    public static void main(String[] args) {
        LcaDeepestLeaves lcaDeepestLeaves = new LcaDeepestLeaves();
        TreeNode treeNode5 = lcaDeepestLeaves.lcaDeepestLeaves(new TreeNode(0,
                new TreeNode(1,
                        null,
                        new TreeNode(2)),
                new TreeNode(3)));
        TreeNode treeNode4 = lcaDeepestLeaves.lcaDeepestLeaves(new TreeNode(3,
                new TreeNode(5,
                        new TreeNode(6),
                        new TreeNode(2,
                                new TreeNode(7),
                                new TreeNode(4))),
                new TreeNode(1,
                        new TreeNode(0),
                        new TreeNode(8))));
        TreeNode treeNode3 = lcaDeepestLeaves.lcaDeepestLeaves(new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3,
                                null,
                                new TreeNode(6)),
                        new TreeNode(4,
                                null,
                                new TreeNode(5))), null));
        TreeNode treeNode2 = lcaDeepestLeaves.lcaDeepestLeaves(new TreeNode(0,
                new TreeNode(1, null, new TreeNode(2)),
                new TreeNode(3)));
        System.out.println(treeNode2);
        TreeNode treeNode1 = lcaDeepestLeaves.lcaDeepestLeaves(new TreeNode(1));
        System.out.println(treeNode1);
        TreeNode treeNode = lcaDeepestLeaves.lcaDeepestLeaves(new TreeNode(3,
                new TreeNode(5,
                        new TreeNode(6), new TreeNode(2,
                        new TreeNode(7), new TreeNode(4))),
                new TreeNode(1,
                        new TreeNode(0), new TreeNode(8))));
        System.out.println(treeNode);
    }
}
