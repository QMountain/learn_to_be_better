package algorithm.leetcode.easy.p;

import algorithm.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Postorder {

    public List<Integer> postorder(Node root) {
        List<Integer> resList = new LinkedList<>();
        if (root == null) {
            return resList;
        }
        List<Node> children = root.children;
        if (children == null || children.isEmpty()) {
            resList.add(root.val);
            return resList;
        }
        for (Node child : children) {
            resList.addAll(postorder(child));
        }
        resList.add(root.val);
        return resList;
    }

    public static void main(String[] args) {
        Postorder postorder = new Postorder();
        List<Node> n3c = new ArrayList<>();
        n3c.add(new Node(5));
        n3c.add(new Node(6));
        List<Node> n1c = new ArrayList<>();
        n1c.add(new Node(3,n3c));
        n1c.add(new Node(2));
        n1c.add(new Node(4));
        System.out.println(postorder.postorder(new Node(1,n1c)));
    }
}
