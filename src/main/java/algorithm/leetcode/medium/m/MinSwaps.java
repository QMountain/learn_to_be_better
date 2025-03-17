package algorithm.leetcode.medium.m;

/**
 * 给你一个字符串 s ，下标从 0 开始 ，且长度为偶数 n 。
 * 字符串 恰好 由 n / 2 个开括号 '[' 和 n / 2 个闭括号 ']' 组成。
 * 只有能满足下述所有条件的字符串才能称为 平衡字符串 ：
 * 字符串是一个空字符串，或者
 * 字符串可以记作 AB ，其中 A 和 B 都是 平衡字符串 ，或者
 * 字符串可以写成 [C] ，其中 C 是一个 平衡字符串 。
 * 你可以交换 任意 两个下标所对应的括号 任意 次数。
 * 返回使 s 变成 平衡字符串 所需要的 最小 交换次数。
 */
public class MinSwaps {

    // n == s.length
    // 2 <= n <= 10^6
    // n 为偶数
    // s[i] 为'[' 或 ']'
    // 开括号 '[' 的数目为 n / 2 ，闭括号 ']' 的数目也是 n / 2
    public int minSwaps(String s) {
        int length = s.length();
        int countLeft = 0;
        int countRight = 0;
        int ans = 0;
        char[] charArray = s.toCharArray();
        int readIndex = 0;
        int writeIndex = length - 1;
        while (readIndex < writeIndex) {
            if (charArray[readIndex] == '[') {
                countLeft++;
            } else {
                countRight++;
            }
            if (countLeft < countRight) {
                ans++;
                countRight--;
                countLeft++;
                while (charArray[writeIndex] != '[') {
                    writeIndex--;
                }
                charArray[readIndex++] = '[';
                charArray[writeIndex--] = ']';
            } else {
                readIndex++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MinSwaps minSwaps = new MinSwaps();
        System.out.println(2 == minSwaps.minSwaps("[[[" +
                "]]]" +
                "]" +
                "[][]" +
                "]" +
                "[[]]][" +
                "[" +
                "["));
       String a =  "[[["+
               "]]]" +
               "["+

               "[][]" +
               "]" +
               "[[]]][" +
               "[" +

               "]";
        System.out.println(1 == minSwaps.minSwaps("][]["));
        System.out.println(2 == minSwaps.minSwaps("]]][[["));
        System.out.println(0 == minSwaps.minSwaps("[]"));
    }
}
