package algorithm.leetcode.easy.l;

public class LosingPlayer {

    public String losingPlayer(int x, int y) {
        return Math.min(x, y/4) % 2 == 1 ? "Alice" : "Bob";
    }

    public String losingPlayer2(int x, int y) {
        if (x >= 2 && y >= 8) {
            return losingPlayer(x - 2, y - 8);
        }
        if (x >= 1 && y >= 4) {
            return "Alice";
        }
        return "Bob";
    }

    public static void main(String[] args) {
        LosingPlayer losingPlayer = new LosingPlayer();
        System.out.println(losingPlayer.losingPlayer(3, 12));
    }
}
