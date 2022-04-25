package algorithm.leetcode.easy.i;

import algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class IncreasingBST {

    public TreeNode increasingBST(TreeNode root) {
        List<Integer> value = getValue(root);
        int size = value.size();
        if (size == 1) {
            return new TreeNode(value.get(0));
        }
        TreeNode node = new TreeNode(value.get(size-1));
        for (int i = size-2; i >= 0; i--) {
            Integer integer = value.get(i);
            node = new TreeNode(integer,null,node);
        }
        return node;
    }

    public List<Integer> getValue(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        if (node != null) {
            if (node.left == null && node.right == null) {
                list.add(node.val);
            } else {
                if (node.left != null) {
                    list.addAll(getValue(node.left));
                }
                list.add(node.val);
                if (node.right != null) {
                    list.addAll(getValue(node.right));
                }
            }
        }
        return list;
    }
}
