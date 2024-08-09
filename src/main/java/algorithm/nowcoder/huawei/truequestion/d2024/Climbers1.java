package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.Arrays;
import java.util.Scanner;

// 攀登者1
public class Climbers1 {

    // 输入处理
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] heights = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();

        System.out.println(getResult(heights));
    }

    // 算法实现（本题实际考试为核心代码模式，因此考试时只需要写出此函数实现即可）
    public static int getResult(int[] heights) {
        int count = 0;

        for (int i = 0; i < heights.length; i++) {
            int leftHeight = i - 1 >= 0 ? heights[i - 1] : 0;
            int rightHeight = i + 1 < heights.length ? heights[i + 1] : 0;

            if (heights[i] > leftHeight && heights[i] > rightHeight) {
                count++;
            }
        }

        return count;
    }
}
