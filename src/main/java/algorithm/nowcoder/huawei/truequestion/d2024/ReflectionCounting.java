package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.Scanner;

// 反射计数
public class ReflectionCounting {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int w = sc.nextInt();
        int h = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int sx = sc.nextInt();
        int sy = sc.nextInt();
        int t = sc.nextInt();

        char[][] matrix = new char[h][w];
        for (int i = 0; i < h; i++) {
            matrix[i] = sc.next().toCharArray();
        }

        int ans = 0;

        while (t >= 0) {
            // 注意本题横纵坐标是反的，因此y其实是行号，x是列号
            if (matrix[y][x] == '1') {
                ans++;
            }

            y += sy;
            x += sx;

            if (x < 0) {
                x = 1;
                sx = -sx;
            } else if (x >= w) { //  注意本题横纵坐标是反的，因此x是列号，w是矩阵列数
                x = w - 2;
                sx = -sx;
            }

            if (y < 0) {
                y = 1;
                sy = -sy;
            } else if (y >= h) { //  注意本题横纵坐标是反的，因此y是行号，h是矩阵行数
                y = h - 2;
                sy = -sy;
            }

            t--;
        }

        System.out.println(ans);
    }
}
