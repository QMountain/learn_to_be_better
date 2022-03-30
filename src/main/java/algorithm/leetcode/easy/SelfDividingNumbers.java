package algorithm.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>(right-left);
        for (int i = left; i <= right; i++) {
            if (isSelfDividingNumber(i)) {
                list.add(i);
            }
        }
        return list;
    }

    public boolean isSelfDividingNumber(int n) {
        if (n % 10 == 0) {
            return false;
        }
        if (n < 10) {
            return true;
        }
        int p = n;
        while (p > 10) {
            int remainder = p % 10;
            if (n % remainder != 0) {
                return false;
            }
            p /= 10;
            if (p % 10 == 0) {
                return false;
            }
        }
        return n % p == 0;
    }

    public static void main(String[] args) {
        SelfDividingNumbers selfDividingNumbers = new SelfDividingNumbers();
        System.out.println(selfDividingNumbers.selfDividingNumbers(1, 22));
        System.out.println(selfDividingNumbers.selfDividingNumbers(47, 85));
    }
}
