package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.Arrays;
import java.util.Scanner;

// 字符串筛选排序
public class StringFilteringAndSorting {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int k = sc.nextInt();

        System.out.println(getResult(str, k));
    }

    public static int getResult(String str, int k) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);

        if (k > str.length()) k = str.length();

        char tar = chars[k - 1];
        return str.indexOf(tar);
    }
}
