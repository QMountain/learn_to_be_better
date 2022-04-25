package algorithm.leetcode.easy.p;

import algorithm.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Preorder {

    public List<Integer> preorder(Node root) {
        List<Integer> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }
        resList.add(root.val);
        List<Node> children = root.children;
        if (children != null && children.size() > 0) {
            for (Node child : children) {
                resList.addAll(preorder(child));
            }
        }

        return resList;
    }

    public static void main(String[] args) {
        Preorder preorder = new Preorder();
        /*List<Node> nodes = new ArrayList<>();

        List<Node> nodes2 = new ArrayList<>();
        nodes2.add(new Node(5));
        nodes2.add(new Node(6));
        Node node = new Node(3,nodes2);
        nodes.add(node);
        nodes.add(new Node(2));
        nodes.add(new Node(4));
        System.out.println(preorder.preorder(new Node(1, nodes)));*/

        List<Node> nodes3 = new ArrayList<>();
        nodes3.add(new Node(2));
        List<Node> nodes4 = new ArrayList<>();
        nodes4.add(new Node(6));
        nodes4.add(new Node(7,
                Collections.singletonList(new Node(11,
                        Collections.singletonList(new Node(14))))));
        nodes3.add(new Node(3,nodes4));
        nodes3.add(new Node(4,
                Collections.singletonList(new Node(8,
                        Collections.singletonList(new Node(12))))));
        List<Node> nodes5 = new ArrayList<>();
        nodes5.add(new Node(9,Collections.singletonList(new Node(13))));
        nodes5.add(new Node(10));
        nodes3.add(new Node(5,nodes5));
        System.out.println(preorder.preorder(new Node(1,nodes3)));
    }

}
