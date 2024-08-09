package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

// 多段线数据压缩
public class MultiSegmentDataCompression {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(getResult(nums));
    }

    public static String getResult(int[] nums) {
        StringJoiner sj = new StringJoiner(" ");

        // 上一个点坐标（preX, preY）
        int preX = nums[0];
        int preY = nums[1];

        // 上一次的运动方向（preDirectX, preDirectY）
        int preDirectX = 0;
        int preDirectY = 0;

        for (int i = 2; i < nums.length; i += 2) {
            // 当前点坐标（curX, curY）
            int curX = nums[i];
            int curY = nums[i + 1];

            // 上一个点到当前点的偏移量（offsetX, offsetY）
            int offsetX = curX - preX;
            int offsetY = curY - preY;

            // 根据偏移量得出本次的运动方向
            int base = Math.max(Math.abs(offsetX), Math.abs(offsetY));
            int directX = offsetX / base;
            int directY = offsetY / base;

            // 如果两次运动的方向不同
            if (directX != preDirectX || directY != preDirectY) {
                // 则上一个点是拐点，需要记录下来
                sj.add(preX + " " + preY);
            }

            preX = curX;
            preY = curY;

            preDirectX = directX;
            preDirectY = directY;
        }

        // 注意收尾
        sj.add(preX + " " + preY);

        return sj.toString();
    }
}
