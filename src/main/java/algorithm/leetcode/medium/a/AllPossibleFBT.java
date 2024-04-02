package algorithm.leetcode.medium.a;

import algorithm.TreeNode;

import java.util.*;

public class AllPossibleFBT {

    Map<Integer, List<TreeNode>> map = new HashMap<>();

    // 1 <= n <= 20
    public List<TreeNode> allPossibleFBT(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        if (n == 1) {
            return Collections.singletonList(new TreeNode(0));
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        List<TreeNode> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // 左侧 i 个节点
            List<TreeNode> leftList;
            if (map.containsKey(i)) {
                leftList = map.get(i);
            } else {
                leftList = allPossibleFBT(i);
            }
            // 右侧 n - 1 - i 个节点
            int rightCount = n - 1 - i;
            List<TreeNode> rightList;
            if (map.containsKey(rightCount)) {
                rightList = map.get(rightCount);
            } else {
                rightList = allPossibleFBT(rightCount);
            }
            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    ans.add(root);
                }
            }
        }
        map.put(n, ans);
        return ans;
    }

    public static void main(String[] args) {
        AllPossibleFBT allPossibleFBT = new AllPossibleFBT();
        System.out.println(allPossibleFBT.allPossibleFBT(7));
    }
}
