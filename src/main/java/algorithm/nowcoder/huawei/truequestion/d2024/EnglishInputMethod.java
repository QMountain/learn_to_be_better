package algorithm.nowcoder.huawei.truequestion.d2024;

import java.util.Collections;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.TreeSet;

// 英文输入法
public class EnglishInputMethod {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String pre = sc.nextLine();
        System.out.println(getResult(str, pre));
    }

    public static String getResult(String str, String pre) {
        String[] tmp = str.split("[^a-zA-Z]");
        TreeSet<String> cache = new TreeSet<>();
        Collections.addAll(cache, tmp);

        StringJoiner sj = new StringJoiner(" ");
        cache.stream().filter(s -> s.startsWith(pre)).forEach(s -> sj.add(s));

        String ans = sj.toString();
        if (ans.length() > 0) {
            return ans;
        } else {
            return pre;
        }
    }
}
