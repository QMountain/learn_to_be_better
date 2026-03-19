package algorithm.leetcode.medium.r;

import java.util.*;

public class RangeAddQueries {

    /**
     * 2536. 子矩阵元素加 1
     * 给你一个正整数 n ，表示最初有一个 n x n 、下标从 0 开始的整数矩阵 mat ，矩阵中填满了 0 。
     * 另给你一个二维整数数组 query 。
     * 针对每个查询 query[i] = [row1i, col1i, row2i, col2i] ，请你执行下述操作：
     * 找出 左上角 为 (row1i, col1i) 且 右下角 为 (row2i, col2i) 的子矩阵，
     * 将子矩阵中的 每个元素 加 1 。
     * 也就是给所有满足 row1i <= x <= row2i 和 col1i <= y <= col2i 的 mat[x][y] 加 1 。
     * 返回执行完所有操作后得到的矩阵 mat 。
     * 1 <= n <= 500
     * 1 <= queries.length <= 10^4
     * 0 <= row1i <= row2i < n
     * 0 <= col1i <= col2i < n
     */
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] arr = new int[n][n];
        Map<String, List<int[]>> map = new HashMap<>();
        for (int[] query : queries) {
            String key = query[0] + "-" + query[1];
            List<int[]> list = map.getOrDefault(key, new ArrayList<>());
            int[] value = new int[]{query[0], query[1], query[2], query[3], query[0], query[1]};
            list.add(value);
            map.put(key, list);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String key = i + "-" + j;
                List<int[]> list = map.get(key);
                if (list != null) {
                    arr[i][j] = list.size();
                    List<int[]> items = new ArrayList<>();
                    for (int[] item : list) {

                    }
                }
            }
        }
        return null;
    }

    public int[][] rangeAddQueries2(int n, int[][] queries) {
        int[][] arr = new int[n][n];
        for (int[] query : queries) {
            for (int i = query[0]; i <= query[2]; i++) {
                for (int j = query[1]; j <= query[3]; j++) {
                    arr[i][j]++;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        RangeAddQueries rangeAddQueries = new RangeAddQueries();
        int[][] result = rangeAddQueries.rangeAddQueries(3,
                new int[][]{{1,1,2,2},{0,0,1,1}});
        System.out.println(Arrays.deepToString(result));

        // 验证结果
        int[][] expected = {{1,1,0},{1,2,1},{0,1,1}};
        System.out.println("Expected: " + Arrays.deepToString(expected));
        System.out.println("Match: " + Arrays.deepEquals(result, expected));
    }
}
