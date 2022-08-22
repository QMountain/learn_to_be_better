package algorithm.leetcode.easy.s;

public class SumBase {

    public int sumBase(int n, int k) {
        int ans = 0;
        while (n != 0) {
            ans += n % k;
            n /= k;
        }
        return ans;
    }

}
