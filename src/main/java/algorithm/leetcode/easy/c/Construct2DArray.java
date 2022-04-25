package algorithm.leetcode.easy.c;

import java.util.Arrays;

/**
 * @ClassName Construct2DArray
 * @Description 将一维数组转变成二维数组
 * @Author qsf
 * Date   2022-01-01  23:30
 */
public class Construct2DArray {

    public int[][] construct2DArray(int[] original, int m, int n) {
        if (m * n != original.length) {
            return new int[0][0];
        }
        int[][] res = new int[m][n];
        for (int i = 0; i < original.length; i++) {
            int x = i / n;
            int y = i % n;
            res[x][y] = original[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Construct2DArray array = new Construct2DArray();
        int[][] ints = array.construct2DArray(new int[]{1, 2, 3, 4}, 2, 2);
        System.out.println(Arrays.deepToString(ints));

        int[][] ints2 = array.construct2DArray(new int[]{1, 2, 3}, 1, 3);
        System.out.println(Arrays.deepToString(ints2));

        int[][] ints3 = array.construct2DArray(new int[]{1, 2}, 1, 1);
        System.out.println(Arrays.deepToString(ints3));

        int[][] ints4 = array.construct2DArray(new int[]{3}, 1, 2);
        System.out.println(Arrays.deepToString(ints4));
    }
}
