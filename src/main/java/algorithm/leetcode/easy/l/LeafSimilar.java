package algorithm.leetcode.easy.l;

import algorithm.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LeafSimilar {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = getList(root1);
        List<Integer> list2 = getList(root2);
        int size1 = list1.size();
        int size2 = list2.size();
        if (size1 != size2) {
            return false;
        }
        for (int i = 0; i < size1; i++) {
            Integer e1 = list1.get(i);
            Integer e2 = list2.get(i);
            if (!Objects.equals(e1,e2)) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> getList(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        if (node != null) {
            if (node.left == null && node.right == null) {
                list.add(node.val);
            } else {
                if (node.left != null) {
                    if (node.left.left != null || node.left.right != null) {
                        list.addAll(getList(node.left));
                    } else {
                        list.add(node.left.val);
                    }
                }
                if (node.right != null) {
                    if (node.right.left != null || node.right.right != null) {
                        list.addAll(getList(node.right));
                    } else {
                        list.add(node.right.val);
                    }
                }
            }

        }
        return list;
    }

    public static void main(String[] args) {
        LeafSimilar leafSimilar = new LeafSimilar();
        System.out.println(leafSimilar.leafSimilar(new TreeNode(1), new TreeNode(2)));
        System.out.println(leafSimilar.leafSimilar(
                new TreeNode(3,
                        new TreeNode(5,new TreeNode(6),new TreeNode(2,
                                new TreeNode(7),new TreeNode(4))),
                        new TreeNode(1,new TreeNode(9),new TreeNode(8))),
                new TreeNode(3,
                        new TreeNode(5,new TreeNode(6),new TreeNode(7)),
                        new TreeNode(1,new TreeNode(4),new TreeNode(2,
                                new TreeNode(9),new TreeNode(8))))));
    }
}
