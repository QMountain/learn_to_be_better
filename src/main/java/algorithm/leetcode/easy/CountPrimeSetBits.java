package algorithm.leetcode.easy;

public class CountPrimeSetBits {

    public int countPrimeSetBits(int left, int right) {
        int res = 0;
        for (int i = left; i <= right; i++) {
            if (isPrime(i)) {
                res++;
            }
        }
        return res;
    }

    public boolean isPrime(int n) {
        int countOne = 0;
        while (n > 0) {
            n = n & (n-1);
            countOne++;
        }
        if (countOne == 1) {
            return false;
        }
        boolean isPrime = true;
        for (int i = 2; i < countOne; i++) {
            if (countOne % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    public static void main(String[] args) {
        CountPrimeSetBits countPrimeSetBits = new CountPrimeSetBits();
        System.out.println(5 == countPrimeSetBits.countPrimeSetBits(10, 15));
        System.out.println(4 == countPrimeSetBits.countPrimeSetBits(6, 10));
    }
}
