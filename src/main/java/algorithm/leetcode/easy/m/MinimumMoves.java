package algorithm.leetcode.easy.m;

public class MinimumMoves {

    public int minimumMoves(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'X') {
                count++;
                i += 2;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MinimumMoves minimumMoves = new MinimumMoves();
        System.out.println(0 == minimumMoves.minimumMoves("OOOO"));
        System.out.println(2 == minimumMoves.minimumMoves("XXOX"));
        System.out.println(1 == minimumMoves.minimumMoves("XXX"));
    }

}
