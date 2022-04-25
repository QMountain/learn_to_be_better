package algorithm.leetcode.easy.s;

import algorithm.TreeNode;

public class SumRootToLeaf {

    public int sumRootToLeaf(TreeNode root) {
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
