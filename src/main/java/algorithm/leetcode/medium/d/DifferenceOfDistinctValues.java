package algorithm.leetcode.medium.d;

import java.util.*;

/**
 * 给你一个下标从 0 开始、大小为 m x n 的二维矩阵 grid ，请你求解大小同样为 m x n 的答案矩阵 answer 。
 * 矩阵 answer 中每个单元格 (r, c) 的值可以按下述方式进行计算：
 * 令 topLeft[r][c] 为矩阵 grid 中单元格 (r, c) 左上角对角线上 不同值 的数量。
 * 令 bottomRight[r][c] 为矩阵 grid 中单元格 (r, c) 右下角对角线上 不同值 的数量。
 * 然后 answer[r][c] = |topLeft[r][c] - bottomRight[r][c]| 。
 * 返回矩阵 answer 。
 * 矩阵对角线 是从最顶行或最左列的某个单元格开始，向右下方向走到矩阵末尾的对角线。
 * 如果单元格 (r1, c1) 和单元格 (r, c) 属于同一条对角线且 r1 < r ，
 * 则单元格 (r1, c1) 属于单元格 (r, c) 的左上对角线。类似地，可以定义右下对角线。
 */
public class DifferenceOfDistinctValues {

    /**
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n, grid[i][j] <= 50
     */
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        LinkedList<LinkedList<Integer>> prefix = new LinkedList<>();
        for (int i = cols-1; i >= 0; i--) {
            LinkedList<Integer> list = new LinkedList<>();
            Set<Integer> set = new HashSet<>();
            // 起点是 0行 i列
            int r = 0;
            int c = i;
            while (r < rows && c < cols) {
                list.addLast(set.size());
                set.add(grid[r++][c++]);
            }
            prefix.addLast(list);
        }
        for (int i = 1; i < rows; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            Set<Integer> set = new HashSet<>();
            // 起点是 i行 0列
            int r = i;
            int c = 0;
            while (r < rows && c < cols) {
                list.addLast(set.size());
                set.add(grid[r++][c++]);
            }
            prefix.addLast(list);
        }
        int[][] ans = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            Set<Integer> set = new HashSet<>();
            // 起点是 i行 cols-1列
            int r = i;
            int c = cols - 1;
            while (r >= 0 && c >= 0) {
                ans[r][c] = Math.abs(prefix.peekFirst().pollLast() - set.size());
                set.add(grid[r--][c--]);
            }
            prefix.pollFirst();
        }
        for (int i = cols-2; i >= 0; i--) {
            Set<Integer> set = new HashSet<>();
            // 起点是 rows-1行 i列
            int r = rows - 1;
            int c = i;
            while (r >= 0 && c >= 0) {
                ans[r][c] = Math.abs(prefix.peekFirst().pollLast() - set.size());
                set.add(grid[r--][c--]);
            }
            prefix.pollFirst();
        }
        return ans;
    }

    public static void main(String[] args) {
        DifferenceOfDistinctValues differenceOfDistinctValues = new DifferenceOfDistinctValues();
        System.out.println(Arrays.deepToString(differenceOfDistinctValues.differenceOfDistinctValues(
                new int[][]{{1}})));
        System.out.println(Arrays.deepToString(differenceOfDistinctValues.differenceOfDistinctValues(
                new int[][]{{1,2,3},{3,1,5},{3,2,1}})));
    }
}
