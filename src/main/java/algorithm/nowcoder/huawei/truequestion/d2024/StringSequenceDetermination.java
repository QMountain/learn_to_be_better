package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.Scanner;

// 字符串序列判定
public class StringSequenceDetermination {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String l = sc.nextLine();

        System.out.println(getResult(s, l));
    }

    public static int getResult(String s, String l) {
        int i = 0;
        int j = 0;

        int ans = -1;

        while (i < s.length() && j < l.length()) {
            if (s.charAt(i) == l.charAt(j)) {
                i++;
                ans = j;
            }
            j++;
        }

        return ans;
    }
}
