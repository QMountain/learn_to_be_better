package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.Scanner;

// 螺旋数字矩阵
public class SpiralNumericalMatrix {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int cols = (n + m - 1) / m;
        int[][] grid = new int[m][cols];
        int x = 0;
        int y = 0;
        grid[x][y] = 1;
        for (int i = 2; i <= n; i++) {
            if (y < cols - 1 && grid[x][y+1] == 0) {
                grid[x][++y] = i;
            } else if (x < m - 1 && grid[x+1][y] == 0) {
                grid[++x][y] = i;
            } else if (y > 0 && grid[x][y-1] == 0) {
                grid[x][--y] = i;
            } else if (x > 0 && grid[x-1][y] == 0) {
                grid[--x][y] = i;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < cols - 1; j++) {
                if (grid[i][j] > 0) {
                    System.out.print(grid[i][j] + " ");
                } else {
                    System.out.print("* ");
                }
            }
            if (grid[i][cols-1] > 0) {
                System.out.println(grid[i][cols-1] + " ");
            } else {
                System.out.println("* ");
            }
        }
    }
}
