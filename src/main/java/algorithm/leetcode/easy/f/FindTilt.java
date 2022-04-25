package algorithm.leetcode.easy.f;

import algorithm.TreeNode;

public class FindTilt {

    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sumLeft = 0;
        int tiltLeft = 0;
        if (root.left != null) {
            int[] sumAndTilt = getSumAndTilt(root.left);
            sumLeft = sumAndTilt[0];
            tiltLeft = sumAndTilt[1];
        }
        int sumRight = 0;
        int tiltRight = 0;
        if (root.right != null) {
            int[] sumAndTilt = getSumAndTilt(root.right);
            sumRight = sumAndTilt[0];
            tiltRight = sumAndTilt[1];
        }
        return tiltLeft + tiltRight + Math.abs(sumLeft-sumRight);
    }

    public int[] getSumAndTilt(TreeNode node) {
        int sumLeft = 0;
        int tiltLeft = 0;
        if (node.left != null) {
            if (node.left.left != null || node.left.right != null) {
                int[] sumAndTilt = getSumAndTilt(node.left);
                sumLeft = sumAndTilt[0];
                tiltLeft = sumAndTilt[1];
            } else {
                sumLeft = node.left.val;
            }
        }
        int sumRight = 0;
        int tiltRight = 0;
        if (node.right != null) {
            if (node.right.left != null || node.right.right != null) {
                int[] sumAndTilt = getSumAndTilt(node.right);
                sumRight = sumAndTilt[0];
                tiltRight = sumAndTilt[1];
            } else {
                sumRight = node.right.val;
            }
        }
        int[] arr = new int[2];
        arr[0] = sumLeft + sumRight + node.val;
        arr[1] = tiltLeft + tiltRight + Math.abs(sumLeft-sumRight);
        return arr;
    }

    public static void main(String[] args) {
        FindTilt findTilt = new FindTilt();
        System.out.println(findTilt.findTilt(new TreeNode(4,
                new TreeNode(2,new TreeNode(3),new TreeNode(5)),
                new TreeNode(9,null,new TreeNode(7)))));
        System.out.println(findTilt.findTilt(new TreeNode(1, new TreeNode(2), new TreeNode(3))));
    }
}
