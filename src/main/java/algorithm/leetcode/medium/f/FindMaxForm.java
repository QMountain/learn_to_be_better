package algorithm.leetcode.medium.f;

import java.util.*;

public class FindMaxForm {

    static class Element {
        String str;
        Integer countZero;
        Integer countOne;
        public Element(String str) {
            this.str = str;
            int countZero = 0;
            int countOne = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0'){
                    countZero++;
                } else {
                    countOne++;
                }
            }
            this.countZero = countZero;
            this.countOne = countOne;
        }

        public int compare(Element another) {
            if (Objects.equals(this.countZero, another.countZero)) {
                return this.countOne.compareTo(another.countOne);
            }
            if (this.countZero.compareTo(another.countZero) > 0) {
                if (this.countOne.compareTo(another.countOne) >= 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
            if (this.countOne.compareTo(another.countOne) <= 0) {
                return -1;
            }
            return 0;
        }
    }

    /**
     * 474. 一和零
     * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
     * 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
     * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
     * 1 <= strs.length <= 600
     * 1 <= strs[i].length <= 100
     * strs[i] 仅由 '0' 和 '1' 组成
     * 1 <= m, n <= 100
     */
    public int findMaxForm(String[] strs, int m, int n) {
        // 使用动态规划解决背包问题
        // dp[i][j]表示使用i个0和j个1能组成的最大子集大小
        int[][] dp = new int[m + 1][n + 1];

        // 遍历每个字符串
        for (String str : strs) {
            // 计算当前字符串中的0和1的数量
            int zeros = 0, ones = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }

            // 更新dp数组，从后往前遍历避免重复计算
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }

        return dp[m][n];
    }

    /**
     * 进一步优化：使用排序和剪枝策略
     * 对字符串按长度排序，优先处理短字符串，可以提前终止
     */
    public int findMaxFormWithPruning(String[] strs, int m, int n) {
        // 按字符串长度排序，优先处理较短的字符串
        Arrays.sort(strs, Comparator.comparingInt(String::length));

        int[][] dp = new int[m + 1][n + 1];

        // 记录当前最大结果，用于剪枝
        int maxResult = 0;

        // 遍历每个字符串
        for (String str : strs) {
            // 计算当前字符串中的0和1的数量
            int zeros = 0, ones = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }

            // 如果当前字符串的0和1数量超过限制，跳过
            if (zeros > m || ones > n) {
                continue;
            }

            // 更新dp数组，从后往前遍历避免重复计算
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                    maxResult = Math.max(maxResult, dp[i][j]);
                }
            }

            // 剪枝：如果已经处理了足够多的字符串，可以提前终止
            if (maxResult == strs.length) {
                break;
            }
        }

        return dp[m][n];
    }

    /**
     * 使用缓存优化：避免重复计算0和1的数量
     */
    public int findMaxFormWithCache(String[] strs, int m, int n) {
        // 预计算每个字符串的0和1数量
        int[][] counts = new int[strs.length][2];
        for (int i = 0; i < strs.length; i++) {
            int zeros = 0, ones = 0;
            for (char c : strs[i].toCharArray()) {
                if (c == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }
            counts[i][0] = zeros;
            counts[i][1] = ones;
        }

        int[][] dp = new int[m + 1][n + 1];

        // 遍历每个字符串
        for (int k = 0; k < strs.length; k++) {
            int zeros = counts[k][0];
            int ones = counts[k][1];

            // 如果当前字符串的0和1数量超过限制，跳过
            if (zeros > m || ones > n) {
                continue;
            }

            // 更新dp数组，从后往前遍历避免重复计算
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        FindMaxForm findMaxForm = new FindMaxForm();
        System.out.println(3 == findMaxForm.findMaxForm(
                new String[]{"00011","00001","00001","0011","111"}, 8, 5));
        System.out.println(4 == findMaxForm.findMaxForm(
                new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));

        // 测试优化版本
        System.out.println(3 == findMaxForm.findMaxFormWithPruning(
                new String[]{"00011","00001","00001","0011","111"}, 8, 5));
        System.out.println(4 == findMaxForm.findMaxFormWithPruning(
                new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));

        System.out.println(3 == findMaxForm.findMaxFormWithCache(
                new String[]{"00011","00001","00001","0011","111"}, 8, 5));
        System.out.println(4 == findMaxForm.findMaxFormWithCache(
                new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
    }

    
}
