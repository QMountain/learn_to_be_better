package algorithm.leetcode.medium.l;

import algorithm.Node;

import java.util.ArrayList;
import java.util.List;

public class LevelOrder {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }
        List<Integer> list = new ArrayList<>(1);
        list.add(root.val);
        resList.add(list);
        List<Node> children = root.children;
        return null;
    }

    public List<Integer> addNextLevel(List<Node> children) {
        if (children == null || children.size() == 0) {

        }
        return null;
    }
}
