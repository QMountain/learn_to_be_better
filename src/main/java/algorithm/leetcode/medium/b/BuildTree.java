package algorithm.leetcode.medium.b;

import algorithm.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;
        if (length == 1) {
            return new TreeNode(preorder[0]);
        }
        Set<Integer> leftInOrderSet = new HashSet<>();
        int rootIndexAtInOrder = -1;
        for (int i = 0; i < length; i++) {
            if (inorder[i] == preorder[0]) {
                rootIndexAtInOrder = i;
                break;
            } else {
                leftInOrderSet.add(inorder[i]);
            }
        }
        int rightNodeStartIndexAtPreOrder = -1;
        for (int i = 1; i < length; i++) {
            if (!leftInOrderSet.contains(preorder[i])) {
                rightNodeStartIndexAtPreOrder = i;
                break;
            }
        }
        TreeNode left = null;
        if (rootIndexAtInOrder > 0) {
            if (rightNodeStartIndexAtPreOrder != -1) {
                left = buildTreeByIndex(preorder, inorder, 1, rightNodeStartIndexAtPreOrder - 1, 0, rootIndexAtInOrder - 1);
            } else {
                left = buildTreeByIndex(preorder, inorder, 1, length - 1, 0, rootIndexAtInOrder - 1);
            }
        }
        TreeNode right = null;
        if (rightNodeStartIndexAtPreOrder != -1) {
            right = buildTreeByIndex(preorder,inorder,rightNodeStartIndexAtPreOrder,length-1,rootIndexAtInOrder+1,length-1);
        }
        return new TreeNode(preorder[0],left,right);
    }

    public TreeNode buildTreeByIndex(int[] preorder, int[] inorder,
                                     int preLeft, int preRight,
                                     int inLeft, int inRight) {
        if (preLeft == preRight) {
            return new TreeNode(preorder[preLeft]);
        }
        Set<Integer> leftInOrderSet = new HashSet<>();
        int rootIndexAtInOrder = -1;
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == preorder[preLeft]) {
                rootIndexAtInOrder = i;
                break;
            } else {
                leftInOrderSet.add(inorder[i]);
            }
        }
        int rightNodeStartIndexAtPreOrder = -1;
        for (int i = preLeft+1; i <= preRight; i++) {
            if (!leftInOrderSet.contains(preorder[i])) {
                rightNodeStartIndexAtPreOrder = i;
                break;
            }
        }
        TreeNode left = null;
        if (rootIndexAtInOrder > inLeft) {
            if (rightNodeStartIndexAtPreOrder != -1) {
                left = buildTreeByIndex(preorder, inorder, preLeft+1, rightNodeStartIndexAtPreOrder - 1, inLeft, rootIndexAtInOrder - 1);
            } else {
                left = buildTreeByIndex(preorder, inorder, preLeft+1, preRight, inLeft, rootIndexAtInOrder - 1);
            }
        }
        TreeNode right = null;
        if (rightNodeStartIndexAtPreOrder != -1) {
            right = buildTreeByIndex(preorder,inorder,rightNodeStartIndexAtPreOrder,preRight,rootIndexAtInOrder+1,inRight);
        }
        return new TreeNode(preorder[preLeft],left,right);
    }

    public static void main(String[] args) {
        BuildTree buildTree = new BuildTree();
        TreeNode node4 = buildTree.buildTree(new int[]{1,2,3}, new int[]{1,2,3});
        TreeNode node3 = buildTree.buildTree(new int[]{1,2,3}, new int[]{3,2,1});
        TreeNode node2 = buildTree.buildTree(new int[]{1,2}, new int[]{1,2});
        TreeNode node1 = buildTree.buildTree(new int[]{1,2}, new int[]{2,1});
        TreeNode node = buildTree.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        System.out.println(node.toString());
    }
}
