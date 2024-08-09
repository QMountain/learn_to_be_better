package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.ArrayList;
import java.util.Scanner;

// API集群负载统计
public class APIClusterLoadStatistics {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 日志的条数
        int n = sc.nextInt();

        // 获取n条日志
        ArrayList<String> urls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            urls.add(sc.next());
        }

        // 要查询的层级
        int l = sc.nextInt();
        // 要查询的关键字
        String keyWords = sc.next();

        // 记录给定层级上关键字出现的次数
        int ans = 0;

        for (String url : urls) {
            String[] urlComponents = url.split("/");

            for (int i = 0; i < urlComponents.length; i++) {
                // 当前层级是给定层级，且关键字一样
                if (i == l && urlComponents[i].equals(keyWords)) {
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}
