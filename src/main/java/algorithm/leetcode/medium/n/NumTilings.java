package algorithm.leetcode.medium.n;

import java.util.TreeMap;

public class NumTilings {

    // 0 上下都不缺； 1 上缺； 2 下缺
    TreeMap<Integer, int[]> map = new TreeMap<>();

    // 1 <= n <= 1000
    public int numTilings(int n) {
        if (!map.containsKey(1)) {
            map.put(1, new int[]{1, 0, 0});
        }
        if (!map.containsKey(2)) {
            map.put(2, new int[]{2, 1, 1});
        }
        if (!map.containsKey(3)) {
            map.put(3, new int[]{5, 2, 2});
        }
        if (map.containsKey(n)) {
            return map.get(n)[0];
        }
        int m1 = numTilings(n - 1);
        int m2 = numTilings(n - 2);
        long m3 = map.get(n - 1)[1];
        int m4 = map.get(n - 1)[2];

        int divider = 1000_000_007;
        int ans = (int) ((m1 + m2 + m3 + m4) % divider);

        map.put(n, new int[]{ans, (int) (m3 + map.get(n-2)[0]) % divider, (m4 + map.get(n-2)[0]) % divider});
        return ans;
    }

    public static void main(String[] args) {
        NumTilings numTilings = new NumTilings();
        System.out.println(11 == numTilings.numTilings(4));
        System.out.println(1 == numTilings.numTilings(1));
        System.out.println(5 == numTilings.numTilings(3));
    }
}
