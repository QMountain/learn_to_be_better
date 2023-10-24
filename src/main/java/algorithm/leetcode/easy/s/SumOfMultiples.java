package algorithm.leetcode.easy.s;

public class SumOfMultiples {

    // 1 <= n <= 10^3
    public int sumOfMultiples(int n) {
        int sum3 = cal(3, n);
        int sum5 = cal(5, n);
        int sum7 = cal(7, n);
        int sum357 = cal(3*5*7, n);
        int sum35 = cal(15, n);
        int sum37 = cal(21, n);
        int sum57 = cal(35, n);
        return sum3 + sum5 + sum7 - sum35 - sum57 - sum37 + sum357;
    }

    public int cal(int a0, int n) {
        int bs = n / a0;
        return (a0 + (bs * a0)) * bs / 2;
    }

    public static void main(String[] args) {
        SumOfMultiples sumOfMultiples = new SumOfMultiples();
        System.out.println(30 == sumOfMultiples.sumOfMultiples(9));
        System.out.println(40 == sumOfMultiples.sumOfMultiples(10));
        System.out.println(21 == sumOfMultiples.sumOfMultiples(7));
    }
}
