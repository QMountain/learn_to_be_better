package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.Scanner;

// 拼接URL
public class SplicingURLs {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        String[] arr = s.split(",");

        String prefix = arr.length > 0 && !arr[0].isEmpty() ? arr[0] : "/";
        String suffix = arr.length > 1 && !arr[1].isEmpty() ? arr[1] : "/";

        System.out.println(getResult(prefix, suffix));
    }

    public static String getResult(String prefix, String suffix) {
        prefix = prefix.replaceAll("/+$", "");
        suffix = suffix.replaceAll("^/+", "");
        return prefix + "/" + suffix;
    }
}
