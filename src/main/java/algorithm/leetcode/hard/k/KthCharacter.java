package algorithm.leetcode.hard.k;

public class KthCharacter {

    /**
     * 3307. 找出第 K 个字符 II
     * Alice 和 Bob 正在玩一个游戏。最初，Alice 有一个字符串 word = "a"。
     * 给定一个正整数 k 和一个整数数组 operations，其中 operations[i] 表示第 i 次操作的类型。
     * 现在 Bob 将要求 Alice 按顺序执行 所有 操作：
     *  如果 operations[i] == 0，将 word 的一份 副本追加 到它自身。
     *  如果 operations[i] == 1，将 word 中的每个字符 更改 为英文字母表中的 下一个 字符来生成一个新字符串，并将其 追加 到原始的 word。例如，对 "c" 进行操作生成 "cd"，对 "zb" 进行操作生成 "zbac"。
     * 在执行所有操作后，返回 word 中第 k 个字符的值。
     * 注意，在第二种类型的操作中，字符 'z' 可以变成 'a'。
     * 1 <= k <= 10^14
     * 1 <= operations.length <= 100
     * operations[i] 可以是 0 或 1。
     * 输入保证在执行所有操作后，word 至少有 k 个字符。
     */
    public char kthCharacter(long k, int[] operations) {
        if (k == 1) {
            return 'a';
        }
        int operateIndex = 0;
        while (k > (1L << operateIndex)) {
            operateIndex++;
        }
        long move = k;
        int change = 0;
        while (move > 1) {
            if (move > (1L << operateIndex)) {
                move -= 1L << operateIndex;
                if (operations[operateIndex] == 1) {
                    change++;
                }
            }
            operateIndex--;
        }
        change %= 26;
        return (char) ('a' + change);
    }

    public static void main(String[] args) {
        KthCharacter kthCharacter = new KthCharacter();
        System.out.println('k' == kthCharacter.kthCharacter(33354182522397L, new int[]{0,0,0,0,0,1,0,0,0,0,0,1,1,1,1,1,1,0,1,0,0,1,1,0,1,0,1,1,0,1,1,1,0,1,0,1,0,1,0,0,0,0,0,1,1,1,1,0,0,1,1,0,0,1,1,1,1,0,0,0,1,0,1,1,0,1,0,0,0,1,0,1,0,1,1,0,0,0,0,1,0,1,1,0,0,1,0,0,1,1,0,1,1,1,1,1,1,0,0,0}));
        System.out.println('a' == kthCharacter.kthCharacter(5, new int[]{0, 0, 0}));
        System.out.println('b' == kthCharacter.kthCharacter(10, new int[]{0, 1, 0, 1}));
    }
}
