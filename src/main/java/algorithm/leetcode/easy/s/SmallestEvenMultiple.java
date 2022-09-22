package algorithm.leetcode.easy.s;

public class SmallestEvenMultiple {

    public int smallestEvenMultiple(int n) {
        return n == 1 ? 2 : (n % 2 == 0 ? n : n*2);
    }

    public static void main(String[] args) {
        SmallestEvenMultiple smallestEvenMultiple = new SmallestEvenMultiple();
        System.out.println(smallestEvenMultiple.smallestEvenMultiple(6));
        System.out.println(smallestEvenMultiple.smallestEvenMultiple(5));
    }
}
