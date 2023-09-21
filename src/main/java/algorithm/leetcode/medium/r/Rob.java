package algorithm.leetcode.medium.r;

import algorithm.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Rob {

    // 题号 198 打家劫舍
    // 1 <= nums.length <= 100
    // 0 <= nums[i] <= 400
    public int rob3(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int m1 = nums[0];
        int m2 = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            int m = Math.max(m1 + nums[i], m2);
            m1 = m2;
            m2 = m;
        }
        return Math.max(m1, m2);
    }

    // 题号 213，打家劫舍II
    public int rob4(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < length-1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        int[] dp2 = new int[length];
        dp2[0] = 0;
        dp2[1] = nums[1];
        for (int i = 2; i < length; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i]);
        }
        return Math.max(dp[length-2],dp2[length-1]);
    }

    // 题号 213，打家劫舍II
    // 1 <= nums.length <= 100
    // 0 <= nums[i] <= 1000
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int dp1 = nums[0];
        int dp2 = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length-1; i++) {
            int dp = Math.max(dp1 + nums[i], dp2);
            dp1 = dp2;
            dp2 = dp;
        }
        int dp3 = 0;
        int dp4 = nums[1];
        for (int i = 2; i < length; i++) {
            int dp = Math.max(dp3 + nums[i], dp4);
            dp3 = dp4;
            dp4 = dp;
        }
        return Math.max(dp2, dp4);
    }

    public int rob2(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[length-1];
    }

    public int rob2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        Map<TreeNode,Integer> robbed = new HashMap<>();
        calAndSetMap(root,robbed);
        return robbed.get(root);
    }

    // 题号 337 打家劫舍III  时间：32.68% 空间：63.89%
    // 树的节点数在 [1, 10^4] 范围内
    // 0 <= Node.val <= 10^4
    public int rob(TreeNode root) {
        HashMap<TreeNode, Integer> map = new HashMap<>();
        return rob(root, map);
    }

    public int rob(TreeNode root, HashMap<TreeNode, Integer> map) {
        if (map.containsKey(root)) {
            return map.get(root);
        }
        if (root == null) {
            return 0;
        }
        int res;
        if (root.left == null && root.right == null) {
            res = root.val;
        } else {
            int m1 = rob(root.left, map) + rob(root.right, map);
            if (root.left == null) {
                int m2 = root.val + rob(root.right.left, map) + rob(root.right.right, map);
                res = Math.max(m1, m2);
            } else if (root.right == null) {
                int m2 = root.val + rob(root.left.left, map) + rob(root.left.right, map);
                res = Math.max(m1, m2);
            } else {
                int m2 = root.val + rob(root.left.left, map) + rob(root.left.right, map) +
                        rob(root.right.left, map) + rob(root.right.right, map);
                res = Math.max(m1, m2);
            }
        }

        map.put(root, res);
        return res;
    }

    public void calAndSetMap(TreeNode root,Map<TreeNode,Integer> robbed) {
        if (root.left == null && root.right == null) {
            robbed.put(root,root.val);
            return;
        }
        int m1 = root.val;
        int m2 = 0;
        if (root.left != null) {
            if (root.left.left != null) {
                if (!robbed.containsKey(root.left.left)) {
                    calAndSetMap(root.left.left, robbed);
                }
                m1 += robbed.get(root.left.left);
            }
            if (root.left.right != null) {
                if (!robbed.containsKey(root.left.right)) {
                    calAndSetMap(root.left.right, robbed);
                }
                m1 += robbed.get(root.left.right);
            }
            if (!robbed.containsKey(root.left)) {
                calAndSetMap(root.left,robbed);
            }
            m2 += robbed.get(root.left);
        }
        if (root.right != null) {
            if (root.right.left != null) {
                if (!robbed.containsKey(root.right.left)) {
                    calAndSetMap(root.right.left, robbed);
                }
                m1 += robbed.get(root.right.left);
            }
            if (root.right.right != null) {
                if (!robbed.containsKey(root.right.right)) {
                    calAndSetMap(root.right.right, robbed);
                }
                m1 += robbed.get(root.right.right);
            }
            if (!robbed.containsKey(root.right)) {
                calAndSetMap(root.right,robbed);
            }
            m2 += robbed.get(root.right);
        }
        robbed.put(root,Math.max(m1,m2));
    }

    public static void main(String[] args) {
        Rob rob = new Rob();
        /* 打家劫舍III case start */
        System.out.println(9 == rob.rob(new TreeNode(3,
                new TreeNode(4, new TreeNode(1), new TreeNode(3)),
                new TreeNode(5, null, new TreeNode(1)))));
        System.out.println(7 == rob.rob(new TreeNode(3,
                new TreeNode(2, null, new TreeNode(3)),
                new TreeNode(3, null, new TreeNode(1)))));
        /* 打家劫舍III case end */

        /* 打家劫舍II case start */
        System.out.println(3 == rob.rob(new int[]{2,3,2}));
        System.out.println(4 == rob.rob(new int[]{1,2,3,1}));
        System.out.println(3 == rob.rob(new int[]{1,2,3}));
        /* 打家劫舍II case end */

        System.out.println(3 == rob.rob(new int[]{2,1,1,2}));
        System.out.println(3 == rob.rob(new int[]{1,2,3}));
        System.out.println(4 == rob.rob(new int[]{1,2,3,1}));
        System.out.println(3 == rob.rob(new int[]{2,3,2}));



        System.out.println(rob.rob(new int[]{2,7,9,3,1}));
        System.out.println(rob.rob(new int[]{1,2,3,1}));
    }
}
