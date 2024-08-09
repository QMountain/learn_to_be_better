package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.Scanner;

// 园区参观路径
public class ParkVisitPath {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 长 -> 行数
        int m = sc.nextInt(); // 宽 -> 列数

        int[][] matrix = new int[n][m]; // 地图矩阵
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // 如果起点和终点不能参观，则没有路径
        if (matrix[0][0] == 1 || matrix[n - 1][m - 1] == 1) {
            System.out.println(0);
            return;
        }

        long[][] dp = new long[n][m];
        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) continue;

                if (i > 0) {
                    dp[i][j] += dp[i - 1][j];
                }

                if (j > 0) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }

        System.out.println(dp[n - 1][m - 1]);
    }
}
