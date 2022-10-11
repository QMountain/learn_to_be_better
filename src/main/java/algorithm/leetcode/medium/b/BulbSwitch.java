package algorithm.leetcode.medium.b;

public class BulbSwitch {

    public int bulbSwitch(int n) {
        if (n < 2) {
            return n;
        }
        if (n < 4) {
            return 1;
        }
        if (n < 9) {
            return 2;
        }
        int i = (int)Math.sqrt(n + 1);
        if (i*i == (n+1)) {
            return i-1;
        }
        return (int) (Math.sqrt(n + 1) - 1) + 1;
    }

    public static void main(String[] args) {
        BulbSwitch bulbSwitch = new BulbSwitch();
        System.out.println(3 == bulbSwitch.bulbSwitch(15));
        System.out.println(2 == bulbSwitch.bulbSwitch(7));
        System.out.println(2 == bulbSwitch.bulbSwitch(5));
        System.out.println(2 == bulbSwitch.bulbSwitch(4));
        System.out.println(2 == bulbSwitch.bulbSwitch(6));
        System.out.println(1 == bulbSwitch.bulbSwitch(1));
        System.out.println(0 == bulbSwitch.bulbSwitch(0));
        System.out.println(1 == bulbSwitch.bulbSwitch(3));
    }
}
