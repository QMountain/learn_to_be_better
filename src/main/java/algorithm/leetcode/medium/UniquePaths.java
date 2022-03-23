package algorithm.leetcode.medium;

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        if (m < n) {
            int t = m;
            m = n;
            n = t;
        }
        int res = 1;
        for (int i = m; i <= m + n - 2; i++) {
            res *= i;
        }
        return res/(n-1);
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(1 == uniquePaths.uniquePaths(1, 2));
        System.out.println(28 == uniquePaths.uniquePaths(3, 7));
        System.out.println(3 == uniquePaths.uniquePaths(3, 2));
        System.out.println(28 == uniquePaths.uniquePaths(7, 3));
        System.out.println(6 == uniquePaths.uniquePaths(3, 3));
    }
}
