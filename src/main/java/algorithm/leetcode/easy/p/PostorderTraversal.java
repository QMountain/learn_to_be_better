package algorithm.leetcode.easy.p;

import algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            list.add(0,root.val);
            list.addAll(0,postorderTraversal(root.right));
            list.addAll(0,postorderTraversal(root.left));
        }
        return list;
    }

    public static void main(String[] args) {
        PostorderTraversal postorderTraversal = new PostorderTraversal();
        System.out.println(postorderTraversal.postorderTraversal(new TreeNode(1,
                null, new TreeNode(2, new TreeNode(3), null))));
        System.out.println(postorderTraversal.postorderTraversal(null));
        System.out.println(postorderTraversal.postorderTraversal(new TreeNode(1)));
    }
}
