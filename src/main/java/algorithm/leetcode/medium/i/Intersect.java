package algorithm.leetcode.medium.i;

public class Intersect {

    public Node intersect(Node quadTree1, Node quadTree2) {
        if (quadTree1.isLeaf && quadTree2.isLeaf) {
            quadTree1.val = quadTree1.val | quadTree2.val;
            return quadTree1;
        }
        if (quadTree1.isLeaf) {
            quadTree2.topLeft = intersect(quadTree1,quadTree2.topLeft);
            quadTree2.topRight = intersect(quadTree1,quadTree2.topRight);
            quadTree2.bottomLeft = intersect(quadTree1,quadTree2.bottomLeft);
            quadTree2.bottomRight = intersect(quadTree1,quadTree2.bottomRight);
            if (quadTree2.topLeft.isLeaf &&
            quadTree2.topRight.isLeaf &&
            quadTree2.bottomLeft.isLeaf &&
            quadTree2.bottomRight.isLeaf) {

            }
            return quadTree2;
        }
        if (quadTree2.isLeaf) {
            quadTree1.topLeft = intersect(quadTree2,quadTree1.topLeft);
            quadTree1.topRight = intersect(quadTree2,quadTree1.topRight);
            quadTree1.bottomLeft = intersect(quadTree2,quadTree1.bottomLeft);
            quadTree1.bottomRight = intersect(quadTree2,quadTree1.bottomRight);
            return quadTree1;
        }
        quadTree1.val = quadTree1.val | quadTree2.val;
        quadTree1.topLeft = intersect(quadTree1.topLeft,quadTree2.topLeft);
        quadTree1.topRight = intersect(quadTree1.topRight,quadTree2.topRight);
        quadTree1.bottomLeft = intersect(quadTree1.bottomLeft,quadTree2.bottomLeft);
        quadTree1.bottomRight = intersect(quadTree1.bottomRight,quadTree2.bottomRight);
        return quadTree1;
    }

    public static void main(String[] args) {

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
