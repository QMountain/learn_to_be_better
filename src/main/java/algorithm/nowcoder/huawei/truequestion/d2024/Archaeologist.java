package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

// 考古学家
public class Archaeologist {

    static int n;
    static String[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = Integer.parseInt(sc.nextLine());
        arr = sc.nextLine().split(" ");

        getResult();
    }

    public static void getResult() {
        // 排序是为了让相同元素相邻，方便后面树层去重
        Arrays.sort(arr);

        boolean[] used = new boolean[n];
        LinkedList<String> path = new LinkedList<>();
        HashSet<String> res = new HashSet<>();

        dfs(used, path, res);

        // 输出石碑文字的组合（按照升序排列）
        res.stream().sorted(String::compareTo).forEach(System.out::println);
    }

    public static void dfs(boolean[] used, LinkedList<String> path, HashSet<String> res) {
        if (path.size() == n) {
            StringBuilder sb = new StringBuilder();
            path.forEach(sb::append);
            res.add(sb.toString());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (used[i]) continue;

            // 树层去重
            if (i > 0 && arr[i].equals(arr[i - 1]) && !used[i - 1]) continue;

            path.addLast(arr[i]);
            used[i] = true;
            dfs(used, path, res);
            used[i] = false;
            path.removeLast();
        }
    }

}
