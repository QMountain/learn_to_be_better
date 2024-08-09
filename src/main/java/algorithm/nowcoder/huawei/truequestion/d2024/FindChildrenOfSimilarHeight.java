package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

// 寻找身高相近的小朋友
public class FindChildrenOfSimilarHeight {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int n = sc.nextInt();

        Integer[] heights = new Integer[n];
        for (int i = 0; i < n; i++) heights[i] = sc.nextInt();

        System.out.println(getResult(h, heights));
    }

    public static String getResult(int h, Integer[] heights) {
        Arrays.sort(
                heights,
                (a, b) -> {
                    int absA = Math.abs(a - h);
                    int abaB = Math.abs(b - h);

                    if (absA != abaB) return absA - abaB;
                    else return a - b;
                });

        StringJoiner sj = new StringJoiner(" ");
        for (Integer height : heights) {
            sj.add(height + "");
        }
        return sj.toString();
    }
}
