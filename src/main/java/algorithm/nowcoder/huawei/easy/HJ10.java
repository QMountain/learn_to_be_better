package algorithm.nowcoder.huawei.easy;

import java.util.Scanner;

public class HJ10 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String next = in.next();
        int ans = 0;
        boolean[] arr = new boolean[128];
        for (int i = 0; i < next.length(); i++) {
            if (!arr[next.charAt(i)]) {
                arr[next.charAt(i)] = true;
                ans++;
            }
        }
        System.out.println(ans);
    }
}
