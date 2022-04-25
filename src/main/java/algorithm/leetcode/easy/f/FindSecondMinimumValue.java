package algorithm.leetcode.easy.f;

import algorithm.TreeNode;

public class FindSecondMinimumValue {

    public int findSecondMinimumValue(TreeNode root) {
        if (root.left == null) {
            return -1;
        }
        if (root.left.val > root.right.val) {
            int value = findSecondMinimumValue(root.right);
            if (value == -1 || value == root.val) {
                return root.left.val;
            }
            return Math.min(value,root.left.val);
        } else if (root.left.val < root.right.val) {
            int value = findSecondMinimumValue(root.left);
            if (value == -1 || value == root.val) {
                return root.right.val;
            }
            return Math.min(value,root.right.val);
        }
        int value1 = findSecondMinimumValue(root.left);
        int value2 = findSecondMinimumValue(root.right);
        if (value1 == -1 && value2 == -1) {
            return -1;
        }
        if (value1 == -1) {
            return value2;
        }
        if (value2 == -1) {
            return value1;
        }
        return Math.min(value1,value2);
    }

    public static void main(String[] args) {
        FindSecondMinimumValue findSecondMinimumValue = new FindSecondMinimumValue();
        System.out.println(findSecondMinimumValue.findSecondMinimumValue(new TreeNode(1,
                new TreeNode(1,
                        new TreeNode(1,
                                new TreeNode(3,new TreeNode(3),new TreeNode(3)),
                                new TreeNode(1,new TreeNode(1),new TreeNode(6))),
                        new TreeNode(1,
                                new TreeNode(1,new TreeNode(2),new TreeNode(1)),
                                new TreeNode(1))),
                new TreeNode(3,
                        new TreeNode(3,
                                new TreeNode(3),new TreeNode(8)),
                        new TreeNode(4,new TreeNode(4),new TreeNode(8))))));
    }
}
