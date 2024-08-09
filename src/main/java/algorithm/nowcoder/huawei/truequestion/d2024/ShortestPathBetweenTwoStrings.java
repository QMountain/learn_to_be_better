package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.Scanner;

// 两个字符串间的最短路径问题
public class ShortestPathBetweenTwoStrings {

    static String A;
    static String B;
    static int m;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        A = sc.next();
        B = sc.next();

        m = B.length();
        n = A.length();

        System.out.println(getResult());
    }

    public static int getResult() {
        // 初始时preRow记录第一行上各点到(0,0)点的最短距离，即为(0,0) -> (0,j) 的直线路径
        int[] preRow = new int[n + 1];
        for (int j = 0; j <= n; j++) {
            preRow[j] = j;
        }

        // 初始时curRow记录第二行上各点到(0,0)点的最短距离
        int[] curRow = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            // curRow[0]是指 (i, 0)点 到 (0,0)点 的最短距离，即为(0,0) -> (i, 0) 的直线路径
            curRow[0] = i;

            for (int j = 1; j <= n; j++) {
                if (A.charAt(j - 1) == B.charAt(i - 1)) {
                    // 如果可以走斜线，则选走斜线的点
                    curRow[j] = preRow[j - 1] + 1;
                } else {
                    // 如果不能走斜线，则从当前点的上方点、左方点中选择一个较小值
                    curRow[j] = Math.min(preRow[j], curRow[j - 1]) + 1;
                }
            }

            // 压缩
            System.arraycopy(curRow, 0, preRow, 0, n + 1);
        }

        return curRow[n];
    }
}
