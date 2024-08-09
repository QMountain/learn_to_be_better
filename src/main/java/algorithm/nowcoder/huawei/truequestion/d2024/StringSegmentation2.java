package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.Scanner;
import java.util.StringJoiner;

// 字符串分割(二)
public class StringSegmentation2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        String s = sc.next();

        System.out.println(getResult(k, s));
    }

    public static String getResult(int k, String s) {
        String[] arr = s.split("-");

        // 第一个子串不做处理
        StringJoiner sj = new StringJoiner("-");
        //    sj.add(convert(arr[0])); // 看用例说明，对应第一个子串是不需要做大小写转换的，但是也拿不准，考试时可以都试下
        sj.add(arr[0]);

        // 剩余子串重新合并为一个新字符串，每k个字符一组
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < arr.length; i++) sb.append(arr[i]);
        String newStr = sb.toString();

        for (int i = 0; i < newStr.length(); i += k) {
            String subStr = newStr.substring(i, Math.min(i + k, newStr.length()));
            // 子串中小写字母居多，则整体转为小写字母，大写字母居多，则整体转为大写字母
            sj.add(convert(subStr));
        }

        return sj.toString();
    }

    public static String convert(String str) {
        int lowerCount = 0;
        int upperCount = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z') lowerCount++;
            else if (c >= 'A' && c <= 'Z') upperCount++;
        }

        if (lowerCount > upperCount) return str.toLowerCase();
        else if (lowerCount < upperCount) return str.toUpperCase();
        else return str;
    }
}
