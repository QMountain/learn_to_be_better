package algorithm.leetcode.easy.s;

public class SmallestNumber {

    public int smallestNumber(int n) {
        int i = 0;
        while (n > 0) {
            n >>= 1;
            i++;
        }
        return (1 << i) - 1;
    }

    public static void main(String[] args) {
        SmallestNumber smallestNumber = new SmallestNumber();
        System.out.println(7 == smallestNumber.smallestNumber(5));
    }
}
