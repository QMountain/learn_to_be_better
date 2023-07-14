package algorithm.leetcode.medium.d;

import algorithm.TreeNode;

public class DistributeCoins {

    // 1 <= N <= 100
    // 0 <= node.val <= N
    public int distributeCoins(TreeNode root) {
        int moves = 0;
        if (root.left != null) {
            if (isLeaf(root.left)) {
                if (root.left.val < 1) {
                    root.val += root.left.val - 1;
                    moves += Math.abs(root.left.val - 1);
                    root.left.val = 1;
                } else if (root.left.val > 1) {
                    root.val += root.left.val - 1;
                    moves += Math.abs(root.left.val - 1);
                    root.left.val = 1;
                } else {
                    root.left = null;
                }
            } else {
                moves += distributeCoins(root.left);
                root.left.left = null;
                root.left.right = null;
                return distributeCoins(root) + moves;
            }
        }
        if (root.right != null) {
            if (isLeaf(root.right)) {
                if (root.right.val < 1) {
                    root.val += root.right.val - 1;
                    moves += Math.abs(root.right.val - 1);
                    root.right.val = 1;
                } else if (root.right.val > 1) {
                    root.val += root.right.val - 1;
                    moves += Math.abs(root.right.val - 1);
                    root.right.val = 1;
                } else {
                    root.right = null;
                }
            } else {
                moves += distributeCoins(root.right);
                root.right.left = null;
                root.right.right = null;
                return distributeCoins(root) + moves;
            }
        }
        return moves;
    }

    public boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public static void main(String[] args) {
        DistributeCoins distributeCoins = new DistributeCoins();
        System.out.println(5 == distributeCoins.distributeCoins(new TreeNode(0,
                new TreeNode(3, null, null),
                new TreeNode(1, null,
                        new TreeNode(1, null, new TreeNode(0))))));
        System.out.println(4 == distributeCoins.distributeCoins(new TreeNode(1,
                new TreeNode(0, null, new TreeNode(3)), new TreeNode(0))));
        System.out.println(2 == distributeCoins.distributeCoins(new TreeNode(1,
                new TreeNode(0), new TreeNode(2))));
        System.out.println(3 == distributeCoins.distributeCoins(new TreeNode(0,
                new TreeNode(3), new TreeNode(0))));
        System.out.println(2 == distributeCoins.distributeCoins(new TreeNode(3,
                new TreeNode(0), new TreeNode(0))));
    }
}
