package algorithm.leetcode.medium.i;

import algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InorderSuccessor {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        List<TreeNode> inorder = inorder(root);
        int i1 = inorder.indexOf(p);
        if (i1 == -1 || i1 == inorder.size()-1) {
            return null;
        }
        return inorder.get(i1+1);
    }

    public List<TreeNode> inorder(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        if (root.left != null) {
            list.addAll(inorder(root.left));
        }
        list.add(root);
        if (root.right != null) {
            list.addAll(inorder(root.right));
        }
        return list;
    }

    public static void main(String[] args) {
        InorderSuccessor inorderSuccessor = new InorderSuccessor();
        System.out.println(inorderSuccessor.inorderSuccessor(new TreeNode(6,
                        new TreeNode(2, new TreeNode(0), new TreeNode(4,
                                new TreeNode(3), new TreeNode(5))),
                        new TreeNode(8, new TreeNode(7), new TreeNode(9))),
                new TreeNode(2)).val);
        System.out.println(inorderSuccessor.inorderSuccessor(
                new TreeNode(5, new TreeNode(3,
                        new TreeNode(1,null,new TreeNode(2)),
                        new TreeNode(4)), new TreeNode(6)),
                new TreeNode(4)));
    }
}
