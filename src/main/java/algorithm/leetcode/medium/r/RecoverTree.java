package algorithm.leetcode.medium.r;

import algorithm.TreeNode;

import java.util.*;

public class RecoverTree {

    public void recoverTree(TreeNode root) {
        List<Integer> values = getValue(root);
        int size = values.size();
        int[] arr1 = new int[size];
        int[] arr2 = new int[size];
        for (int i = 0; i < size; i++) {
            arr1[i] = values.get(i);
            arr2[i] = values.get(i);
        }
        Arrays.sort(arr2);
        int v1 = 0;
        int v2 = 0;
        for (int i = 0; i < size; i++) {
            if (arr1[i] != arr2[i]) {
                v1 = arr1[i];
                for (int j = i+1; j < size; j++) {
                    if (arr1[j] != arr2[j]) {
                        v2 = arr1[j];
                        break;
                    }
                }
                break;
            }
        }
        exchange(root,v1,v2);
    }

    public List<Integer> getValue(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        if (root.left != null) {
            values.addAll(getValue(root.left));
        }
        values.add(root.val);
        if (root.right != null) {
            values.addAll(getValue(root.right));
        }
        return values;
    }

    public void exchange(TreeNode root, int v1, int v2) {
        List<TreeNode> list = Collections.singletonList(root);
        boolean v1Changed = false;
        boolean v2Changed = false;
        while (!v1Changed || !v2Changed) {
            List<TreeNode> nl = new ArrayList<>();
            for (TreeNode node : list) {
                if (node.val == v1 && !v2Changed) {
                    node.val = v2;
                    v2Changed = true;
                } else if (node.val == v2 && !v1Changed) {
                    node.val = v1;
                    v1Changed = true;
                }
                if (node.left != null) {
                    nl.add(node.left);
                }
                if (node.right != null) {
                    nl.add(node.right);
                }
            }
            list = nl;
        }
    }

    public static void main(String[] args) {
        RecoverTree recoverTree = new RecoverTree();
        recoverTree.recoverTree(new TreeNode(5,new TreeNode(3,
                new TreeNode(-2147483648),new TreeNode(2)),new TreeNode(9)));
        recoverTree.recoverTree(new TreeNode(2,null,new TreeNode(1)));
        recoverTree.recoverTree(new TreeNode(3,
                new TreeNode(1,null,null),
                new TreeNode(4,new TreeNode(2),null)));
        recoverTree.recoverTree(new TreeNode(1,new TreeNode(3,null,new TreeNode(2)),null));
    }
}
