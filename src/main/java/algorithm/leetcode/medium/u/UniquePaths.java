package algorithm.leetcode.medium.u;

import java.util.ArrayList;
import java.util.List;

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        if (m == 2) {
            return n;
        }
        if (n == 2) {
            return m;
        }
        if (m < n) {
            int t = m;
            m = n;
            n = t;
        }
        List<Integer> bcsList = new ArrayList<>();
        for (int i = m; i <= m + n - 2; i++) {
            bcsList.add(i);
        }
        List<Integer> csList = new ArrayList<>();
        for (int i = 1; i <= n-1; i++) {
            csList.add(i);
        }
        while (true) {
            boolean changed = false;
            for (int i = bcsList.size()-1; i >= 0; i--) {
                Integer bcs = bcsList.get(i);
                for (int j = csList.size()-1; j >= 0; j--) {
                    Integer cs = csList.get(j);
                    if (bcs % cs == 0) {
                        changed = true;
                        csList.remove(j);
                        bcsList.remove(i);
                        if (!bcs.equals(cs)) {
                            bcsList.add(i,bcs/cs);
                        }

                        break;
                    }
                }
            }
            if (!changed) {
                break;
            }
        }
        long totalBcs = 1;
        for (Integer integer : bcsList) {
            totalBcs *= integer;
        }
        long totalCs = 1;
        for (Integer integer : csList) {
            totalCs *= integer;
        }
        return (int) (totalBcs/totalCs);
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(16, 16));
        System.out.println(100 == uniquePaths.uniquePaths(2, 100));
        System.out.println(48620 == uniquePaths.uniquePaths(10, 10));
        System.out.println(1 == uniquePaths.uniquePaths(1, 2));
        System.out.println(28 == uniquePaths.uniquePaths(3, 7));
        System.out.println(3 == uniquePaths.uniquePaths(3, 2));
        System.out.println(28 == uniquePaths.uniquePaths(7, 3));
        System.out.println(6 == uniquePaths.uniquePaths(3, 3));
    }
}
