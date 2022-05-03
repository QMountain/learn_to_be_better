package algorithm.leetcode.medium.g;

import algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class GetAllElements {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = getValue(root1);
        List<Integer> list2 = getValue(root2);
        int size1 = list1.size();
        int size2 = list2.size();
        if (size1 == 0) {
            return list2;
        }
        if (size2 == 0) {
            return list1;
        }
        List<Integer> list = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;
        while (true) {
            Integer e1 = list1.get(index1);
            Integer e2 = list2.get(index2);
            if (e1 > e2) {
                list.add(e2);
                if (index2 < size2-1) {
                    index2++;
                } else {
                    for (int i = index1; i < size1; i++) {
                        list.add(list1.get(i));
                    }
                    return list;
                }
            } else {
                list.add(e1);
                if (index1 < size1-1) {
                    index1++;
                } else {
                    for (int i = index2; i < size2; i++) {
                        list.add(list2.get(i));
                    }
                    return list;
                }
            }
        }
    }

    public List<Integer> getValue(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        if (node == null) {
            return list;
        }
        list.addAll(getValue(node.left));
        list.add(node.val);
        list.addAll(getValue(node.right));
        return list;
    }

    public static void main(String[] args) {
        GetAllElements getAllElements = new GetAllElements();
        System.out.println(getAllElements.getAllElements(new TreeNode(2, new TreeNode(1), new TreeNode(4)),
                new TreeNode(1, new TreeNode(0), new TreeNode(3))));
    }
}
