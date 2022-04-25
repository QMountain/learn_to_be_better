package algorithm.leetcode.easy.m;

import algorithm.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// 二叉树，本身就是有序的，左孩子 < 根 < 右孩子
public class MinDiffInBST {

    public int minDiffInBST(TreeNode root) {
        List<Integer> list = getValue(root);
        int size = list.size();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = list.get(i);
        }
        Arrays.sort(arr);
        int min = arr[1] - arr[0];
        for (int i = 0; i < size - 1; i++) {
            min = Math.min(arr[i + 1] - arr[i],min);
        }
        return min;
    }

    public List<Integer> getValue(TreeNode node) {
        List<Integer> list = new LinkedList<>();
        if (node != null) {
            list.add(node.val);
            list.addAll(getValue(node.left));
            list.addAll(getValue(node.right));
        }
        return list;
    }

}
