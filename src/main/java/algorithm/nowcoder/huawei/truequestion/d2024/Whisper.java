package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

// 悄悄话
public class Whisper {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] times = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 记录题解
        int ans = 0;

        // 根节点的索引是0
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(0);

        while (queue.size() > 0) {
            int fa = queue.removeFirst(); // 父节点索引

            int ch1 = 2 * fa + 1; // 左子节点索引
            int ch2 = 2 * fa + 2; // 右子节点索引

            // fa是否存在左子节点
            boolean ch1_exist = ch1 < times.length && times[ch1] != -1;
            // fa是否存在右子节点
            boolean ch2_exist = ch2 < times.length && times[ch2] != -1;

            // fa如果存在左子节点
            if (ch1_exist) {
                times[ch1] += times[fa];
                queue.addLast(ch1);
            }

            // fa如果存在右子节点
            if (ch2_exist) {
                times[ch2] += times[fa];
                queue.addLast(ch2);
            }

            // fa是叶子节点
            if (!ch1_exist && !ch2_exist) {
                // 保留叶子节点中最大时延
                ans = Math.max(ans, times[fa]);
            }
        }

        System.out.println(ans);
    }
}
