package algorithm.leetcode.medium.b;

import algorithm.TreeNode;

public class BtreeGameWinningMove {

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        if (root.val == x) {
            int leftCount = countNode(root.left);
            int rightCount = countNode(root.right);
            return leftCount != rightCount;
        }
        TreeNode nodeX = searchNodeX(root, x);
        int leftCount = nodeX.left == null ? 0 : countNode(nodeX.left);
        int rightCount = nodeX.right == null ? 0 : countNode(nodeX.right);
        int childrenCount = leftCount + rightCount;
        int parentCount = n - 1 - childrenCount;
        if (parentCount > childrenCount) {
            return true;
        }
        if (leftCount > rightCount + parentCount) {
            return true;
        }
        return rightCount > leftCount + parentCount;
    }

    public int countNode(TreeNode root) {
        int ans = 1;
        if (root.left != null) {
            ans += countNode(root.left);
        }
        if (root.right != null) {
            ans += countNode(root.right);
        }
        return ans;
    }

    public TreeNode searchNodeX(TreeNode root, int x) {
        if (root.val == x) {
            return root;
        }
        if (root.left != null) {
            TreeNode nodeX = searchNodeX(root.left, x);
            if (nodeX != null) {
                return nodeX;
            }
        }
        if (root.right != null) {
            return searchNodeX(root.right, x);
        }
        return null;
    }

    public static void main(String[] args) {
        BtreeGameWinningMove btreeGameWinningMove = new BtreeGameWinningMove();
        System.out.println(btreeGameWinningMove.btreeGameWinningMove(new TreeNode(6,
                new TreeNode(3,
                        new TreeNode(7),
                        new TreeNode(4,
                                null,
                                new TreeNode(2,
                                        null,
                                        new TreeNode(1,
                                                null,
                                                new TreeNode(5))))),
                null), 7, 3));
        System.out.println(btreeGameWinningMove.btreeGameWinningMove(new TreeNode(1,
                new TreeNode(2), new TreeNode(3)), 3, 2));
        System.out.println(btreeGameWinningMove.btreeGameWinningMove(new TreeNode(1,
                new TreeNode(2), new TreeNode(3)), 3, 1));
        System.out.println(btreeGameWinningMove.btreeGameWinningMove(new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4,
                                new TreeNode(8), new TreeNode(9)),
                        new TreeNode(5,
                                new TreeNode(10), new TreeNode(11))),
                new TreeNode(3,
                        new TreeNode(6), new TreeNode(7))), 11, 3));
    }

}
