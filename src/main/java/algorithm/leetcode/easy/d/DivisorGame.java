package algorithm.leetcode.easy.d;

public class DivisorGame {

    public boolean divisorGame(int n) {

        return n % 2== 0;
    }

    public static void main(String[] args) {
        DivisorGame divisorGame = new DivisorGame();
        System.out.println(divisorGame.divisorGame(3));
        System.out.println(divisorGame.divisorGame(2));
    }
}
