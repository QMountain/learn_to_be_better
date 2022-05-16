package algorithm.leetcode.medium.l;

import algorithm.Node;
import algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
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
