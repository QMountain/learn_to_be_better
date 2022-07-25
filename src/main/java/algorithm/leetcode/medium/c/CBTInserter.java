package algorithm.leetcode.medium.c;

import algorithm.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CBTInserter {

    TreeNode root;
    List<TreeNode> parent;
    List<TreeNode> leaves;
    int leafMax = 2;

    public CBTInserter(TreeNode root) {
        this.root = root;
        List<TreeNode> nodes = Collections.singletonList(root);
        while (true) {
            List<TreeNode> next = new ArrayList<>();
            for (TreeNode node : nodes) {
                if (node.left != null) {
                    next.add(node.left);
                }
                if (node.right != null) {
                    next.add(node.right);
                }
            }
            if (next.size() < leafMax) {
                this.parent = nodes;
                this.leaves = next;
                break;
            }
            leafMax *= 2;
            nodes = next;
        }
    }

    public int insert(int val) {
        int ls = leaves.size();
        int index = ls / 2;
        int ps = parent.size();
        if (ls <= leafMax-2) {
            TreeNode np = parent.get(index);
            TreeNode node = new TreeNode(val);
            if (ls % 2 == 0) {
                np.left = node;
                leaves.add(node);
                return np.val;
            }
            np.right = node;
            leaves.add(node);
            return np.val;
        }
        if (ls % 2 == 0) {
            parent = leaves;
            List<TreeNode> nodes = new ArrayList<>();
            TreeNode node = new TreeNode(val);
            nodes.add(node);
            TreeNode first = parent.get(0);
            first.left = node;
            leaves = nodes;
            leafMax *= 2;
            return first.val;
        }
        TreeNode last = parent.get(ps - 1);
        TreeNode node = new TreeNode(val);
        last.right = node;
        leaves.add(node);
        parent = leaves;
        leaves = new ArrayList<>();
        leafMax *= 2;
        return last.val;

    }

    public TreeNode get_root() {
        return this.root;
    }

    public static void main(String[] args) {
        CBTInserter cbtInserter = new CBTInserter(new TreeNode(1, null, null));
        System.out.println(cbtInserter.insert(2));
        System.out.println(cbtInserter.insert(3));
        System.out.println(cbtInserter.insert(4));
        System.out.println(cbtInserter.insert(5));
        System.out.println(cbtInserter.insert(6));
        TreeNode root = cbtInserter.get_root();
        System.out.println(root);
    }
}
