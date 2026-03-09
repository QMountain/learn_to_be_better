package algorithm.leetcode.medium.n;

public class NumberOfStableArrays {

    /**
     * 3129. 找出所有稳定的二进制数组 I
     * 给你 3 个正整数 zero ，one 和 limit 。
     * 一个 二进制数组 arr 如果满足以下条件，那么我们称它是 稳定的 ：
     * 0 在 arr 中出现次数 恰好 为 zero 。
     * 1 在 arr 中出现次数 恰好 为 one 。
     * arr 中每个长度超过 limit 的 子数组 都 同时 包含 0 和 1 。
     * 请你返回 稳定 二进制数组的 总 数目。
     * 由于答案可能很大，将它对 10^9 + 7 取余 后返回。
     * 1 <= zero, one, limit <= 200
     */
    public int numberOfStableArrays(int zero, int one, int limit) {
        final int MOD = 1000000007;

        // dp[i][j][0]: 使用 i 个 0 和 j 个 1，且以 0 结尾的稳定数组个数
        // dp[i][j][1]: 使用 i 个 0 和 j 个 1，且以 1 结尾的稳定数组个数
        // 时间复杂度: O(zero * one)
        // 空间复杂度: O(zero * one)
        long[][][] dp = new long[zero + 1][one + 1][2];

        // 初始化：
        // 当没有 1 时，只要 0 的数量不超过 limit，就是一种合法情况（全 0）
        for (int i = 1; i <= Math.min(zero, limit); i++) {
            dp[i][0][0] = 1;
        }
        // 当没有 0 时，只要 1 的数量不超过 limit，就是一种合法情况（全 1）
        for (int j = 1; j <= Math.min(one, limit); j++) {
            dp[0][j][1] = 1;
        }

        // 状态转移
        for (int i = 1; i <= zero; i++) {
            for (int j = 1; j <= one; j++) {
                // 计算 dp[i][j][0] (以 0 结尾)
                // 1. 尝试在 dp[i-1][j][0] 后加 0
                // 2. 尝试在 dp[i-1][j][1] 后加 0
                // 初步总和：dp[i][j][0] = dp[i - 1][j][0] + dp[i - 1][j][1]
                dp[i][j][0] = (dp[i - 1][j][0] + dp[i - 1][j][1]) % MOD;
                
                // 减去非法情况：
                // 如果最后连续 0 的长度超过了 limit (即达到了 limit + 1)
                // 这种情况对应于：...1 0...0 (共 limit+1 个 0)
                // 那么这 limit+1 个 0 之前必须是 1
                // 所以我们需要减去 dp[i - limit - 1][j][1]
                if (i > limit) {
                    dp[i][j][0] = (dp[i][j][0] - dp[i - limit - 1][j][1] + MOD) % MOD;
                }

                // 计算 dp[i][j][1] (以 1 结尾)
                // 同理
                dp[i][j][1] = (dp[i][j - 1][0] + dp[i][j - 1][1]) % MOD;
                if (j > limit) {
                    dp[i][j][1] = (dp[i][j][1] - dp[i][j - limit - 1][0] + MOD) % MOD;
                }
            }
        }

        return (int) ((dp[zero][one][0] + dp[zero][one][1]) % MOD);
    }

    public static void main(String[] args) {
        NumberOfStableArrays numberOfStableArrays = new NumberOfStableArrays();
        
        // 测试用例1：zero=1, one=1, limit=2
        // 可能的数组：[0,1] 和 [1,0]，都是稳定的
        System.out.println("测试1: " + (2 == numberOfStableArrays.numberOfStableArrays(1, 1, 2)));
        
        // 测试用例2：zero=1, one=2, limit=1
        // 可能的数组：[1,0,1] 和 [1,1,0]，但[1,1,0]中长度为2的子数组[1,1]只包含1，不满足条件
        // 所以只有[1,0,1]是稳定的
        System.out.println("测试2: " + (1 == numberOfStableArrays.numberOfStableArrays(1, 2, 1)));
        
        // 测试用例3：zero=3, one=3, limit=2
        // 需要确保没有长度超过2的连续相同数字
        System.out.println("测试3: " + numberOfStableArrays.numberOfStableArrays(3, 3, 2));
        
        // 测试用例4：边界情况
        System.out.println("测试4: " + numberOfStableArrays.numberOfStableArrays(0, 1, 1));
        System.out.println("测试5: " + numberOfStableArrays.numberOfStableArrays(1, 0, 1));
        
        // 测试用例6：更复杂的测试
        System.out.println("测试6: " + numberOfStableArrays.numberOfStableArrays(2, 3, 1));
        
        // 测试用例7：大数值测试
        System.out.println("测试7: " + numberOfStableArrays.numberOfStableArrays(5, 5, 3));
    }
}
