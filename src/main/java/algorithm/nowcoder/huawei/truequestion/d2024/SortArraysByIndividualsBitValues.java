package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

// 整型数组按个位值排序
public class SortArraysByIndividualsBitValues {

    // 输入获取
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(",");
        System.out.println(getResult(arr));
    }

    // 算法入口
    public static String getResult(String[] arr) {
        Arrays.sort(arr, (a, b) -> a.charAt(a.length() - 1) - b.charAt(b.length() - 1));

        StringJoiner sj = new StringJoiner(",");
        for (String s : arr) sj.add(s);
        return sj.toString();
    }
}
