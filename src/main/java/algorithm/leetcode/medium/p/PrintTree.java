package algorithm.leetcode.medium.p;

import algorithm.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PrintTree {

    int[][] res;
    int height;

    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> ansList = new ArrayList<>();
        height = getHeight(root)-1;
        int rows = (1 << height+1) -1;
        res = new int[height+1][rows];
        for (int[] re : res) {
            Arrays.fill(re,1000);
        }
        putVal(root,0,(rows-1)/2);
        for (int[] re : res) {
            List<String> list = new ArrayList<>();
            for (int i : re) {
                if (i == 1000) {
                    list.add("");
                } else {
                    list.add(String.valueOf(i));
                }
            }
            ansList.add(list);
        }
        return ansList;
    }

    public void putVal(TreeNode node, int r, int c) {
        res[r][c] = node.val;
        if (node.left != null) {
            putVal(node.left, r+1, c-(1<<height-r-1));
        }
        if (node.right != null) {
            putVal(node.right, r+1, c+ (1<<height-r-1));
        }
    }

    public int getHeight(TreeNode root) {
        List<TreeNode> nodes = Collections.singletonList(root);
        int height = 0;
        while (nodes.size() > 0) {
            height++;
            List<TreeNode> list = new ArrayList<>();
            for (TreeNode node : nodes) {
                if (node.left != null) {
                    list.add(node.left);
                }
                if (node.right != null) {
                    list.add(node.right);
                }
            }
            nodes = list;
        }
        return height;
    }

    public static void main(String[] args) {
        PrintTree printTree = new PrintTree();
        List<List<String>> lists1 = printTree.printTree(new TreeNode(1,
                new TreeNode(2,null,new TreeNode(4)),
                new TreeNode(3)));
        for (List<String> list : lists1) {
            System.out.println(list);
        }
        List<List<String>> lists = printTree.printTree(new TreeNode(1, new TreeNode(2), null));
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }
}
