package algorithm.nowcoder.huawei.easy;

import java.util.Scanner;

// HJ23 删除字符串中出现次数最少的字符
public class HJ23 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        int[] count = new int[26];
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            count[c - 'a']++;
        }
        int min = length;
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                min = Math.min(min, count[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (count[c - 'a'] > min) {
                sb.append(c);
            }
        }
        System.out.println(sb);
    }
}
