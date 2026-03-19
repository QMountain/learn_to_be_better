package algorithm.leetcode.hard.m;

public class MaximumValueSum {

    /**
     * 3068. 最大节点价值之和
     * 给你一棵 n 个节点的 无向 树，节点从 0 到 n - 1 编号。
     * 树以长度为 n - 1 下标从 0 开始的二维整数数组 edges 的形式给你，
     * 其中 edges[i] = [ui, vi] 表示树中节点 ui 和 vi 之间有一条边。
     * 同时给你一个 正 整数 k 和一个长度为 n 下标从 0 开始的 非负 整数数组 nums ，
     * 其中 nums[i] 表示节点 i 的 价值 。
     * Alice 想 最大化 树中所有节点价值之和。为了实现这一目标，Alice 可以执行以下操作 任意 次（包括 0 次）：
     * 选择连接节点 u 和 v 的边 [u, v] ，并将它们的值更新为：
     *      nums[u] = nums[u] XOR k
     *      nums[v] = nums[v] XOR k
     * 请你返回 Alice 通过执行以上操作 任意次 后，可以得到所有节点 价值之和 的 最大值 。
     * 2 <= n == nums.length <= 2 * 10^4
     * 1 <= k <= 10^9
     * 0 <= nums[i] <= 10^9
     * edges.length == n - 1
     * edges[i].length == 2
     * 0 <= edges[i][0], edges[i][1] <= n - 1
     * 输入保证 edges 构成一棵合法的树。
     */
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long sum = 0;
        int count = 0;
        int minDiff = Integer.MAX_VALUE;

        // 计算每个节点异或k后的差值
        for (int num : nums) {
            int xorValue = num ^ k;
            int diff = xorValue - num;

            // 累加原始值
            sum += num;

            // 如果异或后值更大，考虑异或
            if (diff > 0) {
                sum += diff;
                count++;
                minDiff = Math.min(minDiff, diff);
            } else {
                minDiff = Math.min(minDiff, -diff);
            }
        }

        // 如果异或的节点数是奇数，需要调整
        if (count % 2 == 1) {
            sum -= minDiff;
        }

        return sum;
    }

    public static void main(String[] args) {
        MaximumValueSum maximumValueSum = new MaximumValueSum();
        System.out.println(6 == maximumValueSum.maximumValueSum(
                new int[]{1, 2, 1}, 3, new int[][]{{0, 1}, {0, 2}}));
    }
}
