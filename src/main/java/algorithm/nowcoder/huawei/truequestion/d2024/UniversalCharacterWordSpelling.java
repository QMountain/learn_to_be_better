package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.Scanner;

// 万能字符单词拼写
public class UniversalCharacterWordSpelling {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }

        String chars = sc.next();

        System.out.println(getResult(words, n, chars));
    }

    public static int getResult(String[] words, int n, String chars) {
        int ans = 0;

        // 统计chars字符串中各字符的数量
        int[] cnt_chars = charStatistic(chars);

        for (int i = 0; i < n; i++) {
            int diff = 0;

            // 统计word字符串中各字符的数量
            int[] cnt_word = charStatistic(words[i]);

            for (int j = 0; j < 128; j++) {
                // 记录word的某字符超过chars的对应字符出现的数量
                diff += Math.max(cnt_word[j] - cnt_chars[j], 0);
            }

            if (diff <= cnt_chars['?']) {
                ans++;
                // System.out.println(words[i]);
            }
        }

        return ans;
    }

    public static int[] charStatistic(String s) {
        int[] cnts = new int[128];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cnts[c] += 1;
        }

        return cnts;
    }
}
