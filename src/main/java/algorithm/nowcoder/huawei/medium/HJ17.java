package algorithm.nowcoder.huawei.medium;

import java.util.Scanner;

// HJ17 坐标移动
public class HJ17 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String command = in.next();
        String[] split = command.split(";");
        int x = 0;
        int y = 0;
        for (String s : split) {
            if (s.length() > 3 || s.length() < 2) {
                continue;
            }
            char c = s.charAt(0);
            if (c == 'W' || c == 'A' || c == 'S' || c == 'D') {
                boolean isNumber = true;
                for (int i = 1; i < s.length(); i++) {
                    if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                        isNumber = false;
                        break;
                    }
                }
                if (isNumber) {
                    if (c == 'W') {
                        y += Integer.parseInt(s.substring(1));
                    } else if (c == 'S') {
                        y -= Integer.parseInt(s.substring(1));
                    } else if (c == 'A') {
                        x -= Integer.parseInt(s.substring(1));
                    } else {
                        x += Integer.parseInt(s.substring(1));
                    }
                }
            }
        }
        System.out.println(x + "," + y);
    }
}
