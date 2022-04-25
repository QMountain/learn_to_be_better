package algorithm.leetcode.easy.r;

import algorithm.TreeNode;

public class RangeSumBST {

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root.val < low) {
            if (root.right != null) {
                return rangeSumBST(root.right,low,high);
            }
            return 0;
        }
        if (root.val > high) {
            if (root.left != null) {
                return rangeSumBST(root.left,low,high);
            }
            return 0;
        }
        int sum = root.val;
        if (root.left != null) {
            sum += rangeSumBST(root.left,low,high);
        }
        if (root.right != null) {
            sum += rangeSumBST(root.right,low,high);
        }
        return sum;
    }

    public static void main(String[] args) {
        RangeSumBST rangeSumBST = new RangeSumBST();
        System.out.println(rangeSumBST.rangeSumBST(new TreeNode(10, new TreeNode(5,
                new TreeNode(3), new TreeNode(7)),
                new TreeNode(15, null, new TreeNode(18))), 7, 15));
    }
}
