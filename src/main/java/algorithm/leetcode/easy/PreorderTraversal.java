package algorithm.leetcode.easy;

import algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            list.add(root.val);
            list.addAll(preorderTraversal(root.left));
            list.addAll(preorderTraversal(root.right));
        }
        return list;
    }

    public static void main(String[] args) {
        PreorderTraversal preorderTraversal = new PreorderTraversal();
        System.out.println(preorderTraversal.preorderTraversal(new TreeNode(1,
                null,
                new TreeNode(2, new TreeNode(3), null))));
        System.out.println(preorderTraversal.preorderTraversal(null));
        System.out.println(preorderTraversal.preorderTraversal(new TreeNode(1)));
        System.out.println(preorderTraversal.preorderTraversal(new TreeNode(1,
                new TreeNode(2),null)));
        System.out.println(preorderTraversal.preorderTraversal(new TreeNode(1,null,
                new TreeNode(2))));
    }
}
