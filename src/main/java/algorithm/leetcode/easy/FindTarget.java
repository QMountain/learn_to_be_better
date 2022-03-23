package algorithm.leetcode.easy;

import algorithm.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class FindTarget {

    public boolean findTarget(TreeNode root, int k) {
        return find(root,k,new HashSet<>());
    }

    public boolean find(TreeNode node, int k, Set<Integer> set) {
        if (node == null) {
            return false;
        }
        if (set.contains(k-node.val)) {
            return true;
        }
        set.add(node.val);
        boolean b = find(node.left, k, set);
        if (b) {
            return true;
        }
        return find(node.right,k,set);
    }

    public static void main(String[] args) {
        FindTarget findTarget = new FindTarget();
        System.out.println(findTarget.findTarget(new TreeNode(5,
                new TreeNode(3,new TreeNode(2),new TreeNode(4)),
                new TreeNode(6,null,new TreeNode(7))), 9));
        System.out.println(findTarget.findTarget(new TreeNode(5,
                new TreeNode(3, new TreeNode(2), new TreeNode(4)),
                new TreeNode(6, null, new TreeNode(7))), 28));
    }
}
