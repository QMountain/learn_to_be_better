package algorithm.leetcode.medium.c;

import algorithm.TreeNode;

public class ConstructMaximumBinaryTree {

    // 此方法是基本解，但不是最优解，最优解：单调栈（查找每个元素左侧和右侧的最大元素）
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructFromIndex(nums,0,nums.length-1);
    }

    public TreeNode constructFromIndex(int[] nums, int left, int right) {
        int maxIndex = left;
        for (int i = left+1; i <= right; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        TreeNode leftNode = null;
        if (left <= maxIndex-1) {
            leftNode = constructFromIndex(nums, left, maxIndex-1);
        }
        TreeNode rightNode = null;
        if (maxIndex+1 <= right) {
            rightNode = constructFromIndex(nums, maxIndex+1, right);
        }
        return new TreeNode(nums[maxIndex],leftNode,rightNode);
    }

    public static void main(String[] args) {
        ConstructMaximumBinaryTree constructMaximumBinaryTree = new ConstructMaximumBinaryTree();
        TreeNode node = constructMaximumBinaryTree.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
        System.out.println(node);
        TreeNode node1 = constructMaximumBinaryTree.constructMaximumBinaryTree(new int[]{3,2,1});
        System.out.println(node1);
    }
}
