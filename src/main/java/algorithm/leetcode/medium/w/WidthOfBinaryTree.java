package algorithm.leetcode.medium.w;

import algorithm.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class WidthOfBinaryTree {

    public int widthOfBinaryTree(TreeNode root) {
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        int maxWidth = 1;
        while (nodes.size() > 0) {
            while (!nodes.isEmpty()) {
                TreeNode node = nodes.peekFirst();
                if (node.left == null && node.right == null) {
                    nodes.pollFirst();
                } else {
                    break;
                }
            }
            if (nodes.isEmpty()) {
                break;
            }
            while (nodes.size() > 1) {
                TreeNode node = nodes.peekLast();
                if (node.left == null && node.right == null) {
                    nodes.pollLast();
                } else {
                    break;
                }
            }
            LinkedList<TreeNode> list = new LinkedList<>();
            if (nodes.peekFirst().left == null) {
                list.add(nodes.pollFirst().right);
            }
            List<TreeNode> append = new LinkedList<>();
            if (!nodes.isEmpty() && nodes.peekLast().right == null) {
                append.add(nodes.pollLast().left);
            }
            int curr = 0;
            for (TreeNode node : nodes) {
                if (node.val < 100) {
                    if (node.left == null && node.right == null) {
                        list.add(new TreeNode(102));
                        curr++;
                    } else {
                        if (node.left != null) {
                            list.add(node.left);
                        } else {
                            if (list.peekLast().val > 100) {
                                list.peekLast().val++;
                                curr++;
                            } else {
                                list.add(new TreeNode(101));
                            }
                        }
                        if (node.right != null) {
                            list.add(node.right);
                        } else {
                            if (list.peekLast().val > 100) {
                                list.peekLast().val++;
                                curr++;
                            } else {
                                list.add(new TreeNode(101));
                            }
                        }
                    }
                } else {
                    int v = (node.val - 100) * 2 + 100;
                    if (list.peekLast().val > 100) {
                        list.peekLast().val += v-100;
                        curr += v-100;
                    } else {
                        list.add(new TreeNode(v));
                        curr += v-101;
                    }
                }
            }
            list.addAll(append);
            maxWidth = Math.max(maxWidth,list.size()+curr);
            nodes = list;
        }
        return maxWidth;
    }

    public static void main(String[] args) {
        WidthOfBinaryTree widthOfBinaryTree = new WidthOfBinaryTree();
        TreeNode node = buildTree();
        System.out.println(widthOfBinaryTree.widthOfBinaryTree(node));
        System.out.println(widthOfBinaryTree.widthOfBinaryTree(new TreeNode(-64,
                new TreeNode(12,
                        new TreeNode(-4,
                                null,
                                new TreeNode(-51,
                                        null,
                                        new TreeNode(-31))),
                        new TreeNode(-53,
                                null,
                                null)),
                new TreeNode(18,
                        null,
                        new TreeNode(76,
                                new TreeNode(-93,
                                        new TreeNode(47),
                                        null),
                                new TreeNode(3,
                                        new TreeNode(3),
                                        new TreeNode(53)))))));
        System.out.println(widthOfBinaryTree.widthOfBinaryTree(new TreeNode(1,
                new TreeNode(1,
                        new TreeNode(1,
                                null,null),
                        new TreeNode(1,
                                null, new TreeNode(1,
                                new TreeNode(2,
                                        new TreeNode(2,
                                                new TreeNode(2),null),
                                        new TreeNode(2,new TreeNode(2),null)),
                                new TreeNode(2,
                                        new TreeNode(2,null,new TreeNode(2)),
                                        new TreeNode(2,null,new TreeNode(2)))))),
                new TreeNode(1,
                        new TreeNode(1, null, null),
                        new TreeNode(1, null,null)))));
        System.out.println(4 == widthOfBinaryTree.widthOfBinaryTree(new TreeNode(1,
                new TreeNode(3, new TreeNode(5),new TreeNode(3)),
                new TreeNode(2,null,new TreeNode(9)))));
        System.out.println(7 == widthOfBinaryTree.widthOfBinaryTree(new TreeNode(1,
                new TreeNode(3,
                        new TreeNode(5,
                                new TreeNode(6), null),null),
                new TreeNode(2,
                        null, new TreeNode(9,new TreeNode(7),null)))));
        System.out.println(2 == widthOfBinaryTree.widthOfBinaryTree(new TreeNode(1,
                new TreeNode(3,new TreeNode(5),null),
                new TreeNode(2))));
    }

    public static TreeNode buildTree() {
        String s = "[-64,12,18,-4,-53,null,76,null,-51,null,null,-93,3,null,-31,47,null,3,53,-81,33,4,null,-51,-44,-60,11,null,null,null,null,78,null,-35,-64,26,-81,-31,27,60,74,null,null,8,-38,47,12,-24,null,-59,-49,-11,-51,67,null,null,null,null,null,null,null,-67,null,-37,-19,10,-55,72,null,null,null,-70,17,-4,null,null,null,null,null,null,null,3,80,44,-88,-91,null,48,-90,-30,null,null,90,-34,37,null,null,73,-38,-31,-85,-31,-96,null,null,-18,67,34,72,null,-17,-77,null,56,-65,-88,-53,null,null,null,-33,86,null,81,-42,null,null,98,-40,70,-26,24,null,null,null,null,92,72,-27,null,null,null,null,null,null,-67,null,null,null,null,null,null,null,-54,-66,-36,null,-72,null,null,43,null,null,null,-92,-1,-98,null,null,null,null,null,null,null,39,-84,null,null,null,null,null,null,null,null,null,null,null,null,null,-93,null,null,null,98]";
        s = s.substring(1,s.length()-1);
        String[] split = s.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        List<TreeNode> nodes = Collections.singletonList(root);
        int length = split.length;
        int putIndex = 0;
        List<TreeNode> list = new ArrayList<>();
        for (int i = 1; i < length; i+=2) {
            TreeNode left;
            if (split[i].equals("null")) {
                left = null;
            } else {
                left = new TreeNode(Integer.parseInt(split[i]));
            }
            TreeNode right;
            if (i+1 >= length || split[i+1].equals("null")) {
                right = null;
            } else {
                right = new TreeNode(Integer.parseInt(split[i+1]));
            }
            nodes.get(putIndex).left = left;
            nodes.get(putIndex).right = right;
            if (left != null) {
                list.add(left);
            }
            if (right != null) {
                list.add(right);
            }
            if (++putIndex >= nodes.size()) {
                nodes = list;
                list = new ArrayList<>();
                putIndex = 0;
            }
        }
        return root;
    }
}
