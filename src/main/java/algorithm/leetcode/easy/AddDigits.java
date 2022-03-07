package algorithm.leetcode.easy;

public class AddDigits {

    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        if (num == 10) {
            return 1;
        }
        return (num-1)%9+1;
    }

    public static void main(String[] args) {
        AddDigits addDigits = new AddDigits();
        System.out.println(2 == addDigits.addDigits(38));
        System.out.println(0 == addDigits.addDigits(0));
        System.out.println(-1%9);
    }
}
