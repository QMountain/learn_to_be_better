package algorithm.leetcode.medium.i;

public class Intersect {

    public Node intersect(Node quadTree1, Node quadTree2) {
        if (quadTree1.isLeaf && quadTree2.isLeaf) {
            Node node = new Node();
            node.val = quadTree1.val | quadTree2.val;
            node.isLeaf = true;
            return node;
        }
        if (quadTree1.isLeaf) {
            Node node = new Node();
            node.topLeft = intersect(quadTree1,quadTree2.topLeft);
            node.topRight = intersect(quadTree1,quadTree2.topRight);
            node.bottomLeft = intersect(quadTree1,quadTree2.bottomLeft);
            node.bottomRight = intersect(quadTree1,quadTree2.bottomRight);
            if (node.topLeft.isLeaf &&
                    node.topRight.isLeaf &&
                    node.bottomLeft.isLeaf &&
                    node.bottomRight.isLeaf &&
                    node.topLeft.val == node.topRight.val &&
                    node.topRight.val == node.bottomLeft.val &&
                    node.bottomLeft.val == node.bottomRight.val) {
                node.isLeaf = true;
                node.val = node.topLeft.val;
                node.topLeft = null;
                node.topRight = null;
                node.bottomLeft = null;
                node.bottomRight = null;
                return node;
            }
            return quadTree2;
        }
        if (quadTree2.isLeaf) {
            Node node = new Node();
            node.topLeft = intersect(quadTree2,quadTree1.topLeft);
            node.topRight = intersect(quadTree2,quadTree1.topRight);
            node.bottomLeft = intersect(quadTree2,quadTree1.bottomLeft);
            node.bottomRight = intersect(quadTree2,quadTree1.bottomRight);
            if (node.topLeft.isLeaf &&
                    node.topRight.isLeaf &&
                    node.bottomLeft.isLeaf &&
                    node.bottomRight.isLeaf &&
                    node.topLeft.val == node.topRight.val &&
                    node.topRight.val == node.bottomLeft.val &&
                    node.bottomLeft.val == node.bottomRight.val) {
                node.isLeaf = true;
                node.val = node.topLeft.val;
                node.topLeft = null;
                node.topRight = null;
                node.bottomLeft = null;
                node.bottomRight = null;
                return node;
            }
            return quadTree1;
        }
        Node node = new Node();
        node.topLeft = intersect(quadTree1.topLeft,quadTree2.topLeft);
        node.topRight = intersect(quadTree1.topRight,quadTree2.topRight);
        node.bottomLeft = intersect(quadTree1.bottomLeft,quadTree2.bottomLeft);
        node.bottomRight = intersect(quadTree1.bottomRight,quadTree2.bottomRight);
        if (node.topLeft.isLeaf && node.topRight.isLeaf
                && node.bottomLeft.isLeaf && node.bottomRight.isLeaf &&
        node.topLeft.val == node.topRight.val &&
        node.topRight.val == node.bottomLeft.val &&
        node.bottomLeft.val == node.bottomRight.val) {
            node.isLeaf = true;
            node.val = node.topLeft.val;
            node.topLeft = null;
            node.topRight = null;
            node.bottomLeft = null;
            node.bottomRight = null;
            return node;
        }
        return node;
    }

    public static void main(String[] args) {
        Intersect intersect = new Intersect();
        Node node = intersect.intersect(
                new Node(false, false,
                        new Node(true, true, null, null, null, null),
                        new Node(true, true, null, null, null, null),
                        new Node(false, true, null, null, null, null),
                        new Node(false, true, null, null, null, null)),
                new Node(false, false,
                        new Node(true, true, null, null, null, null),
                        new Node(true, false,
                                new Node(false, true, null, null, null, null),
                                new Node(false, true, null, null, null, null),
                                new Node(true, true, null, null, null, null),
                                new Node(true, true, null, null, null, null)),
                        new Node(true, true, null, null, null, null),
                        new Node(false, true, null, null, null, null)));
        System.out.println(node);
    }
}

class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
}
