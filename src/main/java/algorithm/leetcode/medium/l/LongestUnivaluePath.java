package algorithm.leetcode.medium.l;

import algorithm.TreeNode;

public class LongestUnivaluePath {

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int currRootMax = 0;
        if (root.left != null && root.val == root.left.val) {
            currRootMax += longestBaseOnRoot(root.left)+1;
        }
        if (root.right != null && root.val == root.right.val) {
            currRootMax += longestBaseOnRoot(root.right)+1;
        }
        if (root.left != null) {
            int left = longestUnivaluePath(root.left);
            currRootMax = Math.max(currRootMax,left);
        }
        if (root.right != null) {
            int right = longestUnivaluePath(root.right);
            currRootMax = Math.max(currRootMax,right);
        }
        return currRootMax;
    }

    public int longestBaseOnRoot(TreeNode root) {
        int longest = 0;
        if (root.left != null && root.left.val == root.val) {
            longest = longestBaseOnRoot(root.left)+1;
        }
        if (root.right != null && root.right.val == root.val) {
            longest = Math.max(longest,longestBaseOnRoot(root.right)+1);
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestUnivaluePath longestUnivaluePath = new LongestUnivaluePath();
        System.out.println(longestUnivaluePath.longestUnivaluePath(new TreeNode(1,
                new TreeNode(4,new TreeNode(4),new TreeNode(4)),
                new TreeNode(5,null,new TreeNode(5)))));
        System.out.println(2 == longestUnivaluePath.longestUnivaluePath(new TreeNode(5,
                new TreeNode(4,new TreeNode(1), new TreeNode(1)),
                new TreeNode(5,null,new TreeNode(5)))));
    }
}
