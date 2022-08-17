package algorithm.leetcode.medium.b;

import algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BSTIterator {

    List<Integer> list;
    int currPointer;

    public BSTIterator(TreeNode root) {
        currPointer = -1;
        list = new ArrayList<>();
        addToList(root);
    }

    public void addToList(TreeNode node) {
        if (node.left != null) {
            addToList(node.left);
        }
        list.add(node.val);
        if (node.right != null) {
            addToList(node.right);
        }
    }

    public int next() {
        return list.get(++currPointer);
    }

    public boolean hasNext() {
        return currPointer+1 < list.size();
    }

}
