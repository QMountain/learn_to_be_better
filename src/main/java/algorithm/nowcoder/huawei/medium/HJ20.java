package algorithm.nowcoder.huawei.medium;

import java.util.HashSet;
import java.util.Scanner;

// HJ20 密码验证合格程序
public class HJ20 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String password = in.next();
            int length = password.length();
            if (length <= 8) {
                System.out.println("NG");
                continue;
            }
            int count = 0;
            boolean containsUpper = false;
            boolean containsLower = false;
            boolean containsNumber = false;
            boolean containsOther = false;
            boolean ok = true;
            HashSet<String> set = new HashSet<>();
            for (int i = 0; i < length; i++) {
                char c = password.charAt(i);
                if (Character.isUpperCase(c)) {
                    if (!containsUpper) {
                        containsUpper = true;
                        count++;
                    }
                } else if (Character.isLowerCase(c)) {
                    if (!containsLower) {
                        containsLower = true;
                        count++;
                    }
                } else if (Character.isDigit(c)) {
                    if (!containsNumber) {
                        containsNumber = true;
                        count++;
                    }
                } else if (!containsOther) {
                    containsOther = true;
                    count++;
                }
                for (int j = i+3; j < length; j++) {
                    if (!set.add(password.substring(i, j))) {
                        ok = false;
                        break;
                    }
                }
                if (!ok) {
                    break;
                }
            }
            if (count < 3 || !ok) {
                System.out.println("NG");
                continue;
            }
            System.out.println("OK");
        }
    }
}
