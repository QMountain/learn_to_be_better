package algorithm;

import java.util.List;

public class Node {

    public int val;
    public Node next;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

    public Node(int _val, Node next) {
        this.val = _val;
        this.next = next;
    }
}
