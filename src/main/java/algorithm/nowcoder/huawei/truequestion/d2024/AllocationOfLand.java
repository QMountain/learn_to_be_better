package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.HashMap;
import java.util.Scanner;

// 分配土地
public class AllocationOfLand {

    static class Rect {
        int minRow = Integer.MAX_VALUE;
        int maxRow = Integer.MIN_VALUE;
        int minCol = Integer.MAX_VALUE;
        int maxCol = Integer.MIN_VALUE;

        private void setRow(int row) {
            this.minRow = Math.min(this.minRow, row);
            this.maxRow = Math.max(this.maxRow, row);
        }

        private void setCol(int col) {
            this.minCol = Math.min(this.minCol, col);
            this.maxCol = Math.max(this.maxCol, col);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt(); // 长（行数）
        int n = sc.nextInt(); // 宽（列数）

        HashMap<Integer, Rect> rects = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = sc.nextInt();

                if (num > 0) {
                    rects.putIfAbsent(num, new Rect());
                    rects.get(num).setRow(i);
                    rects.get(num).setCol(j);
                }
            }
        }

        int maxArea = 0;
        for (int num : rects.keySet()) {
            Rect rect = rects.get(num);

            maxArea =
                    Math.max(maxArea, (rect.maxRow - rect.minRow + 1) * (rect.maxCol - rect.minCol + 1));
        }

        System.out.println(maxArea);
    }
}
