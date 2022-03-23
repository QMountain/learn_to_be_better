package algorithm.leetcode.medium;

import algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class KthSmallest {

    public int kthSmallest(TreeNode root, int k) {
        Set<Integer> set = new TreeSet<>();
        addSet(root,set);
        List<Integer> list = new ArrayList<>(set);
        return list.get(k-1);
    }

    public void addSet(TreeNode root, Set<Integer> set) {
        if (root != null) {
            set.add(root.val);
            addSet(root.left,set);
            addSet(root.right,set);
        }
    }

    public static void main(String[] args) {
        KthSmallest kthSmallest = new KthSmallest();
        System.out.println(kthSmallest.kthSmallest(new TreeNode(3,
                        new TreeNode(1, null, new TreeNode(2)),
                        new TreeNode(4)),
                1));
    }
}
