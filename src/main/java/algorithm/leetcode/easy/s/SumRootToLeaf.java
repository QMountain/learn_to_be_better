package algorithm.leetcode.easy.s;

import algorithm.TreeNode;

public class SumRootToLeaf {

    /**
     * 1022. 从根到叶的二进制数之和
     * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。
     * 例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
     * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
     * 返回这些数字之和。题目数据保证答案是一个 32 位 整数。
     * 树中的节点数在 [1, 1000] 范围内
     * Node.val 仅为 0 或 1
     */
    public int sumRootToLeaf(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }
        int sum = 0;
        if (root.left != null) {
            root.left.val = (root.val << 1) + root.left.val;
            sum += sumRootToLeaf(root.left);
        }
        if (root.right != null) {
            root.right.val = (root.val << 1) + root.right.val;
            sum += sumRootToLeaf(root.right);
        }
        return sum;
    }

    public int sumRootToLeaf2(TreeNode root) {
        return sum(root,root.val);
    }

    public int sum(TreeNode node,int lastValue) {
        if (node.left == null && node.right == null) {
            return lastValue;
        }
        if (node.left == null) {
            return sum(node.right,lastValue*2+node.right.val);
        }
        if (node.right == null) {
            return sum(node.left,lastValue*2+node.left.val);
        }
        return sum(node.right,lastValue*2+node.right.val) +
                sum(node.left,lastValue*2+node.left.val);
    }

    public static void main(String[] args) {
        SumRootToLeaf sumRootToLeaf = new SumRootToLeaf();
        System.out.println(sumRootToLeaf.sumRootToLeaf(new TreeNode(1,new TreeNode(0),null)));
        System.out.println(sumRootToLeaf.sumRootToLeaf(new TreeNode(1,
                new TreeNode(0,
                        new TreeNode(0),new TreeNode(1)),
                new TreeNode(1,
                        new TreeNode(0),new TreeNode(1)))));
    }
}
