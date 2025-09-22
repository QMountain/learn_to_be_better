package algorithm.leetcode.medium.l;

import java.util.LinkedList;

public class LengthAfterTransformations {

    /**
     * 3335. 字符串转换后的长度 I
     * 给你一个字符串 s 和一个整数 t，表示要执行的 转换 次数。每次 转换 需要根据以下规则替换字符串 s 中的每个字符：
     * 如果字符是 'z'，则将其替换为字符串 "ab"。
     * 否则，将其替换为字母表中的下一个字符。例如，'a' 替换为 'b'，'b' 替换为 'c'，依此类推。
     * 返回 恰好 执行 t 次转换后得到的字符串的 长度。
     * 由于答案可能非常大，返回其对 10^9 + 7 取余的结果。
     * 1 <= s.length <= 10^5
     * s 仅由小写英文字母组成。
     * 1 <= t <= 10^5
     */
    public int lengthAfterTransformations(String s, int t) {
        long[] count = new long[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        LinkedList<Long> list = new LinkedList<>();
        for (long l : count) {
            list.add(l);
        }
        long ans = s.length();
        for (int i = 0; i < t; i++) {
            Long l = list.pollLast();
            if (l > 0) {
                list.set(0, (list.peekFirst() + l) % 1000000007);
                ans += l;
                ans %= 1000000007;
            }
            list.addFirst(l);
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        LengthAfterTransformations lengthAfterTransformations = new LengthAfterTransformations();
        System.out.println(79033769 == lengthAfterTransformations.lengthAfterTransformations("jqktcurgdvlibczdsvnsg", 7517));
        System.out.println(7 == lengthAfterTransformations.lengthAfterTransformations("abcyy", 2));
        System.out.println(5 == lengthAfterTransformations.lengthAfterTransformations("azbk", 1));
    }
}
