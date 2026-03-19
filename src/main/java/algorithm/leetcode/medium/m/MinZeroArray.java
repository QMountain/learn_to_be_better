package algorithm.leetcode.medium.m;

public class MinZeroArray {

    /**
     * 3356. 零数组变换 II
     * 给你一个长度为 n 的整数数组 nums 和一个二维数组 queries，其中 queries[i] = [li, ri, vali]。
     * 每个 queries[i] 表示在 nums 上执行以下操作：
     *      将 nums 中 [li, ri] 范围内的每个下标对应元素的值 最多 减少 vali。
     *      每个下标的减少的数值可以独立选择。
     * 零数组 是指所有元素都等于 0 的数组。
     * 返回 k 可以取到的 最小非负 值，使得在 顺序 处理前 k 个查询后，nums 变成 零数组。
     * 如果不存在这样的 k，则返回 -1。
     * 1 <= nums.length <= 10^5
     * 0 <= nums[i] <= 5 * 10^5
     * 1 <= queries.length <= 10^5
     * queries[i].length == 3
     * 0 <= li <= ri < nums.length
     * 1 <= vali <= 5
     */
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;

        // 使用二分查找寻找最小的k
        int left = 0, right = m;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // 检查处理前mid个查询是否能使数组全为0
            if (canMakeZero(nums, queries, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    private boolean canMakeZero(int[] nums, int[][] queries, int k) {
        int n = nums.length;
        int[] diff = new int[n + 1]; // 差分数组

        // 处理前k个查询
        for (int i = 0; i < k; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int val = queries[i][2];
            diff[l] += val;
            diff[r + 1] -= val;
        }

        // 计算前缀和，得到每个位置的减少量
        int[] reduced = new int[n];
        reduced[0] = diff[0];
        for (int i = 1; i < n; i++) {
            reduced[i] = reduced[i - 1] + diff[i];
        }

        // 检查每个位置是否能被减到0
        for (int i = 0; i < n; i++) {
            if (reduced[i] < nums[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        MinZeroArray minZeroArray = new MinZeroArray();
        System.out.println(2 == minZeroArray.minZeroArray(
                new int[]{2,0,2},
                new int[][]{{0,2,1},{0,2,1},{1,1,3}}));
    }
}
