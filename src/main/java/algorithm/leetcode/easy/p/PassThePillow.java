package algorithm.leetcode.easy.p;

public class PassThePillow {

    public int passThePillow(int n, int time) {
        int interval = n - 1;
        int circle = time / interval;
        if (circle % 2 == 0) {
            return 1 + (time % interval);
        }
        return n - (time % interval);
    }

    public static void main(String[] args) {
        PassThePillow passThePillow = new PassThePillow();
        System.out.println(3 == passThePillow.passThePillow(3, 2));
        System.out.println(2 == passThePillow.passThePillow(4, 5));
    }
}
