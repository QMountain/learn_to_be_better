package algorithm.leetcode.medium.c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountPrimes {

    List<Integer> primeList = new ArrayList<>();

    // 超时
    public int countPrimes2(int n) {
        int maxPrime = 1;
        if (primeList.size() > 0) {
            maxPrime = primeList.get(primeList.size()-1);
        }
        if (n > 2 && primeList.size() == 0) {
            primeList.add(2);
        }
        for (int i = maxPrime+2; i < n; i+=2) {
            boolean isPrime = true;
            for (Integer prime : primeList) {
                if (Math.sqrt(i)+1 < prime) {
                    break;
                }
                if (i % prime == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primeList.add(i);
            }
        }
        int left = 0;
        int right = primeList.size()-1;
        if (right == -1) {
            return 0;
        }
        if (n > primeList.get(right)) {
            return primeList.size();
        }
        while (left < right) {
            int mid = (left+right)/2;
            if (primeList.get(mid) == n) {
                return mid;
            } else if (primeList.get(mid) < n) {
                if (mid > left) {
                    left = mid;
                } else {
                    left++;
                }
            } else {
                right = mid;
            }
        }
        return left;
    }

    // leetcode 官方题解 线性筛
    public int countPrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                primes.add(i);
            }
            for (int j = 0; j < primes.size() && i * primes.get(j) < n; ++j) {
                isPrime[i * primes.get(j)] = 0;
                if (i % primes.get(j) == 0) {
                    break;
                }
            }
        }
        return primes.size();
    }

    public static void main(String[] args) {
        CountPrimes countPrimes = new CountPrimes();
        /*System.out.println(countPrimes.countPrimes(10));
        System.out.println(countPrimes.countPrimes(3));
        System.out.println(countPrimes.countPrimes(1));*/
        System.out.println(countPrimes.countPrimes(0));

    }
}
