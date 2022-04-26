package algorithm.leetcode.medium.l;

import algorithm.TreeNode;

import java.util.*;

public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode,TreeNode> nodeParentMap = new HashMap<>();
        addToMap(root,p,q,nodeParentMap);
        List<TreeNode> pPath = new ArrayList<>();
        List<TreeNode> qPath = new ArrayList<>();
        TreeNode parentP = p;
        TreeNode parentQ = q;
        while (parentP != null) {
            pPath.add(0,parentP);
            parentP = nodeParentMap.get(parentP);
        }
        while (parentQ != null) {
            qPath.add(0,parentQ);
            parentQ = nodeParentMap.get(parentQ);
        }
        int sizeP = pPath.size();
        int sizeQ = qPath.size();
        for (int i = sizeP-1; i >= 0; i--) {
            for (int j = sizeQ-1; j >= 0; j--) {
                if (pPath.get(i) == qPath.get(j)) {
                    return pPath.get(i);
                }
            }
        }
        return null;
    }

    public void addToMap(TreeNode root, TreeNode p, TreeNode q, Map<TreeNode,TreeNode> nodeParentMap) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        if (nodeParentMap.containsKey(p) && nodeParentMap.containsKey(q)) {
            return;
        }
        if (root.left != null) {
            nodeParentMap.put(root.left,root);
            addToMap(root.left,p,q,nodeParentMap);
        }
        if (root.right != null) {
            nodeParentMap.put(root.right,root);
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
