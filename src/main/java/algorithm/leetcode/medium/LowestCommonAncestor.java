package algorithm.leetcode.medium;

import algorithm.TreeNode;

import java.util.*;

public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode,TreeNode> nodeParentMap = new HashMap<>();
        addToMap(root,p,q,nodeParentMap);
        List<TreeNode> pPath = new ArrayList<>();
        List<TreeNode> qPath = new ArrayList<>();
        pPath.add(p);
        qPath.add(q);
        TreeNode parentP = p;
        TreeNode parentQ = q;
        while (parentP != parentQ && p != parentQ && q != parentP) {
            parentP = nodeParentMap.get(parentP);
            parentQ = nodeParentMap.get(parentQ);
        }
        if (p == parentQ) {
            return parentQ;
        }
        return parentP;
    }

    public void addToMap(TreeNode root, TreeNode p, TreeNode q, Map<TreeNode,TreeNode> nodeParentMap) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        boolean findP = false;
        boolean findQ = false;
        while (true) {
            nodeParentMap.put(root.left,root);
            nodeParentMap.put(root.right,root);
            if (nodeParentMap.containsKey(p)) {
                findP = true;
            }
            if (nodeParentMap.containsKey(q)) {
                findQ = true;
            }
            if (findP && findQ) {
                break;
            }
            addToMap(root.left,p,q,nodeParentMap);
            addToMap(root.right,p,q,nodeParentMap);
        }
    }

    public static void main(String[] args) {
        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        /*TreeNode node5 = new TreeNode(5, new TreeNode(6),
                new TreeNode(2,new TreeNode(7),new TreeNode(4)));
        TreeNode node1 = new TreeNode(1, new TreeNode(0), new TreeNode(8));
        TreeNode node = lowestCommonAncestor.lowestCommonAncestor(new TreeNode(3, node5, node1),
                node5, node1);
        System.out.println(node);*/

        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5, new TreeNode(6),
                new TreeNode(2,new TreeNode(7), node4));
        TreeNode node1 = new TreeNode(1, new TreeNode(0), new TreeNode(8));
        TreeNode node = lowestCommonAncestor.lowestCommonAncestor(new TreeNode(3, node5, node1),
                node5, node4);
        System.out.println(node);
    }
}
