package algorithm.leetcode.medium.r;

import algorithm.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Rob {

    // 题号 213，打家劫舍II
    public int rob(int[] nums) {
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

    public int rob(TreeNode root) {
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
        System.out.println(3 == rob.rob(new int[]{2,1,1,2}));
        System.out.println(3 == rob.rob(new int[]{1,2,3}));
        System.out.println(4 == rob.rob(new int[]{1,2,3,1}));
        System.out.println(3 == rob.rob(new int[]{2,3,2}));



        System.out.println(rob.rob(new int[]{2,7,9,3,1}));
        System.out.println(rob.rob(new int[]{1,2,3,1}));
    }
}
