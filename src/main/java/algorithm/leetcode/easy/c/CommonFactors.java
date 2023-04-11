package algorithm.leetcode.easy.c;

import java.util.HashSet;
import java.util.Set;

public class CommonFactors {

    public int commonFactors(int a, int b) {
        int min = Math.min(a,b);
        int max = Math.max(a,b);
        int remainder = max % min;
        if (remainder == 0) {
            return commonFactors2(a,b);
        }
        return commonFactors(min, remainder);
    }

    public int commonFactors2(int a, int b) {
        int min = Math.min(a,b);
        int sqrt = (int) Math.sqrt(min);
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(min);
        for (int i = 2; i <= sqrt+1; i++) {
            if (min % i == 0) {
                set.add(i);
                set.add(min / i);
            }
        }
        int max = Math.max(a,b);
        int ans = 0;
        for (Integer i : set) {
            if (max % i == 0) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        CommonFactors commonFactors = new CommonFactors();
        System.out.println(4 == commonFactors.commonFactors(32, 408));
        System.out.println(2 == commonFactors.commonFactors(25, 30));
        System.out.println(4 == commonFactors.commonFactors(12, 6));
    }
}
