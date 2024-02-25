package algorithm.leetcode.medium.l;

import algorithm.TreeNode;

import java.util.*;

public class LowestCommonAncestor {

    // 题号 235 二叉搜索树的最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        if (root.val > p.val && root.val < q.val) {
            return root;
        }
        if (root.val > q.val && root.val < p.val) {
            return root;
        }
        if (root.val < p.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return lowestCommonAncestor(root.left, p, q);
    }

    // 树中节点数目在范围 [2, 10^5] 内。
    // -10^9 <= Node.val <= 10^9
    // 所有 Node.val 互不相同 。
    // p != q
    // p 和 q 均存在于给定的二叉树中。
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> pList = new LinkedList<>();
        LinkedList<TreeNode> qList = new LinkedList<>();
        searchList(root, p, q, pList, qList);
        TreeNode ancestor = root;
        while (pList.peekFirst() == qList.peekFirst()) {
            ancestor = pList.pollFirst();
            qList.pollFirst();
        }
        return ancestor;
    }

    private void searchList(TreeNode root, TreeNode p, TreeNode q,
                            LinkedList<TreeNode> pList, LinkedList<TreeNode> qList) {
        if (pList.peekLast() == p && qList.peekLast() == q) {
            return;
        }
        if (pList.peekLast() != p) {
            pList.addLast(root);
        }
        if (qList.peekLast() != q) {
            qList.addLast(root);
        }
        if (root.left != null) {
            searchList(root.left, p, q, pList, qList);
        }
        if (root.right != null) {
            searchList(root.right, p, q, pList, qList);
        }
        if (pList.peekLast() != p) {
            pList.pollLast();
        }
        if (qList.peekLast() != q) {
            qList.pollLast();
        }
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
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
        TreeNode node2 = new TreeNode(2, new TreeNode(7), new TreeNode(4));
        TreeNode node6 = new TreeNode(6);
        TreeNode node0 = new TreeNode(0);
        TreeNode node3 = lowestCommonAncestor.lowestCommonAncestor(new TreeNode(3,
                        new TreeNode(5, node6, node2),
                        new TreeNode(1, node0, new TreeNode(8))),
                node6, node0);
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
