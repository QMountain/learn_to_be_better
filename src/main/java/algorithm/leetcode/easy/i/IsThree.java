package algorithm.leetcode.easy.i;

public class IsThree {

    public boolean isThree(int n) {
        if (n == 1) {
            return false;
        }
        int i = (int) Math.sqrt(n);
        if (i*i != n) {
            return false;
        }
        for (int j = 2; j < i; j++) {
            if (n % j == 0) {
                return false;
            }
        }
        return true;
    }

}
