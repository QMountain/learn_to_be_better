package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.Scanner;

// 最长子字符串的长度（一）
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(getResult(sc.nextLine()));
    }

    public static int getResult(String s) {
        int n = s.length();

        // s中'o'的个数
        int zeroCount = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'o') zeroCount++;
        }

        if (zeroCount % 2 == 0) {
            return n;
        } else {
            return n - 1;
        }
    }
}
