package algorithm.leetcode.medium.m;

/**
 * 给你两个整数 n 和 k 。
 * 对于一个由 不同 正整数组成的数组，如果其中不存在任何求和等于 k 的不同元素对，则称其为 k-avoiding 数组。
 * 返回长度为 n 的 k-avoiding 数组的可能的最小总和。
 */
public class MinimumSum {

    // 1 <= n, k <= 50
    public int minimumSum(int n, int k) {
        int left = k >> 1;
        if (left >= n) {
            return n * (n + 1) / 2;
        }
        int leftSum = left * (left + 1) / 2;
        int right = n - left + k - 1;
        int rightSum = (right - k + 1) * (k + right) / 2;
        return leftSum + rightSum;
    }

    public static void main(String[] args) {
        MinimumSum minimumSum = new MinimumSum();
        System.out.println(3 == minimumSum.minimumSum(2, 6));
        System.out.println(18 == minimumSum.minimumSum(5, 4));
    }
}
