package algorithm.leetcode.medium.d;

import algorithm.TreeNode;

import java.util.*;

public class DistanceK {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        if (k == 0) {
            ans.add(target.val);
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        while (true) {
            stack.push(curNode);
            if (curNode == target) {
                break;
            }
            if (curNode.left != null) {
                curNode = curNode.left;
            } else if (curNode.right != null) {
                curNode = curNode.right;
            } else {
                while (true) {
                    TreeNode pop = stack.pop();
                    TreeNode parent = stack.peek();
                    if (parent.left == pop) {
                        if (parent.right != null) {
                            curNode = parent.right;
                            break;
                        }
                    }
                }
            }
        }

        int ck = k;
        while (ck >= 0) {
            TreeNode pop = stack.pop();
            ans.addAll(searchChildren(pop, ck));
            if (stack.isEmpty()) {
                break;
            }
            TreeNode parent = stack.peek();
            if (ck == 1) {
                ans.add(parent.val);
                break;
            }
            if (parent.left == pop) {
                if (parent.right != null) {
                    ans.addAll(searchChildren(parent.right, ck - 2));
                }
            } else if (parent.left != null) {
                ans.addAll(searchChildren(parent.left, ck - 2));
            }
            parent.left = null;
            parent.right = null;
            ck--;
        }
        return ans;
    }

    public List<Integer> searchChildren(TreeNode root, int k) {
        List<Integer> ans = new ArrayList<>();
        if (k == 0) {
            ans.add(root.val);
            return ans;
        }
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        for (int i = 0; i < k; i++) {
            List<TreeNode> next = new ArrayList<>();
            for (TreeNode node : nodes) {
                if (node.left != null) {
                    next.add(node.left);
                }
                if (node.right != null) {
                    next.add(node.right);
                }
            }
            nodes = next;
        }
        List<Integer> res = new ArrayList<>();
        for (TreeNode node : nodes) {
            res.add(node.val);
        }
        return res;
    }

    public static void main(String[] args) {
        DistanceK distanceK = new DistanceK();
        TreeNode treeNode2_1 = new TreeNode(2,
                null,
                new TreeNode(3,
                        null,
                        new TreeNode(4)));
        System.out.println(distanceK.distanceK(new TreeNode(0,
                null,
                new TreeNode(1,
                        treeNode2_1,
                        new TreeNode(5))), treeNode2_1, 2));

        TreeNode treeNode3_1 = new TreeNode(3, null, new TreeNode(4));
        System.out.println(distanceK.distanceK(new TreeNode(0,
                new TreeNode(1,
                        null,
                        new TreeNode(2,
                                null,
                                treeNode3_1)),
                null), treeNode3_1, 0));

        TreeNode treeNode2 = new TreeNode(2);
        System.out.println(distanceK.distanceK(new TreeNode(0,
                new TreeNode(1,
                        new TreeNode(3),
                        treeNode2),
                null), treeNode2, 1));

        TreeNode treeNode3 = new TreeNode(3);
        System.out.println(distanceK.distanceK(new TreeNode(0,
                new TreeNode(2),
                new TreeNode(1,
                        treeNode3,
                        null)), treeNode3, 3));


        TreeNode treeNode5 = new TreeNode(5,
                new TreeNode(6),
                new TreeNode(2,
                        new TreeNode(7),
                        new TreeNode(4)));
        System.out.println(distanceK.distanceK(new TreeNode(3,
                treeNode5,
                new TreeNode(1,
                        new TreeNode(0),
                        new TreeNode(8))), treeNode5, 2));
    }
}
