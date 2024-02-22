package algorithm.leetcode.medium.b;

import algorithm.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class BuildTree {

    // 题号 105 从前序与中序遍历序列构造二叉树
    // 1 <= preorder.length <= 3000
    // inorder.length == preorder.length
    // preorder 和 inorder 均 无重复 元素
    // 前序：根左右
    // 中序：左根右
    /*public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder,
                              int preStart, int preEnd, int inStart, int inEnd) {
        if (preEnd == preStart) {
            return new TreeNode(preorder[preStart]);
        }
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                TreeNode left = buildTree(preorder, inorder,
                        preStart + 1, preStart + i - inStart,
                        inStart, i - 1);
                TreeNode right = buildTree(preorder, inorder,
                        preStart + i - inStart + 1, preEnd,
                        i + 1, inEnd);
                return new TreeNode(preorder[preStart], left, right);
            }
        }
        return null;
    }*/

    // 题号106 medium 从中序与后序遍历序列构造二叉树
    // 中序：左根右
    // 后序：左右根
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder,
                0, inorder.length-1, 0, postorder.length-1);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder,
                              int inStart, int inEnd,
                              int postStart, int postEnd) {
        if (postStart == postEnd) {
            return new TreeNode(postorder[postStart]);
        }
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == postorder[postEnd]) {
                TreeNode left = buildTree(inorder, postorder,
                        inStart, i - 1, postStart, postStart + i - inStart - 1);
                TreeNode right = buildTree(inorder, postorder,
                        i + 1, inEnd, postStart + i - inStart, postEnd - 1);
                return new TreeNode(inorder[i], left, right);
            }
        }
        return null;
    }

    // 题号106，medium 从中序与后序遍历序列构造二叉树
    public TreeNode buildTree3(int[] inorder, int[] postorder) {
        int pl = postorder.length;
        int rootVal = postorder[pl-1];
        TreeNode root = new TreeNode(rootVal);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                if (i > 0) {
                    int[] nInorder = new int[i];
                    int[] nPostorder = new int[i];
                    System.arraycopy(inorder,0,nInorder,0,i);
                    System.arraycopy(postorder,0,nPostorder,0,i);
                    root.left = buildTree(nInorder,nPostorder);
                }

                int l = inorder.length - i - 1;
                if (l > 0) {
                    int[] rightInorder = new int[l];
                    int[] rightPostorder = new int[l];
                    System.arraycopy(inorder,i+1,rightInorder,0,l);
                    System.arraycopy(postorder,i,rightPostorder,0,l);
                    root.right = buildTree(rightInorder,rightPostorder);
                }
                break;
            }
        }
        return root;
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
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

        TreeNode treeNode = buildTree.buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
        System.out.println(treeNode);


        /*
        TreeNode node = buildTree.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        TreeNode node4 = buildTree.buildTree(new int[]{1,2,3}, new int[]{1,2,3});
        TreeNode node3 = buildTree.buildTree(new int[]{1,2,3}, new int[]{3,2,1});
        TreeNode node2 = buildTree.buildTree(new int[]{1,2}, new int[]{1,2});
        TreeNode node1 = buildTree.buildTree(new int[]{1,2}, new int[]{2,1});
        TreeNode node = buildTree.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        System.out.println(node.toString());*/
    }
}
