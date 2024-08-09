package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.Scanner;

// 高效货运
public class EfficientFreightTransportation {

    // 输入输出处理
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int wa = sc.nextInt();
        int wb = sc.nextInt();
        int wt = sc.nextInt();
        int pa = sc.nextInt();
        int pb = sc.nextInt();

        // 装入货车的A货物数量至少1件，至多(wt - wb) / wa件
        int minX = 1;
        int maxX = (wt - wb) / wa;

        // 记录最大利润
        int ans = 0;

        // 枚举A货物的可能数量
        for (int x = minX; x <= maxX; x++) {
            // B货物可能的总重量
            int remain = wt - wa * x;

            if (remain % wb == 0) {
                // B货物的数量
                int y = remain / wb;

                // 计算利润，保留最大利润
                ans = Math.max(ans, pa * x + pb * y);
            }
        }

        System.out.println(ans);
    }
}
