package algorithm.leetcode.easy.l;

public class LeastMinutes {

    public int leastMinutes(int n) {
        int m = 0;
        while (1 << m < n) {
            m++;
        }
        return m+1;
    }

}
