package algorithm.leetcode.medium.p;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductQueries {

    public int[] productQueries(int n, int[][] queries) {
        String binaryString = Integer.toBinaryString(n);
        List<Integer> list = new ArrayList<>();
        int length = binaryString.length();
        for (int i = 0; i < length; i++) {
            char c = binaryString.charAt(length - 1 - i);
            if (c == '1') {
                list.add(i);
            }
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long v = 1L;
            int start = queries[i][0];
            int end = queries[i][1];
            for (int j = start; j <= end; j++) {
                v *= (1L << list.get(j)) % 1000_000_007;
                v %= 1000_000_007;
            }
            ans[i] = (int) v;
        }
        return ans;
    }

    public static void main(String[] args) {
        ProductQueries productQueries = new ProductQueries();
        System.out.println(Arrays.toString(productQueries.productQueries(
                15, new int[][]{{0,1},{2,2},{0,3}})));
    }
}
