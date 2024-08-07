package algorithm.nowcoder.huawei.easy;

import java.util.Scanner;

// HJ5 进制转换
public class HJ5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String next = in.next();
            int ans = 0;
            int ms = 1;
            for (int i = next.length() - 1; i > 1; i--) {
                char c = next.charAt(i);
                if (c >= '0' && c <= '9') {
                    ans += (c - '0') * ms;
                } else {
                    ans += (c - 'A' + 10) * ms;
                }
                ms *= 16;
            }
            System.out.println(ans);
        }
    }
}
