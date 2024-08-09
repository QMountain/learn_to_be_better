package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

// 伐木工
public class Logger {

    static class Wood {
        int profit; // 记录木材的最大收益
        ArrayList<Integer> slices = new ArrayList<>(); // 记录木材最大收益时对应的切割状态
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        Wood[] dp = new Wood[x + 1];

        for (int i = 0; i <= x; i++) {
            // 初始时，将木材不切割的收益作为最大收益
            dp[i] = new Wood();
            dp[i].profit = i;
            dp[i].slices.add(i);
        }

        // 从长度为2的木材开始尝试切割
        for (int i = 2; i <= x; i++) {
            for (int j = 1; j < i; j++) {
                int profit = dp[j].profit * dp[i - j].profit;

                // 如果该切割方案的收益更大，或者收益和之前切割方案的收益相同，但是切割数更少，则使用当前切割方案
                if (profit > dp[i].profit
                        || (profit == dp[i].profit
                        && dp[i].slices.size() > dp[j].slices.size() + dp[i - j].slices.size())) {
                    dp[i].profit = profit;
                    dp[i].slices.clear();
                    dp[i].slices.addAll(dp[j].slices);
                    dp[i].slices.addAll(dp[i - j].slices);
                }
            }
        }

        // dp[x].slices记录的是：长度x的木材对应的最大收益的切割方案
        // 按题目输出描述要求进行升序
        dp[x].slices.sort((a, b) -> a - b);

        // 打印切割方案
        StringJoiner sj = new StringJoiner(" ");
        for (int slice : dp[x].slices) {
            sj.add(slice + "");
        }

        System.out.println(sj);
    }
}
