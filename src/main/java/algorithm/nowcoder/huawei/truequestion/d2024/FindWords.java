package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringJoiner;

// 找单词
public class FindWords {

    static int n;
    static char[][] matrix;
    static String word;

    static boolean[][] used;
    static LinkedList<String> path = new LinkedList<>();

    public static void main(String[] args) {
        // 将输入分隔符改为“,”和换行
        Scanner sc = new Scanner(System.in).useDelimiter("[,\n]");

        n = sc.nextInt();

        matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.next().charAt(0);
            }
        }

        word = sc.next();

        used = new boolean[n][n];

        System.out.println(getResult());
    }

    public static String getResult() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (dfs(i, j, 0)) {
                    StringJoiner sj = new StringJoiner(",");
                    for (String pos : path) sj.add(pos);
                    return sj.toString();
                }
            }
        }
        return "N";
    }

    public static boolean dfs(int i, int j, int k) {
        if (i < 0 || i >= n || j < 0 || j >= n || word.charAt(k) != matrix[i][j] || used[i][j]) {
            return false;
        }

        path.add(i + "," + j);

        if (path.size() == word.length()) {
            return true;
        }

        used[i][j] = true;

        boolean res =
                dfs(i - 1, j, k + 1)
                        || dfs(i + 1, j, k + 1)
                        || dfs(i, j - 1, k + 1)
                        || dfs(i, j + 1, k + 1);

        if (!res) {
            used[i][j] = false;
            path.removeLast();
        }

        return res;
    }
}
