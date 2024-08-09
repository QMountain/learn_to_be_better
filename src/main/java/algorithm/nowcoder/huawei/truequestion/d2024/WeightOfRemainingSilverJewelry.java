package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

// 剩余银饰的重量
public class WeightOfRemainingSilverJewelry {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 银饰数组长度
        int n = sc.nextInt();

        // n块银饰的重量
        LinkedList<Integer> weights = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            weights.add(sc.nextInt());
        }

        // 升序
        weights.sort((a, b) -> a - b);

        while (weights.size() >= 3) {
            // 尾删三个最大值
            int z = weights.removeLast();
            int y = weights.removeLast();
            int x = weights.removeLast();

            // 如果 x == y == z，那么下面公式结果：remain=0, 表示三块银饰完全融掉
            // 如果 x == y && y != z，那么下面公式结果：remain = z - y
            // 如果 x != y && y == z，那么下面公式结果：remain = y - x
            // 如果 x != y && y != z，那么下面公式结果：remain = Math.abs((z - y) - (y - x))
            int remain = Math.abs((z - y) - (y - x));

            // 如果还有剩余银块
            if (remain != 0) {
                // 那么就二分查找其在剩余升序weights中的有序插入位置
                int idx = Collections.binarySearch(weights, remain);

                if (idx < 0) {
                    idx = -idx - 1;
                }

                // 在有序插入位置插入
                weights.add(idx, remain);
            }
        }

        if (weights.size() == 2) {
            // 如果剩余两块，返回较大的重量（若两块重量相同，返回任意一块皆可）
            System.out.println(Math.max(weights.get(0), weights.get(1)));
        } else if (weights.size() == 1) {
            // 如果只剩下一块，返回该块的重量
            System.out.println(weights.get(0));
        } else {
            // 如果没有剩下，就返回 0
            System.out.println(0);
        }
    }
}
