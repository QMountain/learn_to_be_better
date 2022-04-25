package algorithm.leetcode.easy.l;

import algorithm.TreeNode;

public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int rv = root.val;
        int pv = p.val;
        int qv = q.val;
        if (pv < rv && qv < rv) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (pv > rv && qv > rv) {
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }

}
