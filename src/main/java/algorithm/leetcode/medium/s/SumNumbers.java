package algorithm.leetcode.medium.s;

import algorithm.TreeNode;

public class SumNumbers {

    public int sumNumbers(TreeNode root) {
        return sumByBase(root,0);
    }

    public int sumByBase(TreeNode root, int base) {
        int value = base*10+root.val;
        if (root.left == null && root.right == null) {
            return value;
        }
        int ans = 0;
        if (root.left != null) {
            ans += sumByBase(root.left,value);
        }
        if (root.right != null) {
            ans += sumByBase(root.right,value);
        }
        return ans;
    }

    public static void main(String[] args) {
        SumNumbers sumNumbers = new SumNumbers();
        System.out.println(sumNumbers.sumNumbers(new TreeNode(1, new TreeNode(2), new TreeNode(3))));
    }
}
