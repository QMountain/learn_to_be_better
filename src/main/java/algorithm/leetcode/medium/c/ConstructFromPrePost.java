package algorithm.leetcode.medium.c;

import algorithm.TreeNode;

public class ConstructFromPrePost {

    // 前序：根左右
    // 后序：左右根
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return constructFromPrePost(preorder, postorder,
                0, preorder.length-1,
                0, postorder.length-1);
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder,
                                         int preStart, int preEnd,
                                         int postStart, int postEnd) {
        if (preorder[preStart] == preorder[preEnd]) {
            return new TreeNode(preorder[preStart]);
        }
        if (preStart + 1 == preEnd) {
            TreeNode left = new TreeNode(preorder[preStart+1]);
            return new TreeNode(preorder[preStart], left, null);
        }
        if (preorder[preStart+1] == postorder[postEnd-1]) {
            TreeNode left = constructFromPrePost(preorder, postorder,
                    preStart + 1, preEnd, postStart, postEnd - 1);
            return new TreeNode(preorder[preStart], left, null);
        }
        for (int i = preEnd; i >= preStart; i--) {
            if (preorder[i] == postorder[postEnd-1]) {
                TreeNode left = constructFromPrePost(preorder, postorder,
                        preStart + 1, i - 1,
                        postStart, i - 2 - preStart + postStart);
                TreeNode right = constructFromPrePost(preorder, postorder,
                        i, preEnd,
                        postEnd - preEnd + i - 1, postEnd - 1);
                return new TreeNode(preorder[preStart], left, right);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ConstructFromPrePost constructFromPrePost = new ConstructFromPrePost();
        TreeNode treeNode3 = constructFromPrePost.constructFromPrePost(
                new int[]{8,6,1,9,10,3,4,7,2,5}, new int[]{9,1,6,2,7,4,3,5,10,8});
        TreeNode treeNode2 = constructFromPrePost.constructFromPrePost(
                new int[]{1,10,2,4,8,6,7,3,9,5}, new int[]{7,6,8,4,2,10,9,5,3,1});
        TreeNode treeNode1 = constructFromPrePost.constructFromPrePost(
                new int[]{2,1,3}, new int[]{3,1,2});
        TreeNode treeNode = constructFromPrePost.constructFromPrePost(
                new int[]{1,2,4,5,3,6,7}, new int[]{4,5,2,6,7,3,1});
        System.out.println(treeNode);
    }
}
