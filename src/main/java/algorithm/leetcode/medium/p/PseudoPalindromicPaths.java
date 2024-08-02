package algorithm.leetcode.medium.p;

import algorithm.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class PseudoPalindromicPaths {

    public int pseudoPalindromicPaths (TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        Map<TreeNode, Boolean> map = new HashMap<>();
        int[] count = new int[9];
        count[root.val-1]++;
        int ans = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.left == null && node.right == null) {
                int countOdd = 0;
                for (int i = 0; i < 9; i++) {
                    if (count[i] % 2 == 1) {
                        countOdd++;
                    }
                }
                if (countOdd <= 1) {
                    ans++;
                }
                map.put(node, true);
                stack.pop();
                count[node.val - 1]--;
                continue;
            }
            boolean leftChildDone = node.left == null || Boolean.TRUE.equals(map.get(node.left));
            boolean rightChildDone = node.right == null || Boolean.TRUE.equals(map.get(node.right));
            if (leftChildDone && rightChildDone) {
                map.put(node, true);
                stack.pop();
                count[node.val - 1]--;
            } else if (leftChildDone) {
                stack.push(node.right);
                count[node.right.val - 1]++;
            } else {
                stack.push(node.left);
                count[node.left.val - 1]++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        PseudoPalindromicPaths pseudoPalindromicPaths = new PseudoPalindromicPaths();
        System.out.println(2 == pseudoPalindromicPaths.pseudoPalindromicPaths(
                new TreeNode(2,
                        new TreeNode(3,
                                new TreeNode(3),
                                new TreeNode(1)),
                        new TreeNode(1,
                                null,
                                new TreeNode(1)))));
    }
}
