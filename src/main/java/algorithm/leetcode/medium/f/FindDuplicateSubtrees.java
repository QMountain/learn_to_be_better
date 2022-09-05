package algorithm.leetcode.medium.f;

import algorithm.TreeNode;

import java.util.*;

public class FindDuplicateSubtrees {

    Map<TreeNode,String> preOrderMap;
    Map<TreeNode,String> inOrderMap;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root.left == null && root.right != null) {
            return findDuplicateSubtrees(root.right);
        }
        if (root.left != null && root.right == null) {
            return findDuplicateSubtrees(root.left);
        }
        List<TreeNode> ansList = new ArrayList<>();
        if (root.left == null) {
            return ansList;
        }
        this.preOrderMap = new HashMap<>();
        this.inOrderMap = new HashMap<>();
        preOrder(root);
        inOrder(root);

        List<TreeNode> allNodes = getAllNodes(root);
        while (allNodes.size() > 0) {
            TreeNode node1 = allNodes.get(0);
            List<Integer> removeIndexes = new ArrayList<>();
            removeIndexes.add(0);
            for (int i = 1; i < allNodes.size(); i++) {
                if (eq(node1,allNodes.get(i))) {
                    removeIndexes.add(i);
                }
            }
            if (removeIndexes.size() > 1) {
                ansList.add(node1);
            }
            for (int i = removeIndexes.size()-1; i >= 0; i--) {
                allNodes.remove((int)(removeIndexes.get(i)));
            }
        }
        return ansList;
    }

    public List<TreeNode> getAllNodes(TreeNode root) {
        List<TreeNode> allNodes = new ArrayList<>();
        allNodes.add(root);
        if (root.left != null) {
            allNodes.addAll(getAllNodes(root.left));
        }
        if (root.right != null) {
            allNodes.addAll(getAllNodes(root.right));
        }
        return allNodes;
    }

    public boolean eq(TreeNode node1, TreeNode node2) {
        return Objects.equals(preOrderMap.get(node1), preOrderMap.get(node2)) && Objects.equals(inOrderMap.get(node1), inOrderMap.get(node2));
    }

    public void preOrder(TreeNode root) {
        if (root.left == null && root.right == null) {
            preOrderMap.put(root,"("+root.val+")");
            return;
        }
        String preLeft = "()";
        if (root.left != null) {
            if (!preOrderMap.containsKey(root.left)) {
                preOrder(root.left);
            }
            preLeft = preOrderMap.get(root.left);
        }
        String preRight = "()";
        if (root.right != null) {
            if (!preOrderMap.containsKey(root.right)) {
                preOrder(root.right);
            }
            preRight = preOrderMap.get(root.right);
        }
        preOrderMap.put(root,"("+root.val+")"+preLeft+preRight);
    }

    public void inOrder(TreeNode root) {
        if (root.left == null && root.right == null) {
            inOrderMap.put(root,"("+root.val+")");
            return;
        }
        String inLeft = "()";
        if (root.left != null) {
            if (!inOrderMap.containsKey(root.left)) {
                inOrder(root.left);
            }
            inLeft = inOrderMap.get(root.left);
        }
        String inRight = "()";
        if (root.right != null) {
            if (!inOrderMap.containsKey(root.right)) {
                inOrder(root.right);
            }
            inRight = inOrderMap.get(root.right);
        }
        inOrderMap.put(root,inLeft+"("+root.val+")"+inRight);
    }

    public static void main(String[] args) {
        FindDuplicateSubtrees findDuplicateSubtrees = new FindDuplicateSubtrees();
        List<TreeNode> duplicateSubtrees1 = findDuplicateSubtrees.findDuplicateSubtrees(new TreeNode(0,
                new TreeNode(0,new TreeNode(0,null,null),null),
                new TreeNode(0,null,new TreeNode(0,null,new TreeNode(0)))));
        System.out.println(duplicateSubtrees1);
        List<TreeNode> duplicateSubtrees = findDuplicateSubtrees.findDuplicateSubtrees(new TreeNode(1,
                new TreeNode(2, new TreeNode(4), null),
                new TreeNode(3,
                        new TreeNode(2, new TreeNode(4), null),
                        new TreeNode(4))));
        System.out.println(duplicateSubtrees);
    }
}
