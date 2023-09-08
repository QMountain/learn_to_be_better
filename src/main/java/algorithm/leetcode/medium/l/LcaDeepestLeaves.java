package algorithm.leetcode.medium.l;

import algorithm.TreeNode;
import javafx.util.Pair;

import java.util.*;

public class LcaDeepestLeaves {

    public TreeNode lcaDeepestLeaves(TreeNode root) {
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

    // 树中的节点数将在 [1, 1000] 的范围内。
    // 0 <= Node.val <= 1000
    // 每个节点的值都是 独一无二 的
    public TreeNode lcaDeepestLeaves2(TreeNode root) {
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        parentMap.put(root, root);
        HashMap<TreeNode, Integer> depthMap = new HashMap<>();
        depthMap.put(root, 0);
        addToMap(root, 0, parentMap, depthMap);
        int maxDepth = 0;
        List<TreeNode> list = new ArrayList<>();
        for (Map.Entry<TreeNode, Integer> entry : depthMap.entrySet()) {
            if (entry.getValue() > maxDepth) {
                maxDepth = entry.getValue();
                list.clear();
                list.add(entry.getKey());
            } else if (entry.getValue() == maxDepth) {
                list.add(entry.getKey());
            }
        }
        if (list.size() == 1) {
            return list.get(0);
        }
        Set<TreeNode> set = new HashSet<>();
        for (TreeNode node : list) {
            set.add(parentMap.get(node));
        }
        while (set.size() > 1) {
            Set<TreeNode> ns = new HashSet<>();
            for (TreeNode node : set) {
                ns.add(parentMap.get(node));
            }
            set = ns;
        }
        return new ArrayList<>(set).get(0);
    }

    public void addToMap(TreeNode root, int currDepth,
                         HashMap<TreeNode, TreeNode> parentMap,
                         HashMap<TreeNode, Integer> depthMap) {
        if (root.left != null) {
            parentMap.put(root.left, root);
            depthMap.put(root.left, currDepth + 1);
            addToMap(root.left, currDepth + 1, parentMap, depthMap);
        }
        if (root.right != null) {
            parentMap.put(root.right, root);
            depthMap.put(root.right, currDepth + 1);
            addToMap(root.right, currDepth + 1, parentMap, depthMap);
        }
    }

    public static void main(String[] args) {
        LcaDeepestLeaves lcaDeepestLeaves = new LcaDeepestLeaves();
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
