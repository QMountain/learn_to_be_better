package algorithm.leetcode.easy.g;

public class GuessNumber {

    int guess(int num) {
        int target = 6;
        return Integer.compare(num, target);
    }

    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            if (left + 1 == right) {
                int guess = guess(left);
                if (guess == 0) {
                    return left;
                }
                if (guess == -1) {
                    return right;
                }
            }
            int mid = (right-left)/2+left;
            int guess = guess(mid);
            if (guess == 0) {
                return mid;
            }
            if (guess > 0) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return guess(n);
    }

    public static void main(String[] args) {
        GuessNumber guessNumber = new GuessNumber();
        System.out.println(guessNumber.guessNumber(10));
    }
}
