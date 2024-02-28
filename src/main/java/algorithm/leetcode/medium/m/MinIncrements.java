package algorithm.leetcode.medium.m;

public class MinIncrements {

    // 3 <= n <= 10^5
    public int minIncrements(int n, int[] cost) {
        int m = n + 1;
        int ans = 0;
        while (m > 2) {
            m >>= 1;
            for (int i = n - m; i < n; i+=2) {
                int diff = Math.abs(cost[i] - cost[i+1]);
                ans += diff;
                cost[((i+1) >> 1) - 1] += Math.max(cost[i], cost[i+1]);
            }
            n -= m;
        }
        return ans;
    }

    public static void main(String[] args) {
        MinIncrements minIncrements = new MinIncrements();
        System.out.println(minIncrements.minIncrements(3, new int[]{5,3,3}));
        System.out.println(minIncrements.minIncrements(7, new int[]{1,5,2,2,3,3,1}));
    }
}
