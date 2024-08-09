package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringJoiner;

// 特殊的加密算法
public class SpecialEncryptionAlgorithm {

    // 明文数字个数
    static int n;
    // 明文
    static int[] datas;
    // 密码本矩阵大小
    static int m;
    // 密码本
    static int[][] secrets;
    // 上，左，右，下偏移量，注意这里的顺序是有影响的，即下一步偏移后产生的密文的字符序必然是：上 < 左 < 右 < 下
    static int[][] offsets = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        datas = new int[n];
        for (int i = 0; i < n; i++) {
            datas[i] = sc.nextInt();
        }

        // 记录密码本中元素值等于“明文第一个数字”的所有元素的位置
        ArrayList<Integer> starts = new ArrayList<>();

        m = sc.nextInt();

        secrets = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                secrets[i][j] = sc.nextInt();

                // 如果密码本(i,j)位置元素指等于明文第一个数字值，则记录(i,j)作为一个出发位置
                if (datas[0] == secrets[i][j]) {
                    starts.add(i * m + j);
                }
            }
        }

        System.out.println(getResult(starts));
    }

    public static String getResult(ArrayList<Integer> starts) {
        for (int start : starts) {
            // 出发位置
            int x = start / m;
            int y = start % m;

            // used[i][j]用于记录密码本(i,j)元素是否已使用
            boolean[][] used = new boolean[m][m];
            // 出发点位置元素已使用
            used[x][y] = true;

            // 记录结果路径各节点位置
            LinkedList<String> path = new LinkedList<>();
            // 出发点位置记录
            path.add(x + " " + y);

            // 开始深搜
            if (dfs(x, y, 1, path, used)) {
                StringJoiner sj = new StringJoiner(" ");
                for (String pos : path) sj.add(pos);
                return sj.toString();
            }
        }

        return "error";
    }

    /**
     * @param x 当前位置横坐标
     * @param y 当前位置纵坐标
     * @param index datas[index]是将要匹配的明文数字
     * @param path 路径
     * @param used 密码本各元素使用情况
     * @return 是否找到符合要求的路径
     */
    public static boolean dfs(int x, int y, int index, LinkedList<String> path, boolean[][] used) {
        // 已找到明文最后一个数字，则找到符合要求的路径
        if (index == n) {
            return true;
        }

        // 否则，进行上、左、右、下四个方向偏移，注意这里的顺序是有影响的，即下一步偏移后产生的密文的字符序必然是：上 < 左 < 右 < 下
        for (int[] offset : offsets) {
            // 新位置
            int newX = x + offset[0];
            int newY = y + offset[1];

            // 新位置越界，或者新位置已使用，或者新位置不是目标值，则跳过
            if (newX < 0
                    || newX >= m
                    || newY < 0
                    || newY >= m
                    || used[newX][newY]
                    || secrets[newX][newY] != datas[index]) {
                continue;
            }

            // 递归进入新位置
            path.add(newX + " " + newY);
            used[newX][newY] = true;

            // 如果当前分支可以找到符合要求的路径，则返回
            if (dfs(newX, newY, index + 1, path, used)) {
                return true;
            }

            // 否则，回溯
            used[newX][newY] = false;
            path.removeLast();
        }

        return false;
    }

}
