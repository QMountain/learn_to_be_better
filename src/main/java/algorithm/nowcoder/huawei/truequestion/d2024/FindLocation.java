package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.Arrays;
import java.util.Scanner;

// 小明找位置
public class FindLocation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int target = Integer.parseInt(sc.nextLine());

        // 这里Arrays.binarySearch找不到目标值时，就会返回-low-1，其中low就是目标值的有序插入位置，为什么这么设计返回值，请看解析中外链的博客说明
        int idx = Arrays.binarySearch(nums, target);

        if (idx < 0) {
            idx = -idx - 1;
        }

        // 队列位置（从1开始），因此索引+1
        System.out.println(idx + 1);
    }
}
