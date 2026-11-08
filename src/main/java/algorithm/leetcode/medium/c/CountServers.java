package algorithm.leetcode.medium.c;

import java.util.*;

public class CountServers {

    /**
     * 2747. 统计没有收到请求的服务器数目
     * 给你一个整数 n ，表示服务器的总数目，
     * 再给你一个下标从 0 开始的 二维 整数数组 logs ，
     * 其中 logs[i] = [server_id, time] 表示 id 为 server_id 的服务器在 time 时收到了一个请求。
     * 同时给你一个整数 x 和一个下标从 0 开始的整数数组 queries  。
     * 请你返回一个长度等于 queries.length 的数组 arr ，
     * 其中 arr[i] 表示在时间区间 [queries[i] - x, queries[i]] 内没有收到请求的服务器数目。
     * 注意时间区间是个闭区间。
     */
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, Comparator.comparingInt(a -> a[1]));

        int m = queries.length;
        Integer[] ids = new Integer[m];
        for (int i = 0; i < m; i++) ids[i] = i;
        Arrays.sort(ids, Comparator.comparingInt(i -> queries[i]));

        int[] ans = new int[m];
        int[] cnt = new int[n + 1];
        int left = 0, right = 0, active = 0;

        for (int i : ids) {
            int q = queries[i];
            while (right < logs.length && logs[right][1] <= q) {
                int id = logs[right++][0];
                if (cnt[id]++ == 0) {
                    ++active;
                }
            }
            while (left < right && logs[left][1] < q - x) {
                int id = logs[left++][0];
                if (--cnt[id] == 0) {
                    --active;
                }
            }
            ans[i] = n - active;
        }
        return ans;
    }

    /**
     * 1267. 统计参与通信的服务器
     * 这里有一幅服务器分布图，服务器的位置标识在 m * n 的整数矩阵网格 grid 中，
     * 1 表示单元格上有服务器，0 表示没有。
     * 如果两台服务器位于同一行或者同一列，我们就认为它们之间可以进行通信。
     * 请你统计并返回能够与至少一台其他服务器进行通信的服务器的数量。
     */
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] eachRowCount = new int[m];
        int[] eachColCount = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    eachRowCount[i]++;
                    eachColCount[j]++;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (eachRowCount[i] > 1) {
                        ans++;
                    } else if (eachColCount[j] > 1) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    /**
     * 1267. 统计参与通信的服务器
     * 这里有一幅服务器分布图，服务器的位置标识在 m * n 的整数矩阵网格 grid 中，
     * 1 表示单元格上有服务器，0 表示没有。
     * 如果两台服务器位于同一行或者同一列，我们就认为它们之间可以进行通信。
     * 请你统计并返回能够与至少一台其他服务器进行通信的服务器的数量。
     */
    public int countServers2(int[][] grid) {
        HashMap<String, Integer> map = new HashMap<>();
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    String keyX = "x" + i;
                    map.put(keyX, map.getOrDefault(keyX, 0) + 1);
                    String keyY = "y" + j;
                    map.put(keyY, map.getOrDefault(keyY, 0) + 1);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    String keyX = "x" + i;
                    String keyY = "y" + j;
                    if (map.get(keyX) > 1) {
                        count++;
                    } else if (map.get(keyY) > 1) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountServers countServers = new CountServers();
        System.out.println(Arrays.toString(countServers.countServers(
                3, new int[][]{{2,4}, {2,1},{1,2}, {3,1}}, 2,
                new int[]{3, 4})));
        System.out.println(Arrays.toString(countServers.countServers(
                3, new int[][]{{1, 3}, {2, 6}, {1, 5}}, 5,
                new int[]{10, 11})));

        System.out.println(4 == countServers.countServers(new int[][]{{1,1,0,0},{0,0,1,0},{0,0,1,0},{0,0,0,1}}));
        System.out.println(3 == countServers.countServers(new int[][]{{1,0},{1,1}}));
        System.out.println(0 == countServers.countServers(new int[][]{{1,0},{0,1}}));
    }
}
