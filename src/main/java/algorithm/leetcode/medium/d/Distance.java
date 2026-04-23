package algorithm.leetcode.medium.d;

public class Distance {

    /**
     * 2615. 等值距离和
     * 给你一个下标从 0 开始的整数数组 nums 。
     * 现有一个长度等于 nums.length 的数组 arr 。
     * 对于满足 nums[j] == nums[i] 且 j != i 的所有 j ，
     * arr[i] 等于所有 |i - j| 之和。如果不存在这样的 j ，
     * 则令 arr[i] 等于 0 。
     * 返回数组 arr 。
     */
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] result = new long[n];
        
        // 按值对索引进行分组
        java.util.Map<Integer, java.util.List<Integer>> valueToIndices = new java.util.HashMap<>();
        for (int i = 0; i < n; i++) {
            valueToIndices.computeIfAbsent(nums[i], k -> new java.util.ArrayList<>()).add(i);
        }
        
        // 对于每个值，计算其索引的前缀和
        for (java.util.List<Integer> indices : valueToIndices.values()) {
            int m = indices.size();
            if (m <= 1) {
                // 只有一个元素，距离和为0
                continue;
            }
            
            // 计算前缀和
            long[] prefixSum = new long[m + 1];
            for (int i = 0; i < m; i++) {
                prefixSum[i + 1] = prefixSum[i] + indices.get(i);
            }
            
            // 对于每个索引，计算距离和
            for (int i = 0; i < m; i++) {
                int idx = indices.get(i);
                // 左边有i个元素，右边有m-1-i个元素
                // 左边距离和：i * idx - prefixSum[i]
                // 右边距离和：(prefixSum[m] - prefixSum[i+1]) - (m-1-i) * idx
                long leftSum = (long) i * idx - prefixSum[i];
                long rightSum = (prefixSum[m] - prefixSum[i + 1]) - (long) (m - 1 - i) * idx;
                result[idx] = leftSum + rightSum;
            }
        }
        
        return result;
    }

}
