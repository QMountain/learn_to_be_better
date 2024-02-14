package algorithm.leetcode.medium.l;

import algorithm.Node;
import algorithm.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LevelOrder {

    // 题号 429 N叉树的层序遍历
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ansList = new ArrayList<>();
        if (root == null) {
            return ansList;
        }
        List<Node> list = Collections.singletonList(root);
        List<Integer> vList = Collections.singletonList(root.val);
        ansList.add(vList);
        while (!list.isEmpty()) {
            List<Node> nl = new ArrayList<>();
            List<Integer> nvl = new ArrayList<>();
            for (Node node : list) {
                for (Node child : node.children) {
                    nl.add(child);
                    nvl.add(child.val);
                }
            }
            list = nl;
            if (!nvl.isEmpty()) {
                ansList.add(nvl);
            }
        }
        return ansList;
    }

    // 题号 102 二叉树的层序遍历
    // 树中节点数目在范围 [0, 2000] 内
    // -1000 <= Node.val <= 1000
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> ansList = new ArrayList<>();
        List<TreeNode> nodeList = Collections.singletonList(root);
        List<Integer> valList = Collections.singletonList(root.val);
        while (!nodeList.isEmpty()) {
            ansList.add(valList);
            List<TreeNode> nextNodeList = new ArrayList<>();
            List<Integer> nextValList = new ArrayList<>();
            for (TreeNode node : nodeList) {
                if (node.left != null) {
                    nextNodeList.add(node.left);
                    nextValList.add(node.left.val);
                }
                if (node.right != null) {
                    nextNodeList.add(node.right);
                    nextValList.add(node.right.val);
                }
            }
            nodeList = nextNodeList;
            valList = nextValList;
        }
        return ansList;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }
        List<Integer> list = new ArrayList<>(1);
        list.add(root.val);
        resList.add(list);
        List<TreeNode> children = new ArrayList<>();
        if (root.left != null) {
            children.add(root.left);
        }
        if (root.right != null) {
            children.add(root.right);
        }
        while (children.size() > 0) {
            List<Integer> cList = new ArrayList<>(children.size());
            for (TreeNode child : children) {
                cList.add(child.val);
            }
            resList.add(cList);
            children = getNextLevel(children);
        }
        return resList;
    }

    public List<TreeNode> getNextLevel(List<TreeNode> children) {
        List<TreeNode> list = new ArrayList<>();
        if (children == null || children.size() == 0) {
            return list;
        }
        for (TreeNode child : children) {
            if (child.left != null) {
                list.add(child.left);
            }
            if (child.right != null) {
                list.add(child.right);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        LevelOrder levelOrder = new LevelOrder();

        List<Node> node20Children = new ArrayList<>();
        node20Children.add(new Node(15));
        node20Children.add(new Node(7));
        Node node20 = new Node(20,node20Children);
        List<Node> node3Children = new ArrayList<>();
        node3Children.add(new Node(9));
        node3Children.add(node20);
        System.out.println(levelOrder.levelOrder(new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,new TreeNode(15),new TreeNode(7)))));
    }
}
