package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.Scanner;

// 执行时长
public class ExecutionDuration {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int maxCount = sc.nextInt();

        int n = sc.nextInt();
        int[] tasks = new int[n];
        for (int i = 0; i < n; i++) tasks[i] = sc.nextInt();

        System.out.println(getResult(maxCount, tasks));
    }

    public static int getResult(int maxCount, int[] tasks) {
        int time = 0;
        int remain = 0;

        for (int task : tasks) {
            if (task + remain > maxCount) {
                remain = task + remain - maxCount;
            } else {
                remain = 0;
            }
            time++;
        }

        while (remain > 0) {
            remain -= maxCount;
            time++;
        }

        return time;
    }
}
