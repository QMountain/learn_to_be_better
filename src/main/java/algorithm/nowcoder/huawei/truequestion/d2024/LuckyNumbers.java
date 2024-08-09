package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.Scanner;

// 小明的幸运数
public class LuckyNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n < 1 || n > 100) {
            // 异常情况下输出：12345
            System.out.println("12345");
            return;
        }

        int m = sc.nextInt();

        if (m < -100 || m > 100) {
            // 异常情况下输出：12345
            System.out.println("12345");
            return;
        }

        int pos = 0;
        int maxPos = 0;

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();

            if (num < -100 || num > 100) {
                // 异常情况下输出：12345
                System.out.println("12345");
                return;
            }

            pos += num;

            if (num == m) {
                // 如果某个指令正好和幸运数相等，则小明行进步数+1
                // 注意，如果幸运数字为0，且存在指令为0，那么此时我理解小明应该继续保持不动
                if (num > 0) {
                    pos += 1;
                } else if (num < 0) {
                    pos -= 1;
                }
            }

            // 比较本次移动后的坐标位置和最大坐标位置
            maxPos = Math.max(maxPos, pos);
        }

        System.out.println(maxPos);
    }
}
