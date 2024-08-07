package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.Scanner;

// 密码解密
public class PasswordDecryption {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        for (int i = 26; i >= 1; i--) {
            String key = i + (i > 9 ? "\\*" : "");
            String val = String.valueOf((char) ('a' + i - 1));
            s = s.replaceAll(key, val);
        }

        System.out.println(s);
    }
}
