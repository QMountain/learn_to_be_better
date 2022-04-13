package algorithm.leetcode.easy;

import algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class GetMinimumDifference {

    public int getMinimumDifference(TreeNode root) {
        List<Integer> value = getValue(root);
        int size = value.size();
        int min = value.get(1) - value.get(0);
        for (int i = 1; i < size - 1; i++) {
            min = Math.min(value.get(i+1)-value.get(i),min);
        }
        return min;
    }

    public List<Integer> getValue(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        if (node.left != null) {
            if (node.left.left != null || node.left.right != null) {
                List<Integer> value = getValue(node.left);
                list.addAll(value);
            } else {
                list.add(node.left.val);
            }
        }
        list.add(node.val);
        if (node.right != null) {
            if (node.right.left != null || node.right.right != null) {
                List<Integer> value = getValue(node.right);
                list.addAll(value);
            } else {
                list.add(node.right.val);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        GetMinimumDifference getMinimumDifference = new GetMinimumDifference();
        System.out.println(getMinimumDifference.getMinimumDifference(
                new TreeNode(4,
                        new TreeNode(2,new TreeNode(1),new TreeNode(3)),
                        new TreeNode(6))));
    }
}
