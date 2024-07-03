package algorithm.leetcode.easy.s;

public class SumOfTheDigitsOfHarshadNumber {

    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int originX = x;
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        if (originX % sum == 0) {
            return sum;
        }
        return -1;
    }

}
