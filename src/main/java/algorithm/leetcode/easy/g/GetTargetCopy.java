package algorithm.leetcode.easy.g;

import algorithm.TreeNode;

public class GetTargetCopy {

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) {
            return null;
        }
        if (original.val == target.val) {
            return cloned;
        }
        if (original.left == null) {
            return getTargetCopy(original.right,cloned.right,target);
        }
        TreeNode searchLeft = getTargetCopy(original.left, cloned.left, target);
        if (searchLeft == null) {
            if (original.right != null) {
                return getTargetCopy(original.right,cloned.right,target);
            }
            return null;
        }
        return searchLeft;
    }

}
