package algorithm.leetcode.medium.f;

import algorithm.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class FindElements {

    Set<Integer> set;

    public FindElements(TreeNode root) {
        set = new HashSet<>();
        root.val = 0;
        recoverChildren(root);
    }

    public void recoverChildren(TreeNode root) {
        set.add(root.val);
        if (root.left != null) {
            root.left.val = root.val * 2 + 1;
            recoverChildren(root.left);
        }
        if (root.right != null) {
            root.right.val = root.val * 2 + 2;
            recoverChildren(root.right);
        }
    }

    public boolean find(int target) {
        return set.contains(target);
    }

}
