package algorithm.leetcode.easy.k;

public class KthCharacter {

    /**
     * 1 <= k <= 500
     */
    public char kthCharacter(int k) {
        if (k == 1) {
            return 'a';
        }
        int base = 1;
        while (k > base) {
            base <<= 1;
        }
        int move = k - (base >> 1);
        int change = 1;
        while (move > 1) {
            base >>= 1;
            if (move > base) {
                move -= base;
                change++;
            }
        }
        return (char) ('a' + change);
    }

    public static void main(String[] args) {
        KthCharacter kthCharacter = new KthCharacter();
        System.out.println('a' == kthCharacter.kthCharacter(1));
        System.out.println('b' == kthCharacter.kthCharacter(5));
        System.out.println('c' == kthCharacter.kthCharacter(10));
    }
}
