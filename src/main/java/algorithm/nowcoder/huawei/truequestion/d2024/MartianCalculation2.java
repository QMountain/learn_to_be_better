package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 火星文计算2
public class MartianCalculation2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.print(getResult(str));
    }

    public static long getResult(String str) {
        Pattern p = Pattern.compile("(\\d+)#(\\d+)");

        while (true) {
            Matcher m = p.matcher(str);
            if (!m.find()) break;

            String subStr = m.group(0);
            long x = Long.parseLong(m.group(1));
            long y = Long.parseLong(m.group(2));
            str = str.replaceFirst(subStr, 4 * x + 3 * y + 2 + "");
        }

        return Arrays.stream(str.split("\\$"))
                .map(Long::parseLong)
                .reduce((x, y) -> 2 * x + y + 3)
                .orElse(0L);
    }
}
