package algorithm.leetcode.easy;

import algorithm.TreeNode;

public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        int length = nums.length;
        int rootIndex = length/2;
        TreeNode node = new TreeNode(nums[rootIndex]);
        if (0 <= rootIndex-1) {
            node.left = subArrayToBST(nums,0,rootIndex-1);
        }
        if (rootIndex+1 <= length-1) {
            node.right = subArrayToBST(nums,rootIndex+1,length-1);
        }
        return node;
    }

    public TreeNode subArrayToBST(int[] nums, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return new TreeNode(nums[startIndex]);
        }
        int length = endIndex-startIndex+1;
        int rootIndex = length/2 + startIndex;
        TreeNode node = new TreeNode(nums[rootIndex]);
        if (startIndex <= rootIndex-1) {
            node.left = subArrayToBST(nums,startIndex,rootIndex-1);
        }
        if (rootIndex+1 <= endIndex) {
            node.right = subArrayToBST(nums,rootIndex+1,endIndex);
        }
        return node;
    }

    public static void main(String[] args) {
        SortedArrayToBST sortedArrayToBST = new SortedArrayToBST();
        /*System.out.println(sortedArrayToBST.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));
        System.out.println(sortedArrayToBST.sortedArrayToBST(new int[]{1,3}));*/
        System.out.println(sortedArrayToBST.sortedArrayToBST(new int[]{0}));
    }
}
