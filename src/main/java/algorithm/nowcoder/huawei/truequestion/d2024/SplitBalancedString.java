package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.Scanner;

// 分割均衡字符串
public class SplitBalancedString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        int countX = 0;
        int countY = 0;

        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'X') {
                countX++;
            } else {
                countY++;
            }

            if (countX == countY) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}
