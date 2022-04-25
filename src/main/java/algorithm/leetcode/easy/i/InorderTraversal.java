package algorithm.leetcode.easy.i;

import algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> resList = new ArrayList<>();

        if (root.left == null) {
            resList.add(root.val);
            resList.addAll(inorderTraversal(root.right));
        } else {
            if (root.left.left == null) {
                resList.add(root.left.val);
                if (root.left.right != null) {
                    resList.addAll(inorderTraversal(root.left.right));
                }
                resList.add(root.val);
                if (root.right != null) {
                    resList.addAll(inorderTraversal(root.right));
                }
            } else {
                resList.addAll(inorderTraversal(root.left));
                resList.add(root.val);
                if (root.right != null) {
                    resList.addAll(inorderTraversal(root.right));
                }
            }

        }
        return resList;
    }

    public static void main(String[] args) {
        InorderTraversal inorderTraversal = new InorderTraversal();
        System.out.println(inorderTraversal.inorderTraversal(
                new TreeNode(1,
                    new TreeNode(2,
                            new TreeNode(4,
                                    new TreeNode(6),
                                    new TreeNode(7, new TreeNode(8), new TreeNode(9))),new TreeNode(5)), new TreeNode(3))));
        /*System.out.println(inorderTraversal.inorderTraversal(new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null))));
        System.out.println(inorderTraversal.inorderTraversal(null));
        System.out.println(inorderTraversal.inorderTraversal(new TreeNode(1)));
        System.out.println(inorderTraversal.inorderTraversal(new TreeNode(1, new TreeNode(2), null)));
        System.out.println(inorderTraversal.inorderTraversal(new TreeNode(1, null, new TreeNode(2))));*/
        System.out.println(inorderTraversal.inorderTraversal(new TreeNode(2, new TreeNode(3,new TreeNode(1),null), null)));
        System.out.println(inorderTraversal.inorderTraversal(new TreeNode(3, new TreeNode(1,null,new TreeNode(2)), null)));
    }

}

