package algorithm.leetcode.easy.i;

import algorithm.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class IsCousins {

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root.val == x || root.val == y) {
            return false;
        }
        int kx = 0;
        int ky = 0;
        TreeNode px = null;
        TreeNode py = null;
        List<TreeNode> nodes = Collections.singletonList(root);
        int k = 1;
        while (!nodes.isEmpty()) {
            List<TreeNode> nn = new ArrayList<>();
            for (TreeNode node : nodes) {
                if (node.left != null) {
                    nn.add(node.left);
                    if (node.left.val == x) {
                        kx = k;
                        px = node;
                    }
                    if (node.left.val == y) {
                        ky = k;
                        py = node;
                    }
                }
                if (node.right != null) {
                    nn.add(node.right);
                    if (node.right.val == x) {
                        kx = k;
                        px = node;
                    }
                    if (node.right.val == y) {
                        ky = k;
                        py = node;
                    }
                }
            }
            if (px != null && py != null) {
                break;
            }
            k++;
            nodes = nn;
        }
        return kx == ky && !Objects.equals(px, py);
    }

    public static void main(String[] args) {
        IsCousins isCousins = new IsCousins();
        System.out.println(isCousins.isCousins(new TreeNode(1, new TreeNode(2,null,new TreeNode(4)), new TreeNode(3)), 4, 3));
    }
}
