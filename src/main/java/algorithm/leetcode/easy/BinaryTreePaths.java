package algorithm.leetcode.easy;

import algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root.left == null && root.right == null) {
            list.add(root.val+"");
            return list;
        }
        if (root.left != null) {
            List<String> leftList = binaryTreePaths(root.left);
            for (String s : leftList) {
                list.add(root.val+"->"+s);
            }
        }
        if (root.right != null) {
            List<String> rightList = binaryTreePaths(root.right);
            for (String s : rightList) {
                list.add(root.val+"->"+s);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        BinaryTreePaths binaryTreePaths = new BinaryTreePaths();
        System.out.println(binaryTreePaths.binaryTreePaths(new TreeNode(1,
                new TreeNode(2, null, new TreeNode(5)),
                new TreeNode(3))));
    }
}
